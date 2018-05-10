//package com.ornoyman.kovfefe
//
//import java.lang.reflect.Modifier
//import java.math.BigDecimal
//import java.math.BigInteger
//import java.time.LocalDate
//import java.time.LocalDateTime
//import java.time.LocalTime
//import java.time.ZonedDateTime
//import kotlin.reflect.KClass
//import kotlin.reflect.KFunction
//import kotlin.reflect.full.primaryConstructor
//import kotlin.reflect.jvm.isAccessible
//
//inline fun <reified T : Any> generate(): T = T::class.generate()
//
//fun <T : Any> KClass<T>.generate(): T =
//    when {
//        isData -> generateDataClass()
//        isTopLevelAutoValue -> generateTopLevelAutoValue()
//        isNestedAutoValue -> generateNestedAutoValue()
//        java.isEnum -> java.enumConstants.first()
//        else -> doGenerate() as T
//    }
//
//private fun <T : Any> KClass<T>.generateTopLevelAutoValue(): T {
//    val c = Class.forName("${java.`package`.name}.AutoValue_${java.simpleName}").kotlin
//    val con = c.constructors.first().apply { isAccessible = true }
//    return con.invoke() as T
//}
//
//private fun <T : Any> KClass<T>.generateNestedAutoValue(): T {
//    val c = Class.forName(
//        "${java.`package`.name}.AutoValue_${java.enclosingClass.simpleName}_${java.simpleName}").kotlin
//    val con = c.constructors.first().apply { isAccessible = true }
//    return con.invoke() as T
//}
//
//private val <T : Any> KClass<T>.isTopLevelAutoValue
//    get() =
//        isAbstract && !java.isMemberClass && java.`package` != null &&
//                isClass("${java.`package`.name}.AutoValue_${java.simpleName}")
//
//private val <T : Any> KClass<T>.isNestedAutoValue
//    get() =
//        isAbstract && java.isMemberClass && isStatic && java.`package` != null &&
//                isClass(
//                    "${java.`package`.name}.AutoValue_${java.enclosingClass.simpleName}_${java.simpleName}")
//
//private val <T : Any> KClass<T>.isStatic get() = Modifier.isStatic(java.modifiers)
//
//private fun isClass(className: String): Boolean =
//    try {
//        Class.forName(className)
//        true
//    } catch (e: Exception) {
//        false
//    }
//
//private fun <T : Any> KClass<T>.generateDataClass(): T = primaryConstructor!!.invoke()
//
//private fun <T : Any> KFunction<T>.invoke(): T {
//    val params = parameters
//        .filter { !it.isOptional }
//        .filter { it.type.classifier is KClass<*> }
//        .associate {
//            it to if (it.type.isMarkedNullable) null
//            else (it.type.classifier as KClass<*>).generate()
//        }
//    return callBy(params)
//}
//
//private fun <T : Any> KClass<T>.doGenerate(): Any =
//    when (qualifiedName) {
//        List::class.qualifiedName -> listOf<T>()
//        Set::class.qualifiedName -> setOf<T>()
//        else -> forClassName(qualifiedName!!)
//    }
//
//private fun forClassName(className: String): Any =
//    when (className) {
//        "org.threeten.bp.LocalDate" -> LocalDate.now()
//        "org.threeten.bp.LocalDateTime" -> LocalDateTime.now()
//        "org.threeten.bp.LocalTime" -> LocalTime.now()
//        "org.threeten.bp.ZonedDateTime" -> ZonedDateTime.now()
//        "java.math.BigInteger" -> BigInteger.ZERO
//        "java.math.BigDecimal" -> BigDecimal.ZERO
//        "java.lang.String" -> ""
//        "kotlin.String" -> ""
//        "java.lang.Integer" -> 0
//        "kotlin.Int" -> 0
//        "java.lang.Long" -> 0L
//        "kotlin.Long" -> 0L
//        "java.lang.Boolean" -> false
//        "kotlin.Boolean" -> false
//        "java.lang.Float" -> 0.0f
//        "kotlin.Float" -> 0.0f
//        "java.lang.Double" -> 0.0
//        "kotlin.Double" -> 0.0
//        "java.lang.Character" -> 'a'
//        "kotlin.Char" -> 'a'
//        "java.lang.Byte" -> Byte.MAX_VALUE
//        "kotlin.Byte" -> Byte.MAX_VALUE
//        else -> throw IllegalArgumentException("Cannot generate $className")
//    }