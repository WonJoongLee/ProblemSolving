import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var arr = Array(200010) { _ -> -1 } // 오른쪽 자식 노드도 확인해야 하므로 20만으로 잡는 것이 맞다.
    var pos = 1
    for (i in 1..n) {
        val input = br.readLine().toInt()
        //println("pos : $pos")
        for (j in 1..n) {
            //print("[$j : ${arr[j]}] ")
        }
        if (input == 0) {
            if (arr[1] == -1) { // 배열이 비어 있을 때
                println("0")
            } else {
                var currentNode = 1
                println(arr[1])
                //arr[pos-1] = arr[1].also { arr[1] = arr[pos-1] } // 루트노드와 마지막 노드를 바꿔줌
                var temp = 0
                temp = arr[1]
                arr[1] = arr[pos-1]
                arr[pos-1] = temp
                arr[pos-1] = -1 // 마지막 노드 제거
                //println("초기 : ${arr[1]}, ${arr[pos-1]}")
                if(pos>=2){
                    //pos = pos - 1
                    pos-=1
                }
                while (!(arr[currentNode] > arr[currentNode * 2] && arr[currentNode] > arr[currentNode * 2 + 1]) && arr[1]!=-1) {
                    //println("${arr[currentNode]}, ${arr[currentNode*2]}, ${arr[currentNode*2+1]}")
                    //현재 노드가 왼쪽 자식노드와 오른쪽 자식노드보다 크면 탈출
                    if (arr[currentNode * 2] > arr[currentNode * 2 + 1]) {
                        //만약 왼쪽 노드가 오른쪽 노드보다 크면
                        arr[currentNode] = arr[currentNode * 2].also { arr[currentNode * 2] = arr[currentNode] }
                        currentNode *= 2
                    } else {
                        //만약 오른쪽 노드가 왼쪽 노드보다 크면
                        arr[currentNode] = arr[currentNode * 2 + 1].also { arr[currentNode * 2 + 1] = arr[currentNode] }
                        currentNode = currentNode * 2 + 1
                    }
                }
            } // 루트 노드 출력 후 제거
        } else { // 숫자 삽입
            //println()//TODO 추후에 삭제
            //arr[n] = input
            arr[pos] = input
            var currentNode = pos++
            while (arr[currentNode] > arr[currentNode / 2]) {
                //println("c : $currentNode")
                // 만약 부모 노드보다 크다면 교환
                //arr[currentNode / 2] = arr[currentNode].also { arr[currentNode] = arr[currentNode /2] }
                if (currentNode / 2 == 0) {
                    break
                }
                var temp = 0
                temp = arr[currentNode]
                arr[currentNode] = arr[currentNode / 2]
                arr[currentNode / 2] = temp // 둘이 바꿈, also가 잘 안되는 것 같아서 이렇게 함
                //println("[${currentNode / 2} : ${arr[currentNode / 2]}] ")
                currentNode /= 2 // 부모노드로 올라갔으므로 노드도 부모노드로 바꿔줌
            }
        }
    }

}