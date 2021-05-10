fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val coins = IntArray(n)
    val dp = IntArray(k + 1) { 0 }
    dp[0] = 1
    repeat(n) {
        coins[it] = br.readLine().toInt()
    }
    for (coin in coins) {
        for (i in coin until dp.size) {
            dp[i] = dp[i - coin] + dp[i]
        }
    }
    println(dp[k])
}