import java.util.*
import kotlin.math.pow

fun main() {
    val br = System.`in`.bufferedReader()
    val (start, end) = br.readLine().split(' ').map { it.toInt() }
    var time = 0
    val timeCnt = IntArray(100001) { 0 }
    val visited = BooleanArray(100001) { false }
    val q: Queue<Int> = LinkedList()
    fun bfs(): Int {
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 0 until size) {
                val temp = q.poll()

                if (temp == end) {
                    return time // time을 찾는 순간 바로 탈출
                }
                if (temp - 1 >= 0 && !visited[temp - 1]) {
                    visited[temp - 1] = true
                    q.add(temp - 1)
                    timeCnt[temp - 1] = timeCnt[temp] + 1
                }
                if (temp + 1 <= 100000 && !visited[temp + 1]) {
                    visited[temp + 1] = true
                    q.add(temp + 1)
                    timeCnt[temp + 1] = timeCnt[temp] + 1
                }
                if (temp * 2 <= 100000 && !visited[temp * 2]) {
                    visited[temp * 2] = true
                    q.add(temp * 2)
                    timeCnt[temp * 2] = timeCnt[temp]
                }
            }
            time++
        }
        return 0
    }
    q.add(start)
    visited[start] = true
    bfs()
    println(timeCnt[end])
}