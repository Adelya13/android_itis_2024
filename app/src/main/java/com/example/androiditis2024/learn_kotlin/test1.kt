package com.example.androiditis2024.learn_kotlin

import kotlin.jvm.Throws


fun main(){
    val a = arrayListOf(1,2,3)
    a.add(2)

    val b = a
    a.remove(2)

    println()
    println(a)
    println(b)
    println(a==b)
    println(a===b)

    example.add("dddd")
    val f = AB.As(23)

    val aa = "ddd"

    println("sjshjshsh".addPointInTheEnd())
    println(aa.addPointInTheEnd())


    val student = Student1(
        name = "Yan",
        email = "aaaaa",
        studentClass = 4
    )

    val user = User1(
        name = student.name,
        email = student.email
    )


    println(student.toUser1())


    val view: View = Button()
    val btn = Button()
    view.click()
    view.showName()
    btn.showName()

    //что будет выведено??


    println("ddkdkdkdk".lastSimbol)
    println("ddkdkdkdk".last())


    val aww = 1

    println(aww to aww)

    println("""${'$'}99.9""")

    printAll("sss", "ddd", "ddddd")

}

fun String.addPointInTheEnd(): String = "$this ."

val String.lastSimbol: Char
    get() = this[lastIndex]



@Throws(IllegalArgumentException::class)
fun exceptionTest(){
    throw IllegalArgumentException()
}

const val EXAMPLE = "22.00.11"
val example = arrayListOf("aaaa")


data class User1(
    var name: String,
    val email: String
)

data class Student1(
    val name: String,
    val email: String,
    val studentClass: Int, // 1-11
)

fun Student1.toUser1() = User1(
    name = name,
    email = email
)



//open class View(){
//    open fun click(){
//        println("view clicked")
//    }
//}
//
//class Button(): View(){
//    override fun click() {
//        println("button clicked")
//    }
//}
//
//fun View.showName() = println("i am view")
//fun Button.showName() = println("i am button")


fun createUser(user: User1): Boolean{
    fun validate(value: String): Boolean = value.isEmpty()

    return validate(user.name) && validate(user.email)
}


fun printAll(vararg a : String){
    a.forEach {
        println(it)
    }
}

sealed class AB {

    data class As(val a: Int): AB()

    data object Ad: AB()

}

class A{

    val av: Int = 9

       inner class B{
         fun click(){
            println()
        }

    }
}

