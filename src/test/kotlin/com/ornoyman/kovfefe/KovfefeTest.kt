package com.ornoyman.kovfefe

import org.junit.Test
import java.math.BigDecimal
import java.math.BigInteger
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZonedDateTime

enum class Pokemon { Squirtle, Bulbasaur, Charmander }

data class Goo(val num: Long, val kuku: BigDecimal, val opt: String = "yey", val pokemon: Pokemon)

data class Foo(
    val name: String,
    val age: Int = 31,
    val ld: LocalDate,
    val l: LocalDateTime,
    val zdt: ZonedDateTime,
    val nickname: String?,
    val list: List<Double>,
    val letter: Char,
    val b: Byte,
    val bi: BigInteger,
    val bd: BigDecimal,
    val goo: Goo
)

class KovfefeTest {

    @Test
    fun test() {
        println("Success")
//        println(BIConversion.User::class.generate())
    }
}

// output: User{name=, age=0, money=0, double=0.0, foo=Foo(name=, age=31, ld=2018-02-22,
//              l=2018-02-22T09:02:26.110, zdt=2018-02-22T09:02:26.114+02:00[Asia/Jerusalem], nickname=null, list=[],
//              letter=a, b=127, bi=0, bd=0, goo=Goo(num=0, kuku=0, opt=yey, pokemon=Squirtle)),
//              it=Nested{names=[], uniqueNames=[]}}