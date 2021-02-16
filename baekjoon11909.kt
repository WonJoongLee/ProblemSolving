import java.lang.Math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { IntArray(n + 1) }
    val costArr = Array(n) { IntArray(n + 1) { 0 } }
    for (i in 0 until n) {
        val list = br.readLine().split(' ').map { it.toInt() }
        for (j in 0 until n) {
            arr[i][j] = list[j]
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == 0 && j > 0) {
                if (arr[i][j] < arr[i][j - 1]) costArr[i][j] = costArr[i][j - 1]
                else if (arr[i][j] >= arr[i][j - 1]) costArr[i][j] = costArr[i][j-1] + arr[i][j] - arr[i][j - 1] + 1
            }
            if (i > 0 && j == 0) {
                if (arr[i][j] < arr[i - 1][j]) costArr[i][j] = costArr[i - 1][j]
                else if (arr[i][j] >= arr[i - 1][j]) costArr[i][j] = costArr[i-1][j] + arr[i][j] - arr[i - 1][j] + 1
            }
            if (i > 0 && j > 0) {
                var tempA = 0 // 왼쪽과 비교
                var tempB = 0 // 위쪽과 비교
                if (arr[i][j] < arr[i][j - 1]) { // 그냥 넘김
                    tempA = costArr[i][j - 1]
                } else if (arr[i][j] >= arr[i][j - 1]) {
                    tempA = costArr[i][j - 1] + arr[i][j] - arr[i][j - 1] + 1
                }
                if (arr[i][j] < arr[i - 1][j]) {
                    tempB = costArr[i - 1][j]
                } else if (arr[i][j] >= arr[i - 1][j]) {
                    tempB = costArr[i - 1][j] + arr[i][j] - arr[i - 1][j] + 1
                }
                costArr[i][j] = min(tempA, tempB)
            }
        }
    }

//    for (i in 0 until n) {
//        for (j in 0 until n) {
//            print("${costArr[i][j]} ")
//        }
//        println()
//    }
    println(costArr[n-1][n-1])
}