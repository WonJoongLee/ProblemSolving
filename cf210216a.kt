import java.lang.Integer.max

fun main() {
    val br = System.`in`.bufferedReader()
    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        val a = br.readLine().split(' ').map { it.toInt() }
        var ans = 0
        for (i in 0 until a.size - 1) {
            var maxVal = max(a[i], a[i + 1])
            var minVal = kotlin.math.min(a[i], a[i + 1])
            if (maxVal.toDouble() / minVal.toDouble() > 2) {
                while (true) {
                    minVal *= 2
                    if (minVal >= maxVal) break
                    ans++
                }
            }
        }
        println(ans)
    }
}