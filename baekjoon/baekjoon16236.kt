import java.util.*

fun main() {
    val dx = arrayOf(1, -1, 0, 0)
    val dy = arrayOf(0, 0, 1, -1)
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { IntArray(n) }
    var sharkSize = 2
    var eatCnt = 0
    var v = Array(n) { BooleanArray(n) { false } }
    var ansTime = 0

    data class CoData(
        var i: Int,
        var j: Int,
        val time: Int
    ) : Comparable<CoData> {
        // value가 작은 것 순위, 같으면 행이 높은 것, 그다음으로는 왼쪽
        override fun compareTo(other: CoData) = compareValuesBy(this, other, { it.time }, { it.i }, { it.j })
    }

    val sharkPos = CoData(-1, -1, 0) // 시간은 쓰레기값
    val canList = mutableListOf<CoData>() // 먹을 수 있는 상어 리스트

    for (i in 0 until n) {
        val list = br.readLine().split(" ").map { it.toInt() }
        for (j in list.indices) {
            arr[i][j] = list[j]
            if (list[j] == 9) { // 9라면 상어 위치 초기화
                arr[i][j] = 0
                sharkPos.i = i
                sharkPos.j = j
            }
        }
    }
    // 입력 끝

    var minTime = Int.MAX_VALUE
    val q: Queue<CoData> = LinkedList()

    fun bfs() {
        while (q.isNotEmpty()) {
            val cur = q.poll()
            for (i in 0 until 4) {
                val nextI = cur.i + dx[i]
                val nextJ = cur.j + dy[i]
                val time = cur.time
                // 다음으로 이동할 수 있고 방문한 적이 없고, 상어의 크기가 이상이면
                if (nextI in 0 until n && nextJ in 0 until n && !v[nextI][nextJ] && sharkSize >= arr[nextI][nextJ]) {
                    v[nextI][nextJ] = true
                    // 먹을 수 있는 물고기이고, 시간이 더 적게 걸린다면
                    if (sharkSize > arr[nextI][nextJ] && arr[nextI][nextJ] != 0 && time <= minTime) {
                        canList.add(CoData(nextI, nextJ, time + 1))
                        // 물고기가 없고, 다음으로 이동했을 때 시간이 더 적거나 같다면
                    } else if (sharkSize >= arr[nextI][nextJ] && time + 1 <= minTime) {
                        q.add(CoData(nextI, nextJ, time + 1))
                    }
                }
            }
        }
    }

    while (true) {
        minTime = Int.MAX_VALUE
        v[sharkPos.i][sharkPos.j] = true
        q.add(CoData(sharkPos.i, sharkPos.j, 0))
        bfs()
        if (canList.isEmpty()) break
        canList.sort()
        sharkPos.i = canList[0].i // 먹을 수 있는 곳 중 제일 가까운 곳으로 이동
        sharkPos.j = canList[0].j
        arr[sharkPos.i][sharkPos.j] = 0 // 먹은 곳 초기화
        ansTime += canList[0].time
        canList.clear()
        eatCnt++ // 먹었으니까 1더함
        v = Array(n) { BooleanArray(n) { false } } // 초기화
        if (eatCnt == sharkSize) { // 자신의 크기만큼 먹었으면 업데이트
            eatCnt = 0
            sharkSize++
        }
    }
    println(ansTime)
}