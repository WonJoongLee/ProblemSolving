fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    repeat(n) {
        val temp = br.readLine()
        for (i in temp.indices) {
            arr[it][i] = temp[i].toInt() - 48
        }
    }

    var max = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            val cur = arr[i][j]
            for (k in 0 until kotlin.math.min(n, m)) {
                if (k > max && i + k in 0 until n && j + k in 0 until m && arr[i + k][j + k] == cur && arr[i + k][j] == cur && arr[i][j + k] == cur) {
                    max = k
                }
            }
        }
    }

    println((max + 1) * (max + 1))
}