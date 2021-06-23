class Solution {
    fun solution(number: String, k: Int): String {
        // number : 숫자 string
        // k : 제거할 수 있는 수의 개수
        val str = StringBuilder()
        var idx = 0
        for(i in k until number.length){
            var max = '0'
            for(j in idx..i){
                if(number[j]=='9'){
                    max = number[j]
                    idx = j + 1
                    break
                }
                if(number[j]>max){
                    max = number[j]
                    idx = j + 1
                }
            }
            str.append(max)
        }
        return str.toString()
    }
}