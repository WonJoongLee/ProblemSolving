import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val arr = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val list = br.readLine().split(' ').map { it.toInt() }
        for (j in list.indices) {
            arr[i][j] = list[j]
            if (i == 0 && j != 0) {
                arr[i][j] = arr[i][j - 1] + arr[i][j]
            } else if (i != 0 && j == 0) {
                arr[i][j] = arr[i - 1][j] + arr[i][j]
            } else if (i != 0 && j != 0) {
                arr[i][j] = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1]
            }
        }
    }
    val sb = StringBuilder()
    for (i in 0 until m) {
        val (x1, y1, x2, y2) = br.readLine().split(' ').map { it.toInt() - 1 }
        if (x1 - 1 >= 0 && y1 - 1 >= 0) {
            sb.append("${arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1]}\n")
        } else if (x1 - 1 < 0 && y1 - 1 >= 0) {
            sb.append("${arr[x2][y2] - arr[x2][y1 - 1]}\n")
        } else if (x1 - 1 >= 0 && y1 - 1 < 0) {
            sb.append("${arr[x2][y2] - arr[x1 - 1][y2]}\n")
        } else if (x1 - 1 < 0 && y1 - 1 < 0) {
            sb.append("${arr[x2][y2]}\n")
        }
    }
    println(sb)
}