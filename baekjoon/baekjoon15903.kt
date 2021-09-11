fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var list = br.readLine().split(" ").map { it.toLong() }.sortedDescending().toLongArray()
    repeat(m) { i ->
        val min1 = list[n - 1]
        val min2 = list[n - 2]
        list[n - 1] += min2
        list[n - 2] += min1
        list = list.sortedArrayDescending()
    }
    println(list.sum())
}