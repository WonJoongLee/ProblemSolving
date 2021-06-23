class Solution {
    var tar = 0
    var cnt = 0
    fun solution(numbers: IntArray, target: Int): Int {
        tar = target
        dfs(1, numbers[0], numbers)
        dfs(1, -numbers[0], numbers)
        return cnt
    }

    fun dfs(pos : Int, value : Int, numbers : IntArray){
        if(pos >= numbers.size){ // 다음 값이 없으면 return한다.
            if(value == tar ) cnt++ // 값을 찾았으면 cnt를 1 올리고 return한다.
            return
        }
        dfs(pos+1, value+numbers[pos], numbers)
        dfs(pos+1, value-numbers[pos], numbers)
    }
}