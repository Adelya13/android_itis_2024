fun main() {

}


fun testA(){

    testB(value = 1) { index, name ->
        "$index $name"




    }

//    result = "$index $name"


}

inline fun testB(value: Int, crossinline action: (Int, String) -> String): String{
    val result = action(1, "Name")

    return result
}