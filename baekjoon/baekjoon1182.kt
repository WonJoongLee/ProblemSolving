fun main() {
    val br = System.`in`.bufferedReader()
    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val nums = br.readLine().split(" ").map { it.toInt() }.toList()
    var cnt = 0
    fun dfs(i: Int, sum: Int) {
        if (i >= n) return
        if (sum + nums[i] == s) cnt++
        dfs(i + 1, sum) // 인덱스에 있는 숫자 안 더했을 경우
        dfs(i + 1, sum + nums[i]) // 인덱스에 있는 숫자 더했을 경우
    }
    dfs(0,0)
    print(cnt)
}