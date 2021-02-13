fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = Array(n+1){it.toBigInteger()}
    dp[0] = "0".toBigInteger()
    dp[1] = "1".toBigInteger()
    for(i in 2..n){
        dp[i] = dp[i-1].plus(dp[i-2])
    }
    println(dp[n])
}