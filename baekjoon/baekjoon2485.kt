import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val list = Array<Int>(n){0}
    val q : Queue<Int> = LinkedList<Int>()
    var min = 999999999
    for(i in 0 until n){
        list[i] = br.readLine().toInt()
        q.add(list[i])
        if(i>0 && list[i]-list[i-1]<min){
            min = list[i] - list[i-1]
        }
    }
    var tree = list[0]
    while(min>0){
        var check = true
        for(i in list){
            if((i-tree)%min!=0){
                check=false
                break
            }
        }
        if(check) break
        else if(!check) min--
    }
    var cnt = 0
    while(q.isNotEmpty()){
        if(tree == q.peek()){
            q.poll()
        }else cnt++
        tree+=min
    }
    println(cnt)
}