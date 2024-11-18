package com.example.androiditis2024.learn_kotlin

import kotlin.jvm.Throws


fun main() {
    println("Hello")

    val a = arrayListOf<Int>()
    a.add(3)
    var ab: Int? = null
    ab = 3

    println(test(a = 0 , b = 5))

    val v: Int? = null


    val list = arrayListOf<String>()
    val list1 = arrayListOf<String>()

    list1.add("27272")

    list.size

    list.add("1111")
    println(list[0])
    list.size
    list.addAll(list1)


    list.forEach{ el ->
        println(el)
    }
    println(list)
    try{
        test1(1)
    } catch (e: Exception){
        println(e.message)
    }

    val map = mapOf(1 to "ddddd")

    map.getValue(1)

    val set = setOf(1, 2 , 3, 1, 2)

    println(set)


    val user: User? = User("null", 12)

    val ex: String? = "Name"
    val length: Int = ex?.length ?: -1


    val s1 = Student("Alena", "aaaa")
    val s2 = Student("Yan", "333")
    val s3 = Student("Anna", "33")

    s1.say("aaaaa")
    s2.say("ddddd")
    s3.say("gggggg")

    println("${s1.nameLength}")
    println("${s2.nameLength}")
    println("${s3.nameLength}")


    println("""\.""".toRegex())


    val view: View = Button()

    view.click()
    view.showName()

}

infix fun Int.plus(a: Int) = this+a

fun test(a: Int = 4, b: Int) = "$a + $b = ${a+b}"

fun max(a: Int = 4, b: Int) = if (a>b) a else b

fun test3() {
    println("Hello")
}

@Throws
fun test1(a: Int){
    var b: Unit = when(a){
        1 -> {
            throw IndexOutOfBoundsException("Exception!")
        }

        else -> {
        }
    }

}
abstract class People

open class User(
    open var name: String,
    var age: Int = 18
) : People(){

     protected val isChild: Boolean
        get() {
            return age in 0..18
        }

    open fun sleep(){}
}



class Student(
    override var name: String,
    var email: String
): User(name), Eat {

    init {
        println("Hahaha")
    }

    override fun sleep() {
        super.sleep()
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

}

fun Student.say(message: String) = println("$name: $message")
val Student.nameLength: Int
    get() = name.length


interface Eat {
    fun eat()
}


open class View(){
    open fun click(){
        println("view clicked")
    }
}

class Button(): View(){
    override fun click() {
        println("button clicked")
    }
}

fun View.showName() = println("i am view")
fun Button.showName() = println("i am button")
