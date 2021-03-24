import java.lang.Integer.max

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val t = IntArray(n + 1) // 걸리는 시간
    val p = IntArray(n + 1) // 비용
    val ans = IntArray(n + 1) { 0 }// 백준이가 최종적으로 n일날 받을 수 있는 금액
    for (i in 1..n) {
        val (tempX, tempY) = br.readLine().split(" ").map { it.toInt() }
        t[i] = tempX
        p[i] = tempY
    }
    for (i in 1..n) {
        if (t[i] + i - 1 <= n) {
            val temp = ans.slice(IntRange(0, i - 1))
            ans[t[i] + i - 1] = max(temp.maxOrNull()!! + p[i], ans[t[i] + i - 1])
        }
    }
    print(ans.maxOrNull())
}
