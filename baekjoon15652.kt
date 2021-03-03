import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val stack = Stack<Int>()
    fun rec(x: Int) {
        stack.push(x)
        if (stack.size == m) {
            for (i in stack) {
                print("$i ")
            }
            println()
            stack.pop()
        } else if (stack.size < m) {
            for (i in 1..n) {
                if (i >= x) {
                    rec(i)
                }
            }
            stack.pop()
        }
    }
    for (i in 1..n) {
        rec(i)
    }
}