import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val temp = br.readLine().toString()
        for (j in 0 until n) {
            arr[i][j] = temp[j].toInt() - 48
        }
    }
    // 입력 끝

    data class Node(val i: Int, val j: Int)

    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)
    val visited = Array(n) { BooleanArray(n) { false } }
    val q: Queue<Node> = LinkedList()

    val answers = mutableListOf<Int>()
    var houseCnt = 0

    fun bfs() {
        var cnt = 0

        //하나짜리인지 확인하기 위한 코드
//        val tempCur = q.peek()
//        var tempChk = false
//        for(i in 0 until 4){
//            if (tempCur.i + dx[i] !in 0 until n) {
//                continue
//            }
//            if (tempCur.j + dy[i] !in 0 until n) {
//                continue
//            }
//            if (!visited[tempCur.i + dx[i]][tempCur.j + dy[i]] && arr[tempCur.i + dx[i]][tempCur.j + dy[i]] == 1) {
//                tempChk = true
//                break
//            }
//        }
//        if(!tempChk){
//            answers.add(1)
//            return // 한칸짜리라면 주변 탐색 없이 return
//        }

        while (q.isNotEmpty()) {
            val cur = q.poll()
            //visited[cur.i][cur.j] = true
            for (i in 0 until 4) {
                //만약 방문하지 않았고 1이라면 큐에 추가
                if (cur.i + dx[i] !in 0 until n) {
                    continue
                }
                if (cur.j + dy[i] !in 0 until n) {
                    continue
                }
                if (!visited[cur.i + dx[i]][cur.j + dy[i]] && arr[cur.i + dx[i]][cur.j + dy[i]] == 1) {
                    cnt++
                    visited[cur.i + dx[i]][cur.j + dy[i]] = true
                    q.add(Node(cur.i + dx[i], cur.j + dy[i]))
                }
            }
        }

        if (cnt != 0) {
            answers.add(cnt)
        } else {
            answers.add(1)
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j] && arr[i][j] == 1) { // 방문하지 않았다면 탐색
                q.add(Node(i, j))
                houseCnt += 1
                bfs()
            }
        }
    }

    println(houseCnt)
    for (ans in answers.sorted()) {
        println(ans)
    }
}