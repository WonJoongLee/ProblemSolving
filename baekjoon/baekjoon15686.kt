import kotlin.math.absoluteValue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val chickenHousePoint = mutableListOf<Pair<Int, Int>>()
    val housePoint = mutableListOf<Pair<Int, Int>>()
    val arr = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val list = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            if (list[j] == 2) { // 치킨 집인 경우
                chickenHousePoint.add(Pair(i, j))
            } else if (list[j] == 1) {
                housePoint.add(Pair(i, j))
            }
            arr[i][j] = list[j]
        }
    }
    // 입력 끝

    val combList = mutableListOf<List<Pair<Int, Int>>>()
    val tempList = mutableListOf<Pair<Int, Int>>()
    fun combination(nowList: List<Pair<Int, Int>>) {
        if (nowList.size == m) {
            combList.add(nowList)
            return
        }
        val startIndex = if (nowList.isNotEmpty()) chickenHousePoint.indexOf(nowList.last()) + 1 else 0
        for (i in startIndex until chickenHousePoint.size) {
            combination(nowList.plus(chickenHousePoint[i]))
        }
    }

    combination(tempList)
    var finalMinSum = Int.MAX_VALUE
    for (list in combList) {
        var sum = 0
        housePoint.forEach { house ->
            var min = Int.MAX_VALUE
            // 제일 가까운 치킨 집 찾아서 추가
            list.forEach { chicken ->
                val distance =
                    (house.first - chicken.first).absoluteValue + (house.second - chicken.second).absoluteValue
                if (distance < min) min = distance
            }
            sum += min
        }
        if (sum < finalMinSum) finalMinSum = sum
    }

    println(finalMinSum)
}