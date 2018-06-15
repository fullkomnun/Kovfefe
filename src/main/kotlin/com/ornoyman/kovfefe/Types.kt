package com.ornoyman.kovfefe

import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

internal val basicTypes = hashMapOf(
    String::class to "",
    Int::class to 0,
    Long::class to 0L,
    Float::class to 0.0f,
    Boolean::class to false,
    Double::class to 0.0,
    Char::class to 'a',
    Byte::class to Byte.MAX_VALUE
)

internal val bigNumberTypes = hashMapOf(
    BigInteger::class to BigInteger.ZERO,
    BigDecimal::class to BigDecimal.ZERO
)

internal val collectionTypes = hashMapOf(
    List::class to listOf<Any>(),
    MutableList::class to mutableListOf<Any>(),
    ArrayList::class to arrayListOf<Any>(),
    LinkedList::class to LinkedList<Any>(),
    Set::class to setOf<Any>(),
    MutableSet::class to mutableSetOf<Any>(),
    LinkedHashSet::class to linkedSetOf<Any>(),
    TreeSet::class to sortedSetOf<Any>(),
    Map::class to mapOf<Any, Any>(),
    MutableMap::class to mutableMapOf<Any, Any>(),
    HashMap::class to hashMapOf<Any, Any>(),
    LinkedHashMap::class to linkedMapOf<Any, Any>()
)