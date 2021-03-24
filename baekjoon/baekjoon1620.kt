import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().toString().split(' ')
    val n = a.toInt()
    val k = b.toInt()
    val arr = mutableListOf<String>()
    val hm = HashMap<String, Int>()
    var sb = StringBuilder()
    for (i in 0 until n) {
        val name = br.readLine().toString()
        arr.add(name)
        hm[name] = i
    }
    for (i in 0 until k) {
        val input = br.readLine()
        try {
            if (input.toInt() in 1..100004) { // 만약 숫자가 입력되었다면
                sb.append("${arr[input.toInt() - 1]}\n")
            }
        } catch (e : Exception) { // 만약 문자라면
            sb.append("${hm[input]!!+1}\n")
            //sb.append("${hm.filterValues { it == input }.keys.sum() + 1}\n")
            //println(hm.filterValues { it == input }.keys.sum() + 1)
        }
    }
    println(sb)
}