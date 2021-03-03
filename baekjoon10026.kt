import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(101) { Array(101) { "" } }
    val visited = Array(101) { BooleanArray(101) { false } }
    for (i in 0 until n) {
        val str = br.readLine().split("")
        for (j in 1..n) {
            arr[i][j - 1] = str[j]
        }
    }
    data class Node(val i: Int, val j: Int)
    val q: Queue<Node> = LinkedList()
    val di = arrayOf(0, 0, -1, 1)
    val dj = arrayOf(1, -1, 0, 0)

    var area = 0

    fun bfs() {
        for(i in 0 until n){
            for(j in 0 until n){
                if(!visited[i][j]){ // 방문하지 않았다면
                    area++
                    q.add(Node(i, j))
                    visited[i][j] = true
                    while (q.isNotEmpty()) {
                        //println("area : $area, q : $q")
                        val cur = q.poll()
                        val curI = cur.i
                        val curJ = cur.j
                        for (k in 0 until 4) {
                            if (curI + di[k] in 0 until n && curJ + dj[k] in 0 until n && !visited[curI + di[k]][curJ + dj[k]]) {
                                // 만약 다음 탐색할 곳이 범위 안에 있고, 방문하지 않은 곳이라면
                                if(arr[curI + di[k]][curJ+dj[k]] == arr[curI][curJ]) { // 만약 색이 같다면
                                    //println("현재값 : ${arr[curI][curJ]}, 다음값 : ${arr[curI + di[i]][curJ+dj[i]]}, ${curI+di[i]}, ${curJ+dj[i]}")
                                    q.add(Node(curI + di[k], curJ + dj[k]))
                                    visited[curI+di[k]][curJ+dj[k]] = true
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    bfs()
    print("$area ")
    area = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            if(arr[i][j]=="R") arr[i][j]="G"
            visited[i][j] = false
        }
    }
    bfs()
    println(area)
}