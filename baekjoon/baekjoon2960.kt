fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val v = BooleanArray(2 * n + 1) { false }
    var cnt = 0
    var chk = false
    for (i in 2..n) {
        var cur = i
        if (!v[cur]) {
            cnt++
        }
        v[cur] = true
        if (cnt == k) {
            println(cur)
            break
        }
        while (cur <= n) {
            if (v[cur]) {
                cur += i
                continue
            }
            cnt++
            v[cur] = true // 방문
            if (cnt == k) {
                println(cur)
                chk = true
                break
            }
            cur += i
        }
        if (chk) break
    }
}