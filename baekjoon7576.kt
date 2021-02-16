import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (m, n) = br.readLine().split(' ').map { it.toInt() }
    val arr = Array(1001) { IntArray(1001) }

    data class Node(val x: Int, val y: Int)

    val q: Queue<Node> = LinkedList<Node>()
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)
    for (i in 0 until n) {
        val list = br.readLine().split(' ').map { it.toInt() }
        for (j in 0 until m) {
            arr[i][j] = list[j]

            if (list[j] == 1) {
                q.add(Node(i, j))
//                println("$i, $j")
            }
        }
    }
    var last = 0
    while (q.isNotEmpty()) {
        val temp = q.poll()
        for (i in 0 until 4) {
//            println("${temp.x + dx[i]}, ${temp.x + dx[i] in 0 until m}")
            if (temp.x + dx[i] in 0 until n && temp.y + dy[i] in 0 until m && arr[temp.x + dx[i]][temp.y + dy[i]] == 0) {
//                println("in")
                arr[temp.x+ dx[i]][temp.y + dy[i]] = arr[temp.x][temp.y] + 1
                //println(arr[temp.x + dx[i]][temp.y + dy[i]])
                q.add(Node(temp.x + dx[i], temp.y + dy[i]))
                last = arr[temp.x + dx[i]][temp.y + dy[i]]
            }
        }
//        println("5, 2 = ${arr[2][5]}, 4, 3 = ${arr[3][4]}")
//        println(q)
//        println("===========================")
    }

    var check = true
    for (i in 0 until n) {
        for (j in 0 until m) {
//            print("${arr[i][j]} ")
            if (arr[i][j] == 0) check = false
        }
        //println()
    }
    if (!check) println("-1")
    else if (last-1 == -1) println(0)
    else println(last-1)
}