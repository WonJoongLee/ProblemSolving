import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat(br.readLine().toInt()) {
        val map = mutableMapOf<Long, Int>()
        val pqAscend = PriorityQueue<Long>() // 오름차순, default값
        val pqDescend = PriorityQueue<Long>(Collections.reverseOrder()) // 내림차순
        val k = br.readLine().toInt()
        for (i in 0 until k) {
            val (cmd, b) = br.readLine().split(' ')
            val value = b.toLong()
            if (cmd == "I") {
                var update = 0
                if (map[value] != null) { // 기존에 값이 있었으면, 즉 중복된 값이 들어오면
                    update = map[value]!! // 기존에 있던 값을 update에 넣는다.
                }
                update++ // 그리고 하나 더 들어왔으므로 update를 더한다.
                map.put(value, update)
                pqDescend.add(value)
                pqAscend.add(value)
            } else if (cmd == "D" && value == -1L) {// 최솟값 삭제
                while (true) {
                    val modi = pqAscend.poll() ?: break // pqAscend에 값이 없으면 탈출한다.
                    if (map[modi]!! > 0) {
                        map[modi] = map[modi]!! - 1
                        break
                    }
                }
            } else if (cmd == "D" && value == 1L) { // 최댓값 삭제
                while (true) {
                    val modi = pqDescend.poll() ?: break
                    if (map[modi]!! > 0) {
                        map[modi] = map[modi]!! - 1
                        break
                    }
                }
            }
        }
        while(pqAscend.isNotEmpty() && map[pqAscend.peek()] == 0){
            pqAscend.poll()
        }
        while(pqDescend.isNotEmpty() && map[pqDescend.peek()] == 0){
            pqDescend.poll()
        }
        if (pqAscend.isEmpty() || pqDescend.isEmpty()) {
            println("EMPTY")
        } else {
            println("${pqDescend.poll()} ${pqAscend.poll()}")
        }
    }
}
