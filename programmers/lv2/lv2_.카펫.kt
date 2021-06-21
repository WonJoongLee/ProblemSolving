class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = mutableListOf<Int>()
        var temp = 0
        while(true){
            var len = brown / 2 - temp
            if((len-2)*temp == yellow){
                answer.add(len)
                answer.add(temp+2)
                return answer.toIntArray()
            }
            temp++
        }
    }
}