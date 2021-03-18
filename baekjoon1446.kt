import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, d) = br.readLine().split(" ").map { it.toInt() }
    val dist = IntArray(10010) { Integer.MAX_VALUE }
    dist[0] = 0

    data class Node(val start: Int, val end: Int, val weight: Int) : Comparable<Node> {
        override fun compareTo(other: Node): Int = weight - other.weight
    }

    val arr = Array(10010) { Stack<Node>() }
    for (i in 0 until n) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        if (b > d) continue // 종착점이 목적지보다 더 크면 넣지 않는다
        if (b - a <= c) continue // 그냥 가는 것보다 더 오래걸리면 넣지 않는다.
        if (arr[a].isNotEmpty()) {
            val k = arr[a].peek()
            //출발지와 도착지가 같고, 이미 들어가 있는 weight가 더 크다면 넣는다.
            //지금 새로 받은 값이 더 크다면, 넣지 않는다. 그냥 무시
            if (k.end == b && k.weight > c) {
                arr[a].add(Node(a, b, c))
            } else if (k.end != b) { // 종착점이 달라도 추가한다.
                arr[a].add(Node(a, b, c))
            }
        } else {
            arr[a].add(Node(a, b, c))
        }
    }

    var curVal = 0
    for (i in 0..d) {
        //println("$i, $curVal, ${dist[i]}")
        if (dist[i] < curVal) {
            curVal = dist[i]
        }
        //지름길이 있으면 지름길을 탄다
        while (arr[i].isNotEmpty()) {
            val cur = arr[i].pop()
            if (dist[cur.end] > curVal + cur.weight) {
                dist[cur.end] = curVal + cur.weight
            }
        }
        curVal++
    }
    print(curVal - 1)
}