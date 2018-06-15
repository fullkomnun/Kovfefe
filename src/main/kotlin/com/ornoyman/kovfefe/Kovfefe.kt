package com.ornoyman.kovfefe

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.full.primaryConstructor

inline fun <reified T : Any> generate(): T = T::class.generate()

fun <T : Any> KClass<T>.generate(): T = when {
    isData -> generateDataClass()
    isTopLevelAutoValue -> generateTopLevelAutoValue()
    isNestedAutoValue -> generateNestedAutoValue()
    java.isEnum -> java.enumConstants.first()
    basicTypes.containsKey(this) -> basicTypes[this] as T
    bigNumberTypes.containsKey(this) -> bigNumberTypes[this] as T
    collectionTypes.containsKey(this) -> collectionTypes[this] as T
    else -> throw IllegalArgumentException("Cannot generate $qualifiedName")
}

private fun <T : Any> KClass<T>.generateDataClass(): T = primaryConstructor!!.invoke()

internal fun <T : Any> KFunction<T>.invoke(): T = callBy(generateParameters())

private fun <T : Any> KFunction<T>.generateParameters(): Map<KParameter, Any?> =
    parameters
        .filter { !it.isOptional }
        .filter { it.type.classifier is KClass<*> }
        .associate { it to generateParameter(it) }

private fun generateParameter(it: KParameter) =
    if (it.type.isMarkedNullable) null
    else (it.type.classifier as KClass<*>).generate()