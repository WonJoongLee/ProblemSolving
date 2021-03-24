import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var paper: Array<IntArray> // 배열 선언하는 법
var whiteSum = 0
var blueSum = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    paper = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        val st = StringTokenizer(br.readLine())
        for (j in 1..st.countTokens()) {
            paper[i][j] = st.nextToken().toInt()
        }
    }
    /*
    for (i in 1..n) {
        for(j in 1..n){
            print("${paper[i][j]} ")
        }
        println()
    }
     */

    rec(1, 1, n)
    println(whiteSum)
    println(blueSum)
}

fun rec(x: Int, y: Int, n: Int) {
    //println(n)
    var white = true
    var blue = true
    for (i in x until x + n) { // 파란색, 흰색 확인
        for (j in y until y + n) {
            if (paper[i][j] == 1) {
                //println("i:$i, j:$j")
                white = false
            } else {
                blue = false
            }
            if (!white && !blue) // 두 색이 모두 존재하면 탈출
                break
        }
        if (!white && !blue) // i for문에서도 바로 탈출 가능하도록 설정
            break
    }
    if (white) {
        //println("x : $x, y : $y")
        whiteSum += 1
        return
    } else if (blue) {
        //println("x : $x, y : $y")
        blueSum += 1
        return
    } else if (!white && !blue) { // 5 1인 상황
        //println("x : $x, y : $y, n/2 : ${n/2}")
        rec(x, y, n / 2)
        //println("n/2+1 : ${n/2+1}, y : $y, n/2 : ${n/2}")
        rec(n / 2 + x, y, n / 2)
        //println("x : $x, n/2+1: ${n/2+1}, n/2 : ${n/2}")
        rec(x, n / 2 + y, n / 2)
        //println("n/2+1 : ${n/2+1}, n/2+1: ${n/2+1}, n/2 : ${n/2}")
        rec(n / 2 + x, n / 2 + y, n / 2)
    }
}