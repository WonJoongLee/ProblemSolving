fun main() {
    val br = System.`in`.bufferedReader()
    val targetNum = br.readLine().toString()
    val brokenCnt = br.readLine().toInt()
    val brokenList = BooleanArray(10) { false } // 고장 났으면 true
    if(brokenCnt!=0){
        val tempList = br.readLine().split(" ").map { it.toInt()}
        for (i in tempList) {
            brokenList[i] = true
        }
    }

    fun possible(n: Int): Boolean {
        var check = true
        for (i in brokenList.indices) {
            // 고장난 버튼이 string에 있으면 return false
            if (brokenList[i] && n.toString().contains(i.toString())) {
                check = false
                return check
            }
        }
        return check
    }

    var min = 1000005
    var num = 0
    for (i in 0..1000000) {
        //i를 누를 수 있다면
        if (possible(i)) {
            if (kotlin.math.abs(targetNum.toInt() - i) < min) {
                min = kotlin.math.abs(targetNum.toInt() - i)
                num = i
            }
        }
    }

    if(kotlin.math.abs(100-targetNum.toInt())<min + num.toString().length){
        min = kotlin.math.abs(100-targetNum.toInt())
        println(min)
    }else{
        // 이동을 시작하려는 위치의 length를 더해야 함
        println(min + num.toString().length)
    }
}