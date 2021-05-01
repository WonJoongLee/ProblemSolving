fun main() {
    val br = System.`in`.bufferedReader()
    var (n, k) = br.readLine().split(" ").map { it.toInt() }
    val type = mutableListOf<Int>()
    repeat(n) {
        type.add(br.readLine().toInt())
    }
    var cnt = 0
    for (money in type.reversed()) {
        if (money <= k) {
            cnt += k / money
            k %= money
        }
    }
    print(cnt)
}