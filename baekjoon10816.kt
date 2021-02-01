import java.io.BufferedReader
import java.io.InputStreamReader
//import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap
import kotlin.text.StringBuilder

//https://www.acmicpc.net/problem/10816
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val sangArr = IntArray(n)
    val l1 = StringTokenizer(br.readLine(), " ")
    var hashMap: HashMap<Int, Int> = HashMap<Int, Int>()
    for (i in 0 until n) {
        sangArr[i] = l1.nextToken().toInt()
        if (hashMap[sangArr[i]] == null) { // 만약 기존에 추가된 hashmap이 없다면 추가
            hashMap[sangArr[i]] = 1
        } else { // 기존에 추가된 hash가 있다면 value를 가져와서 1 더함
            var temp: Int = hashMap[sangArr[i]]!!
            temp += 1
            hashMap[sangArr[i]] = temp
        }
    }
    //println(hashMap)
    val m = br.readLine().toInt()
    val checkArr = IntArray(n)
    val l2 = StringTokenizer(br.readLine(), " ")
    val ansArr = IntArray(m)
    var sb = StringBuilder()
    for (i in 0 until m) {
        checkArr[i] = l2.nextToken().toInt()
        if(hashMap[checkArr[i]]==null) {
            //ansArr[i] = 0
            sb.append("0 ")
        }else{
            //ansArr[i] = hashMap[checkArr[i]]!!
            sb.append("${hashMap[checkArr[i]]} ")
        }
//        print(
//                if(hashMap[checkArr[i]]==null){
//                    "0 "
//                }else{
//                    "${hashMap[checkArr[i]]} "
//                })
    }
    println(sb)
}