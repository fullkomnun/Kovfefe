package com.ornoyman.kovfefe

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertFailsWith

object KovfefeUnsupportedTypeSpecs : Spek({

    val unsupportedType = Comparator::class
    describe("generate not supported type: $unsupportedType") {

        it("should fail with ${UnsupportedTypeException::class}") {
            assertFailsWith(UnsupportedTypeException::class) {
                unsupportedType.generate()
            }
        }
    }
})