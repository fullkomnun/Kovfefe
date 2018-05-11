package com.ornoyman.kovfefe

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object CreateMatcherTest : Spek({
    describe("Generate data class") {
        on("Data class with basic types") {
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

            it("Should generate") {
                val foo = generate<BasicType>()
                println(foo)
            }
        }
    }
})
