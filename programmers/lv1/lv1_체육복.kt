class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0

        // 전체 학생 수 : n
        // 도난당한 학생 : lost
        // 여벌 체육복 있는 학생 : reverse
        // 수업들을 수 있는 학생 최대는?

        // 체육복 잃어버렸는지 여부 : lost, 체육복 여부가 있는지 여부 many
        data class Std(var lost : Boolean = false, var many : Boolean = false)

        var lostCnt = lost.size
        val stds = Array<Std>(n) { Std(false, many = false) }

        lost.forEach{ // 잃어버린 학생들
            stds[it-1].lost = true // 잃어버린 학생 체크
        }
        reserve.forEach{ // 여러 개 있는 학생들
            if(stds[it-1].lost){ // 만약 잃어버렸다면
                lostCnt--
                stds[it-1].lost = false // 잃어버리지 않았다고 체크하고
                stds[it-1].many = false // 여분도 없다고 체크하여 하나만 있는 것으로 설정한다.
            }else{
                stds[it-1].many = true // 여러 개 있다고 체크
            }
        }

        lost.forEach{
            if(stds[it-1].lost){
                if(it-2 > 0 && stds[it-2].many){ // 만약 앞 친구가 여러 개 있다면 가져온다.
                    println("1")
                    stds[it-1].lost = false
                    stds[it-2].many = false
                    lostCnt--
                }else if(it<n && stds[it].many){ // 만약 뒷 친구가 여러 개 있다면 가져온다.
                    println("$it, 2")
                    stds[it-1].lost = false
                    stds[it].many = false
                    lostCnt--
                }
            }
        }

        answer = n - lostCnt
        return answer
    }
}