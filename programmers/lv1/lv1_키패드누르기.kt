import kotlin.math.*
class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        val sb = StringBuilder()
        var lCur = -1
        var rCur = -1
        for(num in numbers){
            when(num){
                1, 4, 7->{
                    lCur = num
                    sb.append("L")
                }
                3, 6, 9->{
                    rCur = num
                    sb.append("R")
                }
                2, 5, 8, 0->{
                    val result = getDistance(num, lCur, rCur, hand)
                    if(result=="right"){
                        rCur = num
                        sb.append("R")
                    }else{
                        lCur = num
                        sb.append("L")
                    }
                }
            }
        }
        return sb.toString()
    }

    private fun getDistance(pos : Int, lCur : Int, rCur : Int, hand : String) : String{ // 0 return하면 왼쪽 손이 가깝고, 1 return하면 오른쪽 손이 가깝고
        var lDif = 0
        var rDif = 0
        if(lCur == 2 || lCur == 5 || lCur == 8 || lCur == 0){
            lDif = when(abs(pos-lCur)){
                2->{
                    3
                }
                3, 8->{
                    1
                }
                5, 6->{
                    2
                }
                else->{ -1 }
            }
        }else if(lCur==-1){ // 만약 초기값이라면
            lDif = when(pos){
                2->{4}
                5->{3}
                8->{2}
                0->{1}
                else->{-1}
            }
        }else{
            lDif = when(abs(lCur-(pos-1))){
                0->{
                    1
                }
                3, 8->{
                    2
                }
                5, 6->{
                    3
                }
                2->{
                    4
                }
                else->{ -1 }
            }
        }

        if(rCur == 2 || rCur == 5 || rCur == 8 || rCur == 0){
            rDif = when(abs(pos-rCur)){
                2->{
                    3
                }
                3, 8->{
                    1
                }
                5, 6->{
                    2
                }
                else->{ -1 }
            }
        }
        else if(rCur==-1){ // 만약 초기값이라면
            rDif = when(pos){
                2->{4}
                5->{3}
                8->{2}
                0->{1}
                else->{ -1 }
            }
        }
        else{
            rDif=when(abs(rCur-(pos+1))){
                0->{
                    1
                }
                3, 8->{
                    2
                }
                5, 6->{
                    3
                }
                2->{
                    4
                }
                else->{ -1 }
            }
        }


        if(lDif>rDif){
            return "right"
        }else if(lDif<rDif){
            return "left"
        }else if(lDif==rDif){
            if(hand=="right"){
                return "right"
            }else{
                return "left"
            }
        }
        return "error"
    }
}