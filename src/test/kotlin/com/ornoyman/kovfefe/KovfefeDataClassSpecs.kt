package com.ornoyman.kovfefe

import org.jetbrains.spek.api.Spek

object KovfefeDataClassSpecs: Spek({
    //    describe("Generate data class") {
//        data class BasicType(
//            val string: String,
//            val int: Int,
//            val long: Long,
//            val float: Float,
//            val boolean: Boolean,
//            val double: Double,
//            val char: Char,
//            val byte: Byte
//        )
//
//        on("Data class with basic types") {
//            xit("Should generate") {
//                val foo = generate<BasicType>()
//                assertTrue { !foo.boolean }
//                assertTrue { foo.string.isEmpty() }
//                assertTrue { foo.int == 0 }
//                assertTrue { foo.long == 0L }
//                assertTrue { foo.float == 0.0f }
//                assertTrue { foo.double == 0.0 }
//                assertTrue { foo.char == 'a' }
//                println(foo)
//            }
//
//            xit("Should generate with default value") {
//                val foo = generate<BasicType>()
//                println(foo)
//            }
//
//            xit("Kotlin default value") {
//                data class BasicTypeDefaults(
//                    val string: String = "kovfefe",
//                    val int: Int = 42,
//                    val long: Long = 42L,
//                    val float: Float = 42.5f,
//                    val boolean: Boolean = true,
//                    val double: Double = 42.5,
//                    val char: Char = 'b',
//                    val byte: Byte = Byte.MIN_VALUE
//                )
//
//                val foo = generate<BasicTypeDefaults>()
//                assertTrue { foo.boolean }
//                assertTrue { foo.string == "kovfefe" }
//                assertTrue { foo.int == 42 }
//                assertTrue { foo.long == 42L }
//                assertTrue { foo.float == 42.5f }
//                assertTrue { foo.double == 42.5 }
//                assertTrue { foo.char == 'b' }
//                println(foo)
//            }
//        }
//    }
})