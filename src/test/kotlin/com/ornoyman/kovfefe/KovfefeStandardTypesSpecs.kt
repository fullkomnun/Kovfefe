package com.ornoyman.kovfefe

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

object KovfefeStandardTypesSpecs : Spek({

    listOf(basicTypes, bigNumberTypes, collectionTypes).forEach { types ->

        types.forEach { type, defaultValue ->
            describe("generate ${type.simpleName}") {

                it("should have default value of $defaultValue") {
                    assertEquals(defaultValue, type.generate())
                }
            }
        }
    }
})