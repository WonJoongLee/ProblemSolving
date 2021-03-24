import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.ArrayList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    //val arr = Array(n+1){ArrayList<Int>() } // 정점의 개수만큼 배열 선언
    //val arr = Array(n+1){IntArray(n+1){_->-1}}
    //val visited = Array(n+1){IntArray(n+1)}
    val visited =Array(n+1){_->false} //모두 방문하지 않은 것, 즉 false로 처리
    var sum = 0

    val temp = Array(n+1){ArrayList<Int>()}

    for(i in 0 until m){ // 간선 수만큼 반복하면서 연결된 정점 확인
        val (a, b) = br.readLine().split(' ').map{it.toInt()}
        //println("$a, $b")
        temp[a].add(b)
        temp[b].add(a)
    }
    //println(temp[1])
    fun dfs(x : Int){
        visited[x] = true
        for(j in temp[x]){
            if(!visited[j]){
                //println(j)
                dfs(j)
            }
        }
    }
    //println("${arr[0].sum()}, ${-n-1}")
    for(i in 1..n){
        if(!visited[i]){ // 만약 방문하지 않았다면 탐색
            //println("i : $i")
            dfs(i)
            sum++ // 탐색이 안되서 새로 들어온 것이기 때문에 sum에 1을 더함
        }
    }
    println(sum)
}