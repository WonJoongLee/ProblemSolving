class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0
        repeat(absolutes.size){
            answer += if(signs[it]){
                absolutes[it]
            }else{
                -absolutes[it]
            }
        }
        return answer
    }
}