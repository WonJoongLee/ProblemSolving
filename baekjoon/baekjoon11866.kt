import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stl = StringTokenizer(br.readLine())
    val n = stl.nextToken().toInt()
    val k = stl.nextToken().toInt()
    val dq = ArrayDeque<Int>()
    for (i in 1..n) {
        dq.add(i)
    }
    var pos = 1
    var cnt = 0
    print("<")
    while (cnt != n) { // 하나 남을때까지 반복
        while (true) { // pos가 k만큼 더해졌을 때 탈출
            if (pos++ % k == 0) {
                print("${dq.first()}")
                dq.removeFirst()
                cnt++
                break
            } else {
                dq.addLast(dq.first())
                dq.removeFirst()
            }
        }
        if (cnt != n) {
            print(", ")
        }
    }
    print(">")
}