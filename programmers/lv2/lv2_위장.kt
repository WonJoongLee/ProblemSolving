class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        var m = mutableMapOf<String, Int>()

        clothes.forEach{
            val cnt = m.get(it.get(1)) ?: 0
            m.put(it.get(1), cnt + 1)
        }

        for(i in m){
            answer *= (i.value + 1)
        }

        return answer-1
    }
}