fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val list = Array(n) { IntArray(6) }
    for (i in 0 until n) {
        list[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }


    var finalMax = -1
    for (i in 0 until 6) {
        var curPos = i // 시작 값을 i로 설정
        var max = 0
        //println(curPos)
        //println("!!!")
        for (j in 0 until n) {
            val tempList = list[j].toMutableList()
            //println(curPos)
//            for(i in tempList){
//                print("$i ")
//            }
            //println()
            when (curPos) {
                0 -> {
                    for (k in 0 until 6) {
                        if (j + 1 < n && list[j][5] == list[j + 1][k]) {
                            curPos = k
                        }
                    }
                    tempList[0] = 0
                    tempList[5] = 0
                    max += tempList.max()!!
                }
                1 -> {
                    for (k in 0 until 6) {
                        if (j + 1 < n && list[j][3] == list[j + 1][k]) {
                            curPos = k
                        }
                    }
                    tempList[1] = 0
                    tempList[3] = 0
                    max += tempList.max()!!
                }
                2 -> {
                    for (k in 0 until 6) {
                        if (j + 1 < n && list[j][4] == list[j + 1][k]) {
                            curPos = k
                        }
                    }
                    tempList[2] = 0
                    tempList[4] = 0
                    max += tempList.max()!!
                }
                3 -> {
                    for (k in 0 until 6) {
                        if (j + 1 < n && list[j][1] == list[j + 1][k]) {
                            curPos = k
                        }
                    }
                    tempList[1] = 0
                    tempList[3] = 0
                    max += tempList.max()!!
                }
                4 -> {
                    for (k in 0 until 6) {
                        if (j + 1 < n && list[j][2] == list[j + 1][k]) {
                            curPos = k
                        }
                    }
                    tempList[2] = 0
                    tempList[4] = 0
                    max += tempList.max()!!
                }
                5 -> {
                    for (k in 0 until 6) {
                        if (j + 1 < n && list[j][0] == list[j + 1][k]) {
                            curPos = k
                        }
                    }
                    tempList[5] = 0
                    tempList[0] = 0
                    max += tempList.max()!!
                }
            }
            //println(max)
        }
        //println("파이널")
        //println(max)
        //println("====================")
        if (max > finalMax) finalMax = max
    }
    //println("max : $finalMax")
    println(finalMax)
}

