import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    data class Cell(
        val i: Int,
        val j: Int,
        var isCheese: Boolean,
        var isAirCheese: Boolean // 공기랑 닿아있으면 true
    )

    var ansTime = 0

    val v = Array(n) { BooleanArray(m) { false } }
    val q: Queue<Cell> = LinkedList()
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)
    val arr = Array(n) { Array<Cell>(m) { Cell(-1, -1, false, false) } }
    var cheeseCnt = 0
    for (i in 0 until n) {
        val list = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            arr[i][j] = Cell(i, j, list[j] == 1, false)
            if(arr[i][j].isCheese) cheeseCnt++
        }
    }
    fun bfs(i: Int, j: Int) {
        while (q.isNotEmpty()) {
            val curCell = q.poll()
            for (k in 0 until 4) {
                val nextI = curCell.i + dx[k]
                val nextJ = curCell.j + dy[k]
                if (nextI in 1 until n - 1 && nextJ in 1 until m - 1 && !v[nextI][nextJ]) {
                    v[nextI][nextJ] = true
                    if (arr[nextI][nextJ].isCheese) {
                        arr[nextI][nextJ].isAirCheese = true
                    } else {
                        q.add(arr[nextI][nextJ])
                    }
                }
            }
        }
    }

    var cheeseList = mutableListOf<Int>()
    while (true) {
        // 겉 부분만 돌면서 bfs
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (i == 0) { // 첫 행일 때
                    q.add(arr[i][j])
                    bfs(i, j)
                } else if (i in 1 until n - 1 && (j == 0 || j == m - 1)) { // 왼쪽 오른쪽 열일 때
                    q.add(arr[i][j])
                    bfs(i, j)
                } else if (i == n - 1) { // 마지막 행일 때
                    q.add(arr[i][j])
                    bfs(i, j)
                }
            }
        }
        // 다 돌고나면 치즈 제거
        arr.forEach { cellList ->
            cellList.filter { it.isAirCheese }.map { it.isCheese = false }
        }
        var cheeseCount = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                v[i][j] = false
                if (arr[i][j].isCheese) {
                    cheeseCount++
                }
            }
        }
        cheeseList.add(cheeseCount)
        // 치즈가 더이상 없으면 탈출
        if (cheeseCount == 0) {
            break
        }
        ansTime++

    }
    println(ansTime + 1)
    if(cheeseList.size >= 2){
        println(cheeseList[cheeseList.size - 2])
    }
    else{
        println(cheeseCnt)
    }
}