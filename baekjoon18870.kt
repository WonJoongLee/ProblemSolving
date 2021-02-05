import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(' ').map { it.toInt() }
    val data = HashMap<Int, Int>()
    val ansMap = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        data[i] = list[i]
    }
    val sortedMp = data.toList().sortedBy { (_, value) -> value }
    var setValue = 0
    for (i in 0 until n) {
        if(i-1>=0&&sortedMp[i].second == sortedMp[i-1].second){
            setValue--
            //ansMap[setValue] = sortedMp[i].second
            ansMap.put(sortedMp[i].second, setValue)
            setValue++
        }else {
            //ansMap[setValue] = sortedMp[i].second
            ansMap.put(sortedMp[i].second, setValue)
            setValue++
        }
    }
    val sb = StringBuilder()
    for (i in 0 until n) {
        if(i==n-1){
            sb.append("${ansMap.get(list[i])}")
        }else{
            sb.append("${ansMap.get(list[i])} ")
        }
    }
    println(sb)
}