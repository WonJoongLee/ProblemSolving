import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 1

        var pos = 0 // 몇 번째 버스까지 담겼는지 체크할 pos
        var wSum = 0 // 다리 위의 무게를 체크할 변수
        val bridgeQ: Queue<Int> = LinkedList()
        val timeQ: Queue<Int> = LinkedList()
        while (true) {
            answer++
            if (pos < truck_weights.size && wSum + truck_weights[pos] <= weight) { // 다리에 더 올라갈 수 있다면
                bridgeQ.add(truck_weights[pos]) // 트럭 추가
                timeQ.add(answer) // 해당 트럭의 현재 시간 추가
                wSum += truck_weights[pos]
                pos++
            }
            //println("$timeQ, $bridgeQ, $answer")
            if (answer - timeQ.peek() == bridge_length - 1) { // 만약 제일 앞에 있는 트럭의 시간이 끝나면 poll한다.
                timeQ.poll()
                wSum -= bridgeQ.poll()
            }
            if (bridgeQ.isEmpty() && timeQ.isEmpty() && pos == truck_weights.size) break
            //Thread.sleep(700)
        }
        return answer
    }
}