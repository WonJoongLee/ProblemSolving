import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { IntArray(n) { -1 } }
    val ansArr = Array(n) { IntArray(n) { 0 } }
    repeat(n) { i ->
        br.readLine().split(" ").forEachIndexed { index, c ->
            arr[i][index] = c.toInt()
        }
    }
    ansArr[0][0] = arr[0][0]
    for (i in 1 until n) {
        for (j in 0..i) {
            when (j) {
                0 -> {
                    ansArr[i][0] = ansArr[i - 1][0] + arr[i][0]
                    //println(arr[i][0] + arr[i - 1][0])
                }
                i -> {
                    ansArr[i][i] = ansArr[i - 1][i - 1] + arr[i][i]
                }
                else -> {
                    ansArr[i][j] = arr[i][j] + max(ansArr[i - 1][j - 1], ansArr[i - 1][j])
                }
            }
        }
    }
    println(ansArr[n - 1].maxOrNull())
}