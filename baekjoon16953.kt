import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (a, b) = br.readLine().split(' ').map { it.toLong() }
    data class Node(val num: Long, val depth: Int)

    val q: Queue<Node> = LinkedList<Node>()
    q.add(Node((a * 2).toLong(), 1)) // x2 추가
    q.add(Node((a.toString().plus("1")).toLong(), 1)) // 뒤에 1 붙인 것 추가
    var printed = false
    fun bfs(){
        while (q.isNotEmpty()) {
            val temp = q.poll()
            val num = temp.num
            val depth = temp.depth
            if (num == b) {
                println(depth+1)
                printed = true
                return
            }else if(num>b){
                continue
            }
            q.add(Node(num * 2, depth + 1))
            if ((num.toString().plus("1")).toLong() <= b) {
                q.add(Node((num.toString().plus("1")).toLong(), depth + 1))
            }
        }
    }
    bfs()
    if(!printed) println(-1)
}