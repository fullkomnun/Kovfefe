package com.ornoyman.kovfefe

import org.junit.Test

enum class Pokemon { Squirtle, Bulbasaur, Charmander }


data class BasicType(
    val string: String,
    val int: Int,
    val long: Long,
    val float: Float,
    val boolean: Boolean,
    val double: Double,
    val char: Char,
    val byte: Byte
)

class KovfefeTest {

    @Test
    fun testBasicType() {
        val foo = generate<BasicType>()
        println(foo)
    }
}