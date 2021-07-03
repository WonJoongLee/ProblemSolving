fun main() {
    // 방 번호가 0도 될 수 있음
    val br = System.`in`.bufferedReader()
    val nums = br.readLine().toString()
    val roomNum = mutableListOf<BooleanArray>()
    roomNum.add(BooleanArray(10) { false }) // 사용됐으면 true, 사용되지 않았으면 false

    for (num in nums) {
        var chk = false // 있는지 확인하는 변수, 기존 배열에 있었으면 true로 전환
        for (i in roomNum.indices) {

            // 9번이고, 이미 9번이 사용되었고, 6번은 사용되지 않았다면 6번 사용처리
            if (num.toInt() - 48 == 9 && roomNum[i][9] && !roomNum[i][6]) {
                chk = true
                roomNum[i][6] = true
                break
            }

            // 6번이고, 이미 6번이 사용되었고, 9번은 사용되지 않았다면 9번 사용처리
            if (num.toInt() - 48 == 6 && roomNum[i][6] && !roomNum[i][9]) {
                chk = true
                roomNum[i][9] = true
                break
            }

            if (!roomNum[i][num.toInt() - 48]) {
                chk = true
                roomNum[i][num.toInt() - 48] = true // 사용 처리
                break
            }

        }
        if (!chk) {
            roomNum.add(BooleanArray(10) { false }) // 하나 배열 추가해주고
            roomNum[roomNum.size - 1][num.toInt() - 48] = true // 사용 처리
        }
    }
    println(roomNum.size)
}