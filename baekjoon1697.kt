import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (start, find) = br.readLine().split(' ').map { it -> it.toInt() }
    val visited = BooleanArray(100001) { false }
    val q: Queue<Int> = LinkedList<Int>() // 탐색할 큐

    q.add(start)

    var time = 0

    fun dfs(): Int {
        //while(true) {
        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 0 until size) {
                val now = q.poll() // 제일 앞에 있는 노드 빼서 now에 저장
                if (now == find) return time
                if (now - 1 >= 0 && !visited[now - 1]) {
                    q.add(now - 1)
                    visited[now - 1] = true
                }
                if (now + 1 <= 100000 && !visited[now + 1]) {
                    q.add(now + 1)
                    visited[now + 1] = true
                }
                if (now * 2 <= 100000 && !visited[now * 2]) {
                    q.add(now * 2)
                    visited[now * 1] = true
                }
            }
            time++
        }
        return 0
    }
    dfs()
    println(time)
}