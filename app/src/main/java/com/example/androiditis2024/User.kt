package com.example.androiditis2024

class User(val name: String) {

    operator fun plusAssign(user: User) {
        println(this.name + user. name)
    }
}

object Test {
    operator fun invoke(action: StringBuilder.() -> Unit) {
        StringBuilder().apply{
            append("Hello")
            action()
        }
    }
}