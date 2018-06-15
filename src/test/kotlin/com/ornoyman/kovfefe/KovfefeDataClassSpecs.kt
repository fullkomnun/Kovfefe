package com.ornoyman.kovfefe

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

object KovfefeDataClassSpecs : Spek({
    describe("Generate data class") {
        data class BasicType(val string: String)

        on("Data class") {
            it("Should generate ") {
                val generated = generate<BasicType>()
                assertNotNull(generated)
            }

            it("Should generate with default value") {
                data class BasicTypeDefaults(
                    val string: String = "kovfefe",
                    val int: Int = 42,
                    val long: Long = 42L,
                    val float: Float = 42.5f,
                    val boolean: Boolean = true,
                    val double: Double = 42.5,
                    val char: Char = 'b',
                    val byte: Byte = Byte.MIN_VALUE
                )

                val generated = generate<BasicTypeDefaults>()
                assertTrue { generated.boolean }
                assertTrue { generated.string == "kovfefe" }
                assertTrue { generated.int == 42 }
                assertTrue { generated.long == 42L }
                assertTrue { generated.float == 42.5f }
                assertTrue { generated.double == 42.5 }
                assertTrue { generated.char == 'b' }
            }
        }
    }
})