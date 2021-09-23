fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    data class Node(
        val next: Int,
        val weight: Int
    )

    val arr = Array(n + 1) { mutableListOf<Node>() }
    var maxWeight = -1
    var maxNode = -1
    for (i in 1..n) {
        val list = br.readLine().split(" ").map { it.toInt() }
        val start = list[0]
        for (j in 1 until list.size - 1 step 2) {
            arr[start].add(Node(list[j], list[j + 1]))
        }
    }
    val v = BooleanArray(n + 1) { false }
    fun dfs(node: Int, curWeight: Int) {
        println("$node, $curWeight")
        if (curWeight > maxWeight) {
            maxWeight = curWeight
            maxNode = node
        }
        arr[node].forEach {
            if (!v[it.next]) {
                v[it.next] = true
                dfs(it.next, curWeight + it.weight)
                v[it.next] = false
            }
        }
    }
    v[1] = true
    dfs(1, 0)
    v[1] = false
    println("$maxNode, $maxWeight")
    maxWeight = 0
    v[maxNode] = true
    dfs(maxNode, 0)
    println(maxWeight)
}