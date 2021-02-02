import java.io.BufferedReader
import java.io.InputStreamReader

var n : Int = 0
var m : Int = 0
var graph: Array<IntArray> = arrayOf()
var visited : BooleanArray = booleanArrayOf()
var arr = mutableListOf<Int>()

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    n = br.readLine().toInt()
    m = br.readLine().toInt()
    visited = BooleanArray(n+1)
    graph = Array(n+1){IntArray(n+1)}
    for(i in 0 until m){
        val list = br.readLine().toString().split(' ')
        graph[list[0].toInt()][list[1].toInt()] = 1
        graph[list[1].toInt()][list[0].toInt()] = 1
    }
    for(i in 0..n){
        visited[i] = false
    }
    dfs(1)
    print("${arr.size}")
}

fun dfs(v : Int){
    visited[v] = true
    for(i in 1 until n+1){
        if(graph[v][i] == 1 && !visited[i]){
            arr.add(i)
            dfs(i)
        }
    }
}