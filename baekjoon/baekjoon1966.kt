import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    data class Num(val priority: Int, val index: Int) : Comparable<Num> {
        override fun compareTo(other: Num) = compareValuesBy(other, this, { it.priority })
    }
    repeat(br.readLine().toInt()) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val pq = PriorityQueue<Num>()
        val q: Queue<Num> = LinkedList()
        val arr = br.readLine().split(" ").map { it.toInt() }
        for (i in arr.indices) {
            q.add(Num(arr[i], i))
            pq.add(Num(arr[i], i))
        }
        var cnt = 0
        while (q.isNotEmpty()) {
            val cur = q.poll()
            if (cur.priority < pq.peek().priority) {
                q.add(cur)
            } else {
                pq.poll()
                cnt++
                if(cur.index == m){
                    break
                }
            }
        }
        println(cnt)
    }
}