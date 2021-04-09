import java.lang.StringBuilder

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr: MutableMap<String, Boolean> = mutableMapOf()
    for(i in 0 until n){
        val (name, manage) = br.readLine().split(" ")
        if(manage=="enter"){
            arr[name] = true
        }else{
            arr.remove(name)
        }
    }
    val temp = arr.toList().sortedWith(compareBy { it.first }).reversed().toMap()
    val sb = StringBuilder()
    for(i in temp){
        sb.append("${i.key}\n")
    }
    print(sb)
}