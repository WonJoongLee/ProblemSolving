import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val (a, b) = br.readLine().split(' ').map { it.toInt() }
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    data class Node(val curNum : Int, var routeDep : Int)
    val arr = Array(10001){ Stack<Int>() }
    val q : Queue<Node> = LinkedList<Node>()
    val visited = Array(10001){false}
    for(i in 0 until m){
        val (x, y) = br.readLine().split(' ').map { it.toInt() }
        arr[x].add(y)
        arr[y].add(x)
    }
    q.add(Node(a, 0))
    visited[a] = true
    var printed = false
    while (q.isNotEmpty()){
        val temp = q.poll()
        val number = temp.curNum
        val routeDepth = temp.routeDep
        if(number == b){
            println(routeDepth)
            printed = true
            break
        }
        for(i in arr[number].indices){
            if(!visited[arr[number][i]]){
                visited[arr[number][i]] = true
                q.add(Node(arr[number][i], routeDepth+1))
//                if(arr[number][i] == b){
//                    println(routeDepth+1)
//                    printed = true
//                }
            }
        }
    }
    if(!printed) println(-1)
}