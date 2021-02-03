import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var visited: Array<IntArray>
lateinit var arr: Array<IntArray>
var m: Int = 0
var n: Int = 0
var k: Int = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    repeat(br.readLine().toInt()) {
        val mnk = br.readLine().toString().split(' ')
        var ans = 0
        m = mnk[0].toInt() // 열
        n = mnk[1].toInt() // 행
        k = mnk[2].toInt()
        arr = Array(n + 1) { IntArray(m + 1) } // m*n행렬 만들려면 이렇게 해야함
        visited = Array(n + 1) { IntArray(m + 1) } // m*n행렬 만들려면 이렇게 해야함
        for (i in 0 until n) {
            for (j in 0 until m) {
                //println("i : $i, j : $j")
                visited[i][j] = 0 // 0이면 방문하지 않은 것, 1이면 방문한 것
                arr[i][j] = 0 // m*n 배열 0으로 초기화
            }
        }
        for (i in 0 until k) {
            val temp = br.readLine().toString().split(' ')
            val x = temp[0].toInt()
            val y = temp[1].toInt()
            arr[y][x] = 1 // 배추 있는 부분 1로 초기화
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (arr[i][j] == 1 && visited[i][j] != 1) { // 배추가 있고, 방문하지 않았으면
                    ans++
                    dfs(i, j)
                }
            }
        }
        println(ans)
    }
}

fun dfs(x: Int, y: Int) {
    //println("x : $x, y : $y")
    visited[x][y] = 1
    //왼쪽, 위, 오른쪽, 아래 순서로 연결되어 있는지 확인한다.
    if (x - 1 >= 0 && arr[x - 1][y] == 1 && visited[x - 1][y] != 1) {//왼쪽이 배열을 넘어가지 않고, 배추가 심어져 있다면 왼쪽도 탐색
        dfs(x - 1, y)//왼쪽탐색
    }
    if (y - 1 >= 0 && arr[x][y - 1] == 1 && visited[x][y - 1] != 1) {
        dfs(x, y - 1)//위쪽탐색
    }
    if (x + 1 < n && arr[x + 1][y] == 1 && visited[x + 1][y] != 1) {
        dfs(x + 1, y)//오른쪽탐색
    }
    if (y + 1 < m && arr[x][y + 1] == 1 && visited[x][y + 1] != 1){
        dfs(x, y + 1)//오른쪽탐색
    }
}
