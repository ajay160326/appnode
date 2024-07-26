@Deprecated("this fucntion is deprecated", ReplaceWith("function b"))
fun a() {
    println("a")
}

fun b() {
    println("b")
}

fun main() {
    println(a())
}