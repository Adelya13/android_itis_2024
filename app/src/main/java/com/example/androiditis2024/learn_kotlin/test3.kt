package com.example.androiditis2024.learn_kotlin//package com.example.androiditis2024
//
//import com.example.androiditis2024.NewUser.Companion.USER_NAME
//
//
//fun main(){
//    val cat1 = Cat(name = "Cat1", age = 2)
//    val cat2 = Cat(name = "Cat", age = 2)
//
//    var text: String? = null
//
//    text = "ttttt"
//
//    val age1: Unit = text?.let {
//        println("NOT NULL")
//    } ?: run {
//        println(" NULL")
//        println(" NULL")
//        println(" NULL")
//    }
//
//    val cat = cat2.also { cat ->
//        cat.age
//    }
//
//    println(age1)
//    println(cat)
//
//    val catNew = cat2.apply {
//        age = 4
//        name = USER_NAME
//    }
//
//    val ageNew = cat2.run {
//        age
//    }
//    println(catNew)
//    println(ageNew)
//
//
//    with(cat2){
//        age
//        name
//    }
//
//
//    cat2.sex = true
//    cat1.sex = false
//
////    println(cat1 == cat2)
//
//
//    val (name, age) =  Cat(name = "Cat", age = 2).copy(
//        age = 5
//    )
//
////    println(age)
//
//    val user = USER_NAME
//
//
//}
//
//
//interface B{
//    val counter: Int
//    fun c()
//
//}
//
//
//class NewUser{
//
//    val phone: String  = ""
//
//      inner class Student(){
//        init{
//            phone
//        }
//    }
//
//
//    companion object{
//        const val USER_NAME = "Yan"
//    }
//}
//
//
//data class Cat(
//    var name: String,
//    var age: Int,
////    val listener: () -> Unit
//){
//    var sex: Boolean = false
//}
//
//private fun hasPostingWidget(operation: OperationDetails, callback: () -> Boolean) {
//
//}
//
//fun callback(result: Boolean): Boolean = result
//
//
//fun main(){
//
//    var aboba =
//    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
//
//    scope.launch {
//        val result = postEditorAvailabilityChecker
//            .isPostEditorWidgetShown(operation, true)
//            .first()
//
//        Log.e("aboba", result.toString())
//
//
//    }
//
//    aboba
//}
//
//
