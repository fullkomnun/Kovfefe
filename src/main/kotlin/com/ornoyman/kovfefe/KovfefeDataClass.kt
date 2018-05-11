package com.ornoyman.kovfefe

import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.javaMethod

inline fun <reified T : Any> generate(): T = T::class.generate()

fun <T : Any> KClass<T>.generate(): T =
    when {
        isData -> genDataClass()
        java.isEnum -> genEnum()
        else -> doGen() as T
    }

private fun <T : Any> KClass<T>.genEnum() = java.enumConstants.first()

private fun <T : Any> KClass<T>.genDataClass(): T = primaryConstructor!!.invoke()

private fun <T : Any> KFunction<T>.invoke(): T {
    val params = parameters
        .filter { !it.isOptional }
        .filter { it.type.classifier is KClass<*> }
        .associate {
            it to if (it.type.isMarkedNullable) null
            else (it.type.classifier as KClass<*>).generate()
        }
    return callBy(params)
}

private fun <T : Any> KClass<T>.doGen(): Any {
    return if (isCollectionsFunction(qualifiedName!!)) {
        callFunction("kotlin.collections.Maps", qualifiedName!!.extractFunctionName())!!
    } else {
        forClassName(qualifiedName!!)
    }
}

fun isCollectionsFunction(string: String): Boolean {
    return string.startsWith("java.util.")
}

fun getFunctionFromFile(fileName: String, funcName: String): Method? {
    val selfRef = ::getFunctionFromFile
    val currentClass = selfRef.javaMethod!!.declaringClass
    val classDefiningFunctions = currentClass.classLoader.loadClass("${fileName}Kt")
    return classDefiningFunctions.methods.find { it.name == funcName && Modifier.isStatic(it.modifiers) }
}

fun callFunction(fileName: String, funcName: String): Any? {
    return getFunctionFromFile(fileName, funcName)!!.invoke(null, null)
}

private fun String.extractFunctionName() =
    substringAfterLastDot().lowerCaseFirstChar() + "Of"

private fun String.substringAfterLastDot() =
    substringAfterLast('.')

private fun String.lowerCaseFirstChar() =
    substring(0, 1).toLowerCase() + substring(1)

private fun forClassName(className: String): Any =
    when (className) {
        "java.math.BigInteger" -> BigInteger.ZERO
        "java.math.BigDecimal" -> BigDecimal.ZERO
        "java.lang.String" -> ""
        "java.lang.Integer" -> 0
        "java.lang.Long" -> 0L
        "java.lang.Boolean" -> false
        "java.lang.Float" -> 0.0f
        "java.lang.Double" -> 0.0
        "java.lang.Character" -> 'a'
        "java.lang.Byte" -> Byte.MAX_VALUE
        "kotlin.String" -> ""
        "kotlin.Int" -> 0
        "kotlin.Long" -> 0L
        "kotlin.Float" -> 0.0f
        "kotlin.Boolean" -> false
        "kotlin.Double" -> 0.0
        "kotlin.Char" -> 'a'
        "kotlin.Byte" -> Byte.MAX_VALUE
        else -> throw IllegalArgumentException("Cannot generate $className")
    }