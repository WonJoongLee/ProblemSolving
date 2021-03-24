fun main(){
    val br = System.`in`.bufferedReader()
    val dp = Array(101){it.toBigInteger()}
    dp[0] = 1.toBigInteger()
    dp[1] = 1.toBigInteger()
    dp[2] = 1.toBigInteger()
    dp[3] = 2.toBigInteger()
    dp[4] = 2.toBigInteger()
    var pos = 0
    for(i in 5 until 101){
        dp[i]=dp[i-1]+dp[pos++]
    }
    repeat(br.readLine().toInt()){
        println(dp[br.readLine().toInt()-1])
    }
}