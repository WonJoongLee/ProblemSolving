import kotlin.math.pow
class Solution {
    var target = 0
    var num = 0
    var ans = 9
    fun solution(N: Int, number: Int): Int {
        num = N
        target = number
        dfs(0, 0)
        if(ans>8) ans = -1
        return ans
    }

    // n은 넘어온 현재 값, cnt는 연산 횟수
    fun dfs(n : Int, cnt : Int) {
        var cur = n
        if(cnt>8){
            return
        }
        if(cur == target && cnt < ans){
            ans = cnt
        }
        var tempN = num // num에 바로하면 안되니까 tempN으로
        for(i in 0 until 8 - cnt){ // 남은 횟수만큼 돌면 됨.
            dfs(cur + tempN, cnt + i + 1)
            dfs(cur - tempN, cnt + i + 1)
            dfs(cur * tempN, cnt + i + 1)
            dfs(cur / tempN, cnt + i + 1)
            // 2더하고, 그 다음에는 20, 200, 2000 더함
            // 결국 2, 22, 222...를 만들 수 있음.
            tempN += num * (10.toDouble().pow(i+1).toInt())
        }
    }
}