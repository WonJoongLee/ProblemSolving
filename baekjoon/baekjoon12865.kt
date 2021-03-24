fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(' ').map { it.toInt() }
    val arr = Array(n + 1) { IntArray(k + 1) } //(n+1)*(k+1) 배열 생성 후 0으로 초기화
    val ks = mutableListOf<Pair<Int, Int>>() // first는 무게, second는 가치
    ks.add(0, Pair(0, 0))
    for (i in 1..n) {
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        ks.add(i, Pair(a, b))
    }
    for (i in 1 until n + 1) {
        for (j in 1 until k + 1) {
            println("$i, $j")
            arr[i][j] = arr[i-1][j]
            if (j - ks[i].first >= 0) {
                arr[i][j] = kotlin.math.max(arr[i - 1][j], arr[i-1][j - ks[i].first] + ks[i].second)
            }
        }
    }
    for (i in 0 until n + 1) {
        for (j in 0 until k + 1) {
            print("${arr[i][j]} ")
        }
        println()
    }
    println(arr[n][k])
}