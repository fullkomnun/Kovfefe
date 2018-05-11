package com.ornoyman.kovfefe

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertTrue

object KovfefeSpecs : Spek({
    describe("Generate data class") {
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

        on("Data class with basic types") {
            it("Should generate") {
                val foo = generate<BasicType>()
                assertTrue { !foo.boolean }
                assertTrue { foo.string.isEmpty() }
                assertTrue { foo.int == 0 }
                assertTrue { foo.long == 0L }
                assertTrue { foo.float == 0.0f }
                assertTrue { foo.double == 0.0 }
                assertTrue { foo.char == 'a' }
                println(foo)
            }

            it("Should generate with default value") {
                val foo = generate<BasicType>()
                println(foo)
            }

            it("Kotlin default value") {
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

                val foo = generate<BasicTypeDefaults>()
                assertTrue { foo.boolean }
                assertTrue { foo.string == "kovfefe" }
                assertTrue { foo.int == 42 }
                assertTrue { foo.long == 42L }
                assertTrue { foo.float == 42.5f }
                assertTrue { foo.double == 42.5 }
                assertTrue { foo.char == 'b' }
                println(foo)
            }
        }

        on("nested class") {
            data class NestedBasicType(
                val basicType: BasicType
            )

            it("Should generate") {
                val foo = generate<NestedBasicType>()
                println(foo)
            }
        }
        on("collections") {
            data class CollectionsType(
                val List: List<String>,
                val Set: Set<Int>,
                val Map: Map<String, String>,
                val HashMap: HashMap<Long, String>,
                val LinkedHashSet: LinkedHashSet<String>,
                val ArrayList: ArrayList<String>,
                val LinkedHashMap: LinkedHashMap<Double, String>
            )

            it("Should generate") {
                val foo = generate<CollectionsType>()
                println(foo)
            }
        }
        on("enum") {}
    }
})
