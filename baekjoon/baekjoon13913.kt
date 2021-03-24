import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (start, exit) = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(200001) { false }
    val arr = IntArray(200001)
    val q: Queue<Int> = LinkedList()
    if(start==exit){
        println("0\n${start}")
        return
    }
    q.add(start)
    visited[start] = true
    var time = 0
    fun bfs() {
        while (q.isNotEmpty()) {
            for (i in 0 until q.size) {
                val cur = q.poll()
                if (cur == exit) {
                    return
                }
                if (cur * 2 <= 100000 && !visited[cur * 2]) {
                    arr[cur * 2] = cur
                    visited[cur * 2] = true
                    q.add(cur * 2)
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    arr[cur - 1] = cur
                    visited[cur - 1] = true
                    q.add(cur - 1)
                }
                if (cur + 1 <= 100000 && !visited[cur + 1]) {
                    arr[cur + 1] = cur
                    visited[cur + 1] = true
                    q.add(cur + 1)
                }
            }
            time++
        }
    }
    bfs()
    var temp = exit
    val ansArr = mutableListOf<Int>()
    ansArr.add(exit)
    while(true){
        temp = arr[temp]
        if(temp==start) break
        else ansArr.add(temp)
    }
    ansArr.add(start)
    println(time)
    for(i in ansArr.size-1 downTo 0){
        print("${ansArr[i]} ")
    }
}