import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val pq = PriorityQueue<Int>()
    repeat(br.readLine().toInt()){
        val n = br.readLine().toInt()
        if(n!=0){
            pq.add(n)
        }else if(n==0){
            if(pq.isEmpty()){
                println(0)
            }else {
                println(pq.poll())
            }
        }
    }
}