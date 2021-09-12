import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val nums = br.readLine().split(" ").map { it.toInt() }
    val tens = mutableListOf<Int>()
    var ten = 10000
    //ten 구하는 부분
    repeat(4) {
        val start = it
        val sb = StringBuilder()
        for (k in start until start + 4) {
            sb.append(nums[k % 4])
        }
        val curValue = sb.toString().toInt()
        ten = if (curValue < ten) curValue else ten
    }

    for (cur in 1111..9999) {
        val now = cur.toString()
        if (now.contains("0")) continue
        var min = 10000
        repeat(4) { i ->

            val sb = StringBuilder()
            for (j in i until i + 4) {
                sb.append(now[j % 4])
            }
            val curValue = sb.toString().toInt()
            min = if (curValue < min) curValue else min
        }
        if (tens.contains(min)) continue
        tens.add(min)
    }
    var answer = 0
    for (i in tens.indices) {
        if (tens[i] == ten) {
            answer = i
        }
    }
    println(answer + 1)
}