import java.io.BufferedReader
import java.io.InputStreamReader

var dp = Array(41) { IntArray(2) }

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    dp[0][0] = 1
    dp[1][1] = 1

    repeat(br.readLine().toInt()){
        val case = br.readLine().toInt()
        for(i in 2..case){
            for(j in 0..1){ // j는 각각 0과 1임
                dp[i][j] = dp[i-1][j]+dp[i-2][j]
            }
        }
        println(dp[case].joinToString(" "))
    }

}
