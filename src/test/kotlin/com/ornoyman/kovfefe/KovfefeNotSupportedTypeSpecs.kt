package com.ornoyman.kovfefe

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertFailsWith

object KovfefeNotSupportedTypeSpecs : Spek({

    val notSupportedType = Comparator::class
    describe("generate not supported type: $notSupportedType") {

        it("should fail with ${UnsupportedTypeException::class}") {
            assertFailsWith(UnsupportedTypeException::class) {
                notSupportedType.generate()
            }
        }
    }
})