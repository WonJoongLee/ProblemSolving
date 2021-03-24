fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var ans = 0
    val arr = IntArray(n + 1)

    fun promising(x: Int): Boolean {
        var k = 0
        var rVal = true
        while (k < x && rVal) { // k<x이므로 같은 열인지 검사는 안해도 된다.
            if (arr[x] == arr[k] || kotlin.math.abs(arr[x] - arr[k]) == x - k) { // 같은 행에 있거나 대각선에 위치해있다면
                rVal = false
            }
            k++
        }
        return rVal
    }

    fun nQueen(x: Int) {
        if (x == n) {
            ans++
            return
        } else {
            for (i in 0 until n) {
                arr[x] = i // (x, i)에 말 배치
                if (promising(x)) { // 유효한지 검사
                    nQueen(x + 1) // 다음 행으로 이동
                }
            }
        }
    }
    nQueen(0)
    println(ans)
}