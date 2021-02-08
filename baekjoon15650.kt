import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.Buffer
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(' ').map { it -> it.toInt() }
    val stack = Stack<Int>()
    val numList = Array(n) { it -> it + 1 }
    fun rec(x: Int) {
        stack.push(x)
        if (stack.size == m) {
            for(i in stack)
                print("$i ")
            println()
            stack.pop()
            return
        }
        else {
            var curVal = x
            while (true) {
                if(curVal == n) break
                curVal++
                rec(curVal)
            }
            stack.pop()
        }
    }
    for (i in numList) {
        rec(i)
    }
}