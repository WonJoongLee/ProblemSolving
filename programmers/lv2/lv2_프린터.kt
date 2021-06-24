import java.util.*
class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        data class Node(val idx : Int, val p : Int) : Comparable<Node> {
            override fun compareTo(other: Node) = compareValuesBy(other, this, {it.p})
        }

        val q : Queue<Node> = LinkedList()
        val pq = PriorityQueue<Node>()

        for(i in priorities.indices){
            q.add(Node(i, priorities[i]))
            pq.add(Node(i, priorities[i]))
        }

        while(pq.isNotEmpty()){
            val cur = pq.poll()
            var nextQ = q.poll()
            while(cur.p != nextQ.p){ // 만약 뽑으려는 pq의 top priority와 priority가 다르면
                q.add(nextQ) // Q뒤에 넣는다.
                nextQ = q.poll() // 다시 Q에서 맨 앞에 것을 뺀다.
            } // 일치하는 priority가 나오면 끝
            answer++
            if(nextQ.idx == location) break
        }

        return answer
    }
}