fun main() {
    val br = System.`in`.bufferedReader()
    var (n, k) = br.readLine().split(" ").map { it.toInt() }
    val type = mutableListOf<Int>()
    repeat(n) {
        type.add(br.readLine().toInt())
    }
    var cnt = 0
    while (k != 0) {
        cnt += 1
        for (money in type.reversed()) {
            if (k >= money) {
                k -= money
                break
            }
        }
    }
    print(cnt)
}