class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val m = mutableListOf<Int>()
        for(i in 0 until progresses.size){
            val rest = (100 - progresses[i]) / speeds[i]
            if(((100 - progresses[i]) % speeds[i]) == 0){ // 나머지가 없다면
                m.add(rest)
            }else{
                m.add(rest + 1)
            }
        }
        var cnt = 1
        var cur = 0
        for(i in 0 until m.size){
            if(m[cur]>=m[i] && cur != i){
                cnt++
            }else if(m[cur] < m[i] && cur != i){
                answer.add(cnt)
                cnt = 1
                cur = i
            }
            if(i == m.size - 1){
                answer.add(cnt)
            }
        }
        return answer.toIntArray()
    }
}