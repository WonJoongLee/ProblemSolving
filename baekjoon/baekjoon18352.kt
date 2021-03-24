import java.lang.StringBuilder
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, k, x) = br.readLine().split(' ').map { it.toInt() }
    //x에서 출발해서 k 거리 위치에 있는 노드 찾기
    val arr = Array(300010) { Stack<Int>() } // n개의 도시에서 도로 100만개만큼 갈 수 있으니까 30만*100만으로 설정
    for (i in 0 until m) {
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        arr[a].add(b)
    }
    data class dat(val v : Int, val d : Int)
    val q: Queue<dat> = LinkedList<dat>()
    q.add(dat(x, 0))
    var depArr = IntArray(300010) { 0 }
    val visited = BooleanArray(300010) { false }
    visited[x] = true
    fun bfs() {
        while (q.isNotEmpty()) {
            val poll = q.poll()
            val curVal = poll.v
            val depth = poll.d
            for (i in arr[curVal].indices) {
                if (!visited[arr[curVal][i]]) {
                    q.add(dat(arr[curVal][i], depth+1))
                    depArr[arr[curVal][i]] = depth+1
                    visited[arr[curVal][i]] = true
                }
            }
        }
    }
    bfs()
    //var printed = false
    val sb = StringBuilder()
    for(i in 0 until 300010){
        if(depArr[i] == k){
            sb.append("$i\n")
        }
    }
    if(sb.isNotEmpty()) println(sb)
    else println("-1")
}