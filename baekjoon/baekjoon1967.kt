import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    data class Node(
        val start: Int, // 시작점
        val end: Int, // 끝점
        val w: Int // 가중치
    )

    val arr = Array(n + 1) { mutableListOf<Node>() }
    for (i in 0 until n - 1) {
        val list = br.readLine().split(" ").map { it.toInt() }
        arr[list[0]].add(Node(list[0], list[1], list[2]))
        arr[list[1]].add(Node(list[1], list[0], list[2]))
    }
    // 입력 끝

    val v = BooleanArray(n + 1) { false }
    var max = -1
    var maxNodeNum = -1
    fun dfs(nodeNum: Int, weight: Int) {
        //println("$nodeNum, $weight")
        if (weight >= max) {
            max = weight
            maxNodeNum = nodeNum
        }
        for (i in arr[nodeNum].indices) {
            val next = arr[nodeNum][i].end // 도착지
            //println("nodenum : $nodeNum, next: ${next}")
            val nextWeight = arr[nodeNum][i].w
            if (!v[next]) { // 방문하지 않았으면 방문한다.
                v[next] = true
                dfs(next, weight + nextWeight)
            }
        }
    }

    v[1] = true
    dfs(1, 0)
//    println("$maxNodeNum : $max")
    max = -1
    for (i in v.indices) {
        v[i] = false
    }
    v[maxNodeNum] = true
    dfs(maxNodeNum, 0)
//    println("$maxNodeNum : $max")
    println(max)
}