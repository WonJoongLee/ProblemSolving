class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var correctNum = 0 // 찢어지기 전 맞춘 숫자 개수
        var zeroNum = 0
        val rankMap = mutableMapOf<Int, Int>()
        rankMap[6] = 1 // 6개 맞추면 1등
        rankMap[5] = 2
        rankMap[4] = 3
        rankMap[3] = 4
        rankMap[2] = 5
        for(myNum in lottos){
            if(myNum == 0){
                zeroNum++
                continue
            }
            if(win_nums.contains(myNum)) correctNum++
        }
        when(zeroNum){
            0->{
                answer.add(rankMap[correctNum] ?: 6)
                answer.add(rankMap[correctNum] ?: 6)
            }
            6->{
                answer.add(1)
                answer.add(6)
            }
            else->{
                answer.add(rankMap[zeroNum+correctNum] ?: 6)
                answer.add(rankMap[correctNum] ?: 6)
            }
        }
        return answer.toIntArray()
    }
}