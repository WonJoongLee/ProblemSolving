class Solution {
    val chkArray = BooleanArray(3000) {true} // 소수면 true, 소수가 아니면 false
    fun solution(nums: IntArray): Int {
        var answer = 0
        nums.sort()
        chk(nums[nums.size-1]+nums[nums.size-2]+nums[nums.size-3]+1) // 제일 큰 애들 세 개의 합까지 구해놓는다.

        for(i in 0 until nums.size-2){
            for(j in i+1 until nums.size-1){
                for(k in j+1 until nums.size){
                    if(chkArray[nums[i]+nums[j]+nums[k]]){
                        answer+=1
                    }
                }
            }
        }

        return answer
    }
    private fun chk(n : Int){
        for(i in 2..n){
            var cur = i
            while(cur<=n){
                cur+=i
                if(cur>n) break
                if(chkArray[cur]){
                    chkArray[cur] = false // 소수 아닌 애들 false 처리
                }
            }
        }
    }
}