import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    var pos = 0
    val arr = mutableListOf<Int>()
    val sb = StringBuilder()
    sb.append("<")
    for (i in 1..n) {
        arr.add(i)
    }
    for (i in 0 until n) {
        pos += k - 1
        if (pos >= arr.size) {
            pos %= arr.size
        }
        sb.append(arr[pos], ", ")
        arr.removeAt(pos)
    }
    println(sb.toString().removeRange(sb.length-2, sb.length).plus(">"))
}
