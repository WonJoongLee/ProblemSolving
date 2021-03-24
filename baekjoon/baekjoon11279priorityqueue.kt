import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val pq=PriorityQueue<Int>(Collections.reverseOrder())
    for(i in 1..n){
        val input = br.readLine().toInt()
        if(input!=0){
            pq.add(input)
        }else{
            if(pq.isNotEmpty()){
                println(pq.poll())
            }else{
                println(0)
            }
        }
    }
}
