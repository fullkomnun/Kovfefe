package com.ornoyman.kovfefe


internal val collection = hashMapOf(
    List::class.qualifiedName to listOf<Any>(),
    Set::class.qualifiedName to setOf<Any>(),
    Map::class.qualifiedName to mapOf<Any, Any>(),
    HashMap::class.qualifiedName to hashMapOf<Any, Any>(),
    LinkedHashSet::class.qualifiedName to linkedSetOf<Any>(),
    ArrayList::class.qualifiedName to arrayListOf<Any>(),
    LinkedHashMap::class.qualifiedName to linkedMapOf<Any, Any>()
)

internal val kotlinType = hashMapOf(
    Pair::class.qualifiedName to Pair<Any, Any>(Unit, Unit),
    Triple::class.qualifiedName to Triple<Any, Any, Any>(Unit, Unit, Unit)
)

internal val basicType = hashMapOf(
    String::class.qualifiedName to "",
    Int::class.qualifiedName to 0,
    Long::class.qualifiedName to 0L,
    Float::class.qualifiedName to 0.0f,
    Boolean::class.qualifiedName to false,
    Double::class.qualifiedName to 0.0,
    Char::class.qualifiedName to 'a',
    Byte::class.qualifiedName to Byte.MAX_VALUE
)

/*
*
* private fun forClassName(className: String): Any =
    when (className) {
        "org.threeten.bp.LocalDate" -> LocalDate.now()
        "org.threeten.bp.LocalDateTime" -> LocalDateTime.now()
        "org.threeten.bp.LocalTime" -> LocalTime.now()
        "org.threeten.bp.ZonedDateTime" -> ZonedDateTime.now()
        "java.math.BigInteger" -> BigInteger.ZERO
        "java.math.BigDecimal" -> BigDecimal.ZERO
        "java.lang.String" -> ""
        "kotlin.String" -> ""
        "java.lang.Integer" -> 0
        "kotlin.Int" -> 0
        "java.lang.Long" -> 0L
        "kotlin.Long" -> 0L
        "java.lang.Boolean" -> false
        "kotlin.Boolean" -> false
        "java.lang.Float" -> 0.0f
        "kotlin.Float" -> 0.0f
        "java.lang.Double" -> 0.0
        "kotlin.Double" -> 0.0
        "java.lang.Character" -> 'a'
        "kotlin.Char" -> 'a'
        "java.lang.Byte" -> Byte.MAX_VALUE
        "kotlin.Byte" -> Byte.MAX_VALUE
        else -> throw IllegalArgumentException("Cannot generate $className")
    }*/
/*    "java.lang.String" -> ""
"java.lang.Integer" -> 0
"java.lang.Long" -> 0L
"java.lang.Boolean" -> false
"java.lang.Float" -> 0.0f
"java.lang.Double" -> 0.0
"java.lang.Character" -> 'a'
"java.lang.Byte" -> Byte.MAX_VALUE
*/