import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    data class Point(val dest: Int, val cow: Int) : Comparable<Point> {
        override fun compareTo(other: Point): Int {
            if (this.cow < other.cow) {
                return -1 // 다른 위치의 소보다 지금의 소가 적으면 바꾸지 말라는 의미
            }
            return 1
        }
    }
    val arr = Array(50005) { Stack<Point>() }
    for (i in 0 until m) {
        val (a, b, c) = br.readLine().split(' ').map { it.toInt() }
        arr[a].add(Point(b, c))
        arr[b].add(Point(a, c))
    }
    val pq = PriorityQueue<Point>()
    pq.add(Point(1, 0))
    val pointCow = Array(50005) { 987654321 } // 각 weight 초기화
    pointCow[1] = 0
    while (pq.isNotEmpty()) {
        //println(pq)
        val temp = pq.poll()// temp는 현재 있는 위치의 정보를 담고 있다.
        val dest = temp.dest
        val cow = temp.cow
        if (pointCow[dest] < cow) {
            continue // 목적지의 소가 지금 소보다 적다면 continue
        }
        for (i in arr[dest].indices) {
            val p = arr[dest][i]
            //println(pointCow[p.dest])
            if (pointCow[p.dest] > arr[dest][i].cow + pointCow[dest]) {
                pointCow[p.dest] = arr[dest][i].cow + pointCow[dest]
                pq.add(Point(p.dest, pointCow[p.dest]))
            }
        }
    }
    println(pointCow[n])
}