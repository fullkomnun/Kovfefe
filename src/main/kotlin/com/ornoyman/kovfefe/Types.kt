package com.ornoyman.kovfefe


internal val collection = hashMapOf(
    List::class.qualifiedName to listOf<Any>(),
    Set::class.qualifiedName to setOf<Any>(),
    Map::class.qualifiedName to mapOf<Any, Any>(),
    HashMap::class.qualifiedName to hashMapOf<Any, Any>(),
    LinkedHashSet::class.qualifiedName to linkedSetOf<Any>()
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


/*    "java.lang.String" -> ""
"java.lang.Integer" -> 0
"java.lang.Long" -> 0L
"java.lang.Boolean" -> false
"java.lang.Float" -> 0.0f
"java.lang.Double" -> 0.0
"java.lang.Character" -> 'a'
"java.lang.Byte" -> Byte.MAX_VALUE
*/