import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    if (n > k) {
        println(n - k)
        println(1)
        return
    }

    var cnt = 0
    var foundFlag = false
    var foundDepth = Int.MAX_VALUE
    val v = BooleanArray(2 * k + 1)

    data class Value(
        val value: Int,
        val depth: Int
    )

    val q: Queue<Value> = LinkedList()
    fun bfs() {
        while (q.isNotEmpty()) {
            val cur = q.poll()
            val curValue = cur.value
            val curDepth = cur.depth
            var nextValue = curValue - 1
            v[curValue] = true // 방문했을 때 처리
            // 동생을 찾으면
            if (curValue == k) {
                // 만약 처음 찾은거면 depth 기록
                if (!foundFlag) {
                    foundFlag = true
                    foundDepth = curDepth
                }
                if (curDepth == foundDepth) { // 어차피 지나가면 못찾고, 이전에는 못찾아서 필요 없을 수도 있는데 일단 넣어둠
                    cnt++
                }
            }
            if (nextValue in 0..(k + 1) && curDepth + 1 <= foundDepth && !v[nextValue]) {
                q.add(Value(nextValue, curDepth + 1))
            }
            nextValue = curValue + 1
            if (nextValue in 0..(k + 1) && curDepth + 1 <= foundDepth && !v[nextValue]) {
                q.add(Value(nextValue, curDepth + 1))
            }
            nextValue = curValue * 2
            if (nextValue in 0..(k + 1) && curDepth + 1 <= foundDepth && !v[nextValue]) {
                q.add(Value(nextValue, curDepth + 1))
            }
        }
    }
    q.add(Value(n, 0))
    bfs()
    println(foundDepth)
    println(cnt)
}