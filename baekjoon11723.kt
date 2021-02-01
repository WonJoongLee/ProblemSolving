import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val hm = HashMap<Int, Boolean>()
    for (i in 0..20) {
        hm[i] = false // 먼저 모두 false로 초기화
    }
    var sb = StringBuilder()
    for (i in 0 until n) {
        val input = br.readLine().toString()
        if(' ' in input){ //공백이 있는 문자열
            val num = input.substringAfter(' ').toInt()
            when(input.substringBefore(' ')){
                "add" ->{ // num 추가
                    hm[num] = true
                }
                "check"->{
                    if(hm[num]==true){
                        sb.append("1\n")
                        //println("1")
                    }else{
                        sb.append("0\n")
                        //println("0")
                    }
                }
                "remove"->{ // num 삭제
                    hm[num]=false
                }
                "toggle"->{
                    hm[num] = hm[num] != true
                }
            }
        }else{ // all, empty 공백이 없는 문자열
            when(input){
                "all"->{
                    for (j in 0..20) {
                        hm[j] = true
                    }
                }
                "empty"->{
                    for (j in 0..20) {
                        hm[j] = false
                    }
                }
            }
        }
    }
    println(sb)
}