//https://gyubgyub.tistory.com/54 참고
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val br = System.`in`.bufferedReader()
    val (n, e) = br.readLine().split(' ').map { it.toInt() }
    //정점 개수, 간선 개수
    val start = br.readLine().toInt() // 시작정점
    val INF = 100000000
    val arr : ArrayList<ArrayList<Node>> = ArrayList()
    for(i in 0..n){
        arr.add(ArrayList())
    }
    val dist = IntArray(n+1){INF}
    val pq = PriorityQueue<Node>() // Priority Queue를 통한 BFS 탐색
    for(i in 0 until e){
        val (u, v, w) = br.readLine().split(' ').map {it.toInt()}
        arr[u].add(Node(v, w))
    }

    dist[start] = 0  // 시작 거리는 0
    pq.add(Node(start, 0)) // 시작 노드를 큐에 넣어줌

    while(pq.isNotEmpty()){
        //println("index : ${pq.peek().index}")
        val curIndex = pq.peek().index // 현재 노드 인덱스
        val curDist = pq.peek().dist // 현재 노드까지의 거리
        pq.poll()

        if(dist[curIndex]<curDist) continue // 탐색 시간을 줄이기 위해,
                            // 현재 거리가 현재 노드까지의 거리보다 작으면 탐색 중단
        for(i in 0 until arr[curIndex].size){
            val nextIndex = arr[curIndex][i].index
            val nextDist = curDist + arr[curIndex][i].dist

            if(nextDist < dist[nextIndex]){
                dist[nextIndex] = nextDist
                pq.add(Node(nextIndex, nextDist))
            }
        }
        println(pq)
    }
    val sb = StringBuilder()
    for(i in 1..n){
        if(dist[i]==INF){
            sb.append("INF\n")
        }else{
            sb.append("${dist[i]}\n")
        }
    }
    println(sb)
}

data class Node(val index : Int, val dist : Int) : Comparable<Node>{
    override fun compareTo(other: Node): Int = dist-other.dist
}

