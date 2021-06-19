class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()

        for(i in 0 until commands.size){
            val start = commands[i][0]-1
            val end = commands[i][1]-1
            val turn = commands[i][2]-1
            val newArr = array.slice(start..end).sorted()
            answer.add(newArr[turn])
        }

        return answer.toIntArray()
    }
}