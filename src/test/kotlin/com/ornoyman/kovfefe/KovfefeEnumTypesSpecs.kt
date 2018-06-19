package com.ornoyman.kovfefe

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

object KovfefeEnumTypesSpecs : Spek({

    describe("generate enum of type ${SomeEnum::class.simpleName}") {
        it("should have the value of the first enum constant (${SomeEnum.ENUM_CONST1})") {
            assertEquals(SomeEnum.ENUM_CONST1, generate())
        }
    }
}) {
    private enum class SomeEnum {
        ENUM_CONST1, ENUM_CONST2, ENUM_CONST3
    }
}