fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val len = br.readLine().split(" ").map { it.toLong() }
    val price = br.readLine().split(" ").map { it.toLong() }.toMutableList()
    var sum = price[0] * len[0]
    for (i in 1 until n - 1) {
        if (price[i] > price[i - 1]) {
            price[i] = price[i - 1]
            sum += price[i - 1] * len[i]
        } else {
            sum += price[i] * len[i]
        }
    }
    println(sum)
}