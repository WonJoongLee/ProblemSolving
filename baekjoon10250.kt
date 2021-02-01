import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val stl = StringTokenizer(br.readLine())
        val valH = stl.nextToken().toInt()
        val valW = stl.nextToken().toInt()
        val valN = stl.nextToken().toInt()
        var arr = mutableListOf<String>()
        for (w in 1..valW) {
            for (h in 1..valH) {
                arr.add(if (w < 10 && h < 10) { // 둘 다 10보다 작을 때
                    val strH = h.toString()
                    val strW = "0".plus(w.toString())
                    strH.plus(strW)
                } else if (w < 10) { // h는 10이상일 때
                    val strH = h.toString()
                    val strW = "0".plus(w.toString())
                    strH.plus(strW)
                } else if (h < 10) {
                    val strH = h.toString()
                    val strW = w.toString()
                    strH.plus(strW)
                } else {
                    h.toString().plus(w.toString())
                })
            }
        }
        println(arr[valN-1])
    }
}

