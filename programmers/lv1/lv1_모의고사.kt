class Solution {
    fun solution(answers: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val p = arrayOf(arrayOf(1, 2, 3, 4, 5), arrayOf(2, 1, 2, 3, 2, 4, 2, 5), arrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5))
        val pCnt = intArrayOf(0, 0, 0)

        for (i in answers.indices) {
            for (j in pCnt.indices) {
                pCnt[j] += if (answers[i] == p[j][i % p[j].size]) 1 else 0
            }
        }

        if(pCnt[0]==pCnt.max()!!){
            answer.add(1)
        }
        if(pCnt[1]==pCnt.max()!!){
            answer.add(2)
        }
        if(pCnt[2]==pCnt.max()!!){
            answer.add(3)
        }

        return answer.toIntArray()
    }
}