import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine().toString()
    var start = 0
    val stack = Stack<Int>()
    var ans = 0
    var firstChk = true
    for (i in str.indices) {
        val cur = str[i]
        if (cur == '+' || cur == '-') {
            stack.add(str.substring(start, i).toInt())
            start = i + 1
        } else if (i == str.length - 1) {
            stack.add(str.substring(start, i + 1).toInt())
        }
        if ((str[i] == '-') || (i == str.length - 1)) {
            if (firstChk) {
                ans += stack.sum()
                firstChk = false
            } else {
                ans -= stack.sum()
            }
            stack.clear()
        }
    }
    println(ans)
}