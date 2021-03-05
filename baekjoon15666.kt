import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").asSequence().map { it.toInt() }.toList().sorted().toSet().toList()
    val stack = Stack<Int>()
    fun rec(x : Int){
        stack.push(x)
        if(stack.size==m){
            for(i in stack){
                print("$i ")
            }
            println()
            stack.pop()
        }
        else{
            for(i in list){
                if(i>=x) rec(i)
            }
            stack.pop()
        }
    }
    for(i in list){
        rec(i)
    }
}