fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val s = br.readLine().toString()
    var ans = 0
    var i = 0
    while (i < s.length) {
        if (i + 2 >= s.length) {
            break
        }
        if (s[i + 1] == 'O' && s[i + 2] == 'I') { // i일 경우에만 확인
            var cnt = 0
            while (s[i] == 'I' && s[i + 1] == 'O') {
                i += 2
                if (i + 1 >= s.length) {
                    break
                }
                cnt++
                if (s[i] == 'I' && cnt == n) {
                    cnt--
                    ans++
                }
            }
        }
        i += 1
    }
    println(ans)
}