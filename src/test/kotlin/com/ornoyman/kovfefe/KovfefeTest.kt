package com.ornoyman.kovfefe

import org.junit.Test
import java.math.BigDecimal

enum class Pokemon { Squirtle, Bulbasaur, Charmander }

data class Goo(val num: Long, val kuku: BigDecimal, val opt: String = "yey", val pokemon: Pokemon)

data class Foo(
//    val name: String,
//    val age: Int = 31,
//    val nickname: String?,
    val hashMap: HashMap<Int, Int>
//    val list: List<String>
//    val letter: Char,
//    val b: Byte,
//    val bi: BigInteger,
//    val bd: BigDecimal,
//    val goo: Goo
)

class KovfefeTest {

    @Test
    fun test() {
        val name = "ruby"
        val foo = generate<Foo>().copy()
//        var a = foo.list.get(1)
        println(foo)
        val a = hashMapOf<Any, Any>()
//        val a = KFunction
//        val list = mutableListOf<Any>()
//        list.add(1)
//        list.add("hi")
//        (MutableList<String>)list)
//        println(list)
    }


}