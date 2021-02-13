import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    data class Point(val x : Int, val y : Int) : Comparable<Point>{
        //x는 도착지점, y는 cost
        override fun compareTo(other: Point): Int {
            if(this.y < other.y){
                return -1
            }
            return 1
        }
    }
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val pq = PriorityQueue<Point>()
    val dist = IntArray(n+1){987654321}
    val arrList = Array(n+1){Stack<Point>()}
    for(i in 0 until m){
        val( u, v, value) = br.readLine().split(' ').map { it.toInt() }
        arrList[u].add(Point(v, value))
    }
    val (start, end) = br.readLine().split(' ').map { it.toInt() }

    pq.add(Point(start, 0))
    dist[start] = 0
    while(pq.isNotEmpty()){
        val po : Point = pq.poll()
        if(dist[po.x] < po.y) continue
        for(i in 0 until arrList[po.x].size){
            val p = arrList[po.x][i]
            if(dist[p.x]>dist[po.x]+arrList[po.x][i].y){
                dist[p.x]=dist[po.x]+arrList[po.x][i].y
                pq.add(Point(p.x, dist[p.x]))
            }
        }
    }
    println(dist[end])
}