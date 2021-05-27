import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    repeat(br.readLine().toInt()) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        repeat(m) {
            val (_, _) = br.readLine().split(" ").map { it.toInt() }
        }
        sb.append("${n-1}\n")
    }
    println(sb)
}