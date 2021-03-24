import java.lang.Integer.max

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n + 1) { ArrayList<Int>() }
    val d = Array(n + 1) { ArrayList<Int>() }
    for (i in 0 until n) {
        val list = br.readLine().split(' ').map { it.toInt() }
        for (j in list.indices) {
            arr[i].add(list[j])
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            d[i].add(0)
        }
    }
    d[0][0] = arr[0][0] // 초기화
    for (i in 1 until n) {
        for (j in arr[i].indices) {
            if (j == 0) { // 트리 왼쪽 끝일 경우
                d[i][j] = d[i - 1][j] + arr[i][j]
            }
            else if (j - 1 >= 0 && j != arr[i].size - 1) {
                d[i][j] = max(d[i - 1][j - 1], d[i - 1][j]) + arr[i][j]
            } else if (j - 1 >= 0 && j == arr[i].size - 1) {
                d[i][j] = d[i - 1][j - 1] + arr[i][j]
            }
        }
    }
    println(d[n-1].max())
}