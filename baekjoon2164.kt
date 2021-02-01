import kotlin.collections.ArrayDeque

fun main(){
    val n = readLine()!!.toInt()
    var dq = ArrayDeque<Int>()
    for(i in n downTo 1){
        dq.add(i)
    }
    //println(dq)
    while(dq.size!=1){
        dq.removeLast()
        val lastToFirst = dq.removeLast()
        dq.addFirst(lastToFirst)
        //println(dq)
    }
    println(dq.first())
}