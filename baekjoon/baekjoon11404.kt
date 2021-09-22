fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt() // 도시 개수
    val m = br.readLine().toInt() // 버스 개수
    val arr = Array(n + 1) { Array(n + 1) { Int.MAX_VALUE } }
    for (i in 0 until m) {
        val (s, e, w) = br.readLine().split(" ").map { it.toInt() }
        if (w < arr[s][e]) {
            arr[s][e] = w
        }
    }

    for (mid in 1..n) {
        for (start in 1..n) {
            for (end in 1..n) {
                if (arr[start][mid] + arr[mid][end] > 0 && arr[start][end] > arr[start][mid] + arr[mid][end]) {
                    arr[start][end] = arr[start][mid] + arr[mid][end]
                }
            }
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if (i == j || arr[i][j] == Int.MAX_VALUE) print("0 ")
            else print("${arr[i][j]} ")
        }
        println()
    }
}