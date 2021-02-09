import java.lang.Integer.min

fun main() {
    val br = System.`in`.bufferedReader()
    val arr = Array(1001) { IntArray(3) } // 3*1000 2차원배열
    val d = Array(1001) { IntArray(3) } // 3*1000 2차원배열
    val n = br.readLine().toInt()
//    arr[0][0] = 0
//    arr[1][0] = 0
//    arr[2][0] = 0
    d[0][0] = 0
    d[1][0] = 0
    d[2][0] = 0

    for (i in 1 until n+1) {
        val list = br.readLine().split(' ').map { it.toInt() }
        for (j in 0 until 3) {
            arr[i][j] = list[j]
        }
    }
//    for(i in 0 until 3){
//        for(j in 1..n){
//            print("${arr[i][j]} ")
//        }
//        println()
//    }
    for (j in 1..n) {
//        d[0][j] = arr[0][j] + min(d[1][j - 1], d[2][j - 1])
//        d[1][j] = arr[1][j] + min(d[0][j - 1], d[2][j - 1])
//        d[2][j] = arr[2][j] + min(d[0][j - 1], d[1][j - 1])
        d[j][0] = arr[j][0] + min(d[j - 1][1], d[j - 1][2])
        d[j][1] = arr[j][1] + min(d[j - 1][0], d[j - 1][2])
        d[j][2] = arr[j][2] + min(d[j - 1][0], d[j - 1][1])
    }

    //println("${d[0][n]}, ${d[1][n]}, ${d[2][n]}")
    println(min(d[n][0], min(d[n][1], d[n][2])))

    //arr[0][1] = arr[0][1] + min(arr[1][0], arr[1][0])
}