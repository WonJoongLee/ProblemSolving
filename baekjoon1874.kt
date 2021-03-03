import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var pos = 1
    val stack = Stack<Int>()
    val arr = IntArray(100001) { -1 }
    for (i in 0 until n) {
        arr[i] = br.readLine().toInt()
    }
    val sb = StringBuilder()
    stack.push(pos++)
    sb.append("+\n")
    var arrPos = 0
    //while (stack.isNotEmpty()) {
    while (arrPos != arr.size) {
        //println(stack)
        when {
            stack.isEmpty() -> {
                sb.append("+\n")
                stack.push(pos++)
            }
            stack.peek() == arr[arrPos] -> {
                sb.append("-\n")
                stack.pop()
                arrPos++
            }
            stack.peek() > arr[arrPos] ->{
                break
            }
            else -> {
                sb.append("+\n")
                stack.push(pos++)
            }
        }
        if(arr[arrPos] == -1) break
    }

    if (arrPos != n) {
        println("NO")
    } else {
        println(sb)
    }
}