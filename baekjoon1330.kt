import java.util.Scanner

fun main(){
    val sc:Scanner = Scanner(System.`in`)
    val a = sc.nextInt()
    val b = sc.nextInt()
    when {
        a>b -> {
            println(">")
        }
        a<b -> {
            println("<")
        }
        else -> {
            println("==")
        }
    }
}