import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val temp = br.readLine().split(' ').map { it.toInt() }
    val list = temp.sorted()
    val stack = Stack<Int>()
    val sb = StringBuilder()
    fun dfs(x: Int) {
        stack.push(x)
        if (stack.size == m) {
            for (i in stack) sb.append("$i ")
            sb.append("\n")
            stack.pop()
            return
        } else {
            var v = x
            for (i in list) {
                if (!stack.contains(i)) {
                    dfs(i)
                }
            }
            stack.pop()
        }
    }
    for (i in list) {
        dfs(i)
    }
    println(sb)
}