import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = mutableListOf<Int>()
    val list = br.readLine().toString().split(' ')
    for(i in 0 until n){
        arr.add(list[i].toInt())
    }
    arr.add(0)
    arr.sort()
    var sum = 0
    for(i in 1..n){
        arr[i] = arr[i-1]+arr[i]
        sum+=arr[i]
    }
    println(sum)
}