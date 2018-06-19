package com.ornoyman.kovfefe

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

object KovfefeDataClassSpecs : Spek({
    describe("generate data class of type ${BasicDataClass::class.simpleName} with properties of basic types") {
        it("should generate an instance of ${BasicDataClass::class.simpleName} with default values for basic types") {
            generate<BasicDataClass>().apply {
                assertEquals("", string)
                assertEquals(0, int)
                assertEquals(0L, long)
                assertEquals(0.0f, float)
                assertEquals(false, boolean)
                assertEquals(0.0, double)
                assertEquals('a', char)
                assertEquals(Byte.MAX_VALUE, byte)
            }
        }
    }

    describe("generate data class of type ${BasicDataClassWithDefaults::class.simpleName} with properties of basic types with defaults") {
        it("should generate an instance of ${BasicDataClassWithDefaults::class.simpleName} with specified default values") {
            generate<BasicDataClassWithDefaults>().apply {
                assertEquals("kovfefe", string)
                assertEquals(42, int)
                assertEquals(42L, long)
                assertEquals(42.5f, float)
                assertEquals(true, boolean)
                assertEquals(42.5, double)
                assertEquals('b', char)
                assertEquals(Byte.MIN_VALUE, byte)
            }
        }
    }

    describe("generate data class of type ${BasicDataClassNullables::class.simpleName} with properties of nullable basic types") {
        it("should generate an instance of ${BasicDataClassNullables::class.simpleName} with null values for basic types") {
            generate<BasicDataClassNullables>().apply {
                assertEquals(null, string)
                assertEquals(null, int)
                assertEquals(null, long)
                assertEquals(null, float)
                assertEquals(null, boolean)
                assertEquals(null, double)
                assertEquals(null, char)
                assertEquals(null, byte)
            }
        }
    }

    describe("generate data class of type ${BasicDataClassNullablesWithDefaults::class.simpleName} with properties of nullable basic types with defaults") {
        it("should generate an instance of ${BasicDataClassNullablesWithDefaults::class.simpleName} with specified default values") {
            generate<BasicDataClassNullablesWithDefaults>().apply {
                assertEquals("kovfefe", string)
                assertEquals(42, int)
                assertEquals(42L, long)
                assertEquals(42.5f, float)
                assertEquals(true, boolean)
                assertEquals(42.5, double)
                assertEquals('b', char)
                assertEquals(Byte.MIN_VALUE, byte)
            }
        }
    }

    describe("generate data class of type ${BasicDataClassNullablesAndDefaultsMix::class.simpleName} with properties of (nullable) basic types (with default)") {
        it("should generate an instance of ${BasicDataClassNullablesAndDefaultsMix::class.simpleName} with default value if specified, otherwise null if nullable, otherwise default of type") {
            generate<BasicDataClassNullablesAndDefaultsMix>().apply {
                assertEquals("kovfefe", string)
                assertEquals(0, int)
                assertEquals(null, intNullable)
                assertEquals(42, intWithDefault)
                assertEquals(42, intNullableWithDefault)
                assertEquals(42L, long)
                assertEquals(null, float)
                assertEquals(true, boolean)
                assertEquals(0.0, double)
                assertEquals(null, char)
                assertEquals(Byte.MIN_VALUE, byte)
            }
        }
    }
}) {
    internal data class BasicDataClass(
        val string: String,
        val int: Int,
        val long: Long,
        val float: Float,
        val boolean: Boolean,
        val double: Double,
        val char: Char,
        val byte: Byte
    )

    internal data class BasicDataClassWithDefaults(
        val string: String = "kovfefe",
        val int: Int = 42,
        val long: Long = 42L,
        val float: Float = 42.5f,
        val boolean: Boolean = true,
        val double: Double = 42.5,
        val char: Char = 'b',
        val byte: Byte = Byte.MIN_VALUE
    )

    internal data class BasicDataClassNullables(
        val string: String?,
        val int: Int?,
        val long: Long?,
        val float: Float?,
        val boolean: Boolean?,
        val double: Double?,
        val char: Char?,
        val byte: Byte?
    )

    internal data class BasicDataClassNullablesWithDefaults(
        val string: String? = "kovfefe",
        val int: Int? = 42,
        val long: Long? = 42L,
        val float: Float? = 42.5f,
        val boolean: Boolean? = true,
        val double: Double? = 42.5,
        val char: Char? = 'b',
        val byte: Byte? = Byte.MIN_VALUE
    )

    internal data class BasicDataClassNullablesAndDefaultsMix(
        val string: String = "kovfefe",
        val int: Int,
        val intNullable: Int?,
        val intWithDefault: Int = 42,
        val intNullableWithDefault: Int? = 42,
        val long: Long? = 42L,
        val float: Float?,
        val boolean: Boolean? = true,
        val double: Double,
        val char: Char?,
        val byte: Byte = Byte.MIN_VALUE
    )
}