import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y) = br.readLine().toString().split(' ')
    val n = x.toInt()
    val m = y.toInt()
    val arr = HashMap<Int, String>()
    val temp = HashSet<String>()
    val ansArr = mutableListOf<String>()
    for(i in 0 until n){
        //arr[i] = br.().toString()
        temp.add(br.readLine().toString())
    }
    val sb = StringBuilder()
    var sum = 0
    for(j in 0 until m){
        val checkStr = br.readLine().toString()
        if(temp.contains(checkStr)){
            //sb.append("$checkStr\n")
            ansArr.add(checkStr)
            sum+=1
        }
    }
    ansArr.sort()
    for(j in 0 until ansArr.size){
        sb.append("${ansArr[j]}\n")
    }
    println(sum)
    println(sb)
}