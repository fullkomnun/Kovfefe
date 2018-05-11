package com.ornoyman.kovfefe

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.full.primaryConstructor

inline fun <reified T : Any> generate(): T = T::class.generate()

fun <T : Any> KClass<T>.generate(): T = when {
    isData -> generateDataClass()
    isTopLevelAutoValue -> generateTopLevelAutoValue()
    isNestedAutoValue -> generateNestedAutoValue()
    java.isEnum -> java.enumConstants.first()
    else -> genFields() as T
}

private fun <T : Any> KClass<T>.generateDataClass(): T = primaryConstructor!!.invoke()

internal fun <T : Any> KFunction<T>.invoke(): T {
    val params = parameters
        .filter { !it.isOptional }
        .filter { it.type.classifier is KClass<*> }
        .associate {
            it to if (it.type.isMarkedNullable) null
            else (it.type.classifier as KClass<*>).generate()
        }
    return callBy(params)
}

private fun <T : Any> KClass<T>.genFields(): Any? {
    return when {
        collection.containsKey(qualifiedName) -> collection[qualifiedName]
        basicType.containsKey(qualifiedName) -> basicType[qualifiedName]
        else -> throw IllegalArgumentException("Cannot generate $qualifiedName")
    }
}

