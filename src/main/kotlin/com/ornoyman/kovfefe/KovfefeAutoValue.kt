package com.ornoyman.kovfefe

import java.lang.Class.forName
import java.lang.reflect.Modifier
import kotlin.reflect.KClass
import kotlin.reflect.jvm.isAccessible


internal fun <T : Any> KClass<T>.generateTopLevelAutoValue(): T {
    val c =  forName("${java.`package`.name}.AutoValue_${java.simpleName}").kotlin
    val con = c.constructors.first().apply { isAccessible = true }
    return con.invoke() as T
}

internal fun <T : Any> KClass<T>.generateNestedAutoValue(): T {
    val c = forName(
        "${java.`package`.name}.AutoValue_${java.enclosingClass.simpleName}_${java.simpleName}").kotlin
    val con = c.constructors.first().apply { isAccessible = true }
    return con.invoke() as T
}

internal val <T : Any> KClass<T>.isTopLevelAutoValue
    get() =
        isAbstract && !java.isMemberClass && java.`package` != null &&
                isClass("${java.`package`.name}.AutoValue_${java.simpleName}")

internal val <T : Any> KClass<T>.isNestedAutoValue
    get() =
        isAbstract && java.isMemberClass && isStatic && java.`package` != null &&
                isClass(
                    "${java.`package`.name}.AutoValue_${java.enclosingClass.simpleName}_${java.simpleName}")

internal val <T : Any> KClass<T>.isStatic get() = Modifier.isStatic(java.modifiers)


internal fun isClass(className: String): Boolean =
    try {
        Class.forName(className)
        true
    } catch (e: Exception) {
        false
    }