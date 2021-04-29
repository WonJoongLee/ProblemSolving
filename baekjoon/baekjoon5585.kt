fun main() {
    var n = 1000 - System.`in`.bufferedReader().readLine().toInt()
    var cnt = 0
    while (n != 0) {
        cnt++
        when {
            n >= 500 -> {
                n -= 500
            }
            n >= 100 -> {
                n -= 100
            }
            n >= 50 -> {
                n -= 50
            }
            n >= 10 -> {
                n -= 10
            }
            n >= 5 -> {
                n -= 5
            }
            n >= 1 -> {
                n -= 1
            }
        }
    }
    println(cnt)
}