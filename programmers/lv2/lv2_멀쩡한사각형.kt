class Solution {
    fun solution(w: Int, h: Int): Long {
        return w.toLong()*h.toLong()-(w+h-gcd(w, h)).toLong()
    }

    private fun gcd(w : Int, h : Int) : Int{
        var ans = w
        if(w>h){
            ans = h
        }
        while(ans>0){
            if(w%ans==0&&h%ans==0){
                break
            }
            ans--
        }
        return ans
    }
}