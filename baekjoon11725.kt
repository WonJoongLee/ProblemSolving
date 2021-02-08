import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    var arr = Array(100001) { ArrayList<Int>() }
    val visited = BooleanArray(100001) { false }
    val ancestor = IntArray(100001) { -1 }
    val q : Queue<Int> = LinkedList()
    val n = br.readLine().toInt()
    for (w in 0 until n - 1) {
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        arr[a].add(b)
        arr[b].add(a)
    }
    fun bfs(x: Int) {
        visited[x] = true
        while(q.isNotEmpty()){
            val d = q.poll()
            for(i in arr[d]){
                if(!visited[i]) {
                    ancestor[i] = d // i의 부모는 d다.
                    visited[i] = true // i번재 노드 방문 했다고 표시한다.
                    q.add(i)
                }
            }
        }
    }
    q.add(1)
    bfs(1)
    val sb = StringBuilder()
    for(i in ancestor.indices){
        if(ancestor[i] != -1) {
            sb.append("${ancestor[i]}\n")
        }
    }
    println(sb)
}