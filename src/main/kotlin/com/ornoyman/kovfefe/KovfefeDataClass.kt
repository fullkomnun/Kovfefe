package com.ornoyman.kovfefe

import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KParameter
import kotlin.reflect.full.primaryConstructor

inline fun <reified T : Any> generate(): T = T::class.generate()

fun <T : Any> KClass<T>.generate(): T {

    if (!isData)
        throw Exception("Not data class")

    return doGenerate()
}

private fun <T : Any> KClass<T>.doGenerate(): T {
    return when {
        isData -> genDataClass()
        java.isEnum -> genEnum()
        else -> genFields() as T
    }
}

private fun <T : Any> KClass<T>.genEnum() = java.enumConstants.first()

private fun <T : Any> KClass<T>.genDataClass(): T =
    with(primaryConstructor!!) {
        return callBy(genParams())
    }

private fun <T : Any> KFunction<T>.genParams(): Map<KParameter, Any?> {
    return parameters
        .filter { !it.isOptional }
        .filter { it.type.classifier is KClass<*> }
        .associate {
            it to if (it.type.isMarkedNullable) null
            else (it.type.classifier as KClass<Any>).doGenerate()
        }
}

private fun <T : Any> KClass<T>.genFields(): Any? {
    return when {
        collection.containsKey(qualifiedName) -> collection[qualifiedName]
        basicType.containsKey(qualifiedName) -> basicType[qualifiedName]
        else -> throw IllegalArgumentException("Cannot generate $qualifiedName")
    }
}
