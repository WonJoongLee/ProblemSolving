import java.util.*
import java.util.Arrays.sort
import kotlin.math.roundToInt


fun main(args: Array<String>): Unit {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    var arr = arrayOfNulls<Int>(n)
    var dupl: Array<Int> = Array(8002) { 0 } // -4000부터 4000까지 입력받을 수 있으므로 8000으로 하고 값을 넣을 때 4000을 더해서 넣음
    var sum = 0.0 // 입력되는 값들의 합 저장
    var maxNums = mutableListOf<Int>()
    for (i in 0 until n) {
        val temp: Int = sc.nextInt()
        dupl[temp + 4000]++
        arr[i] = temp
        sum += temp
    }
    val avg: Double = sum / n
    val sortedArr = arr.sortedWith(compareBy { it })

    var max = 0
    var realMax = -99999
    var realMin = 99999
    for (i in arr.indices) {
        if (arr[i]!! > realMax) {
            realMax = arr[i]!!
        }
        if (arr[i]!! < realMin) {
            realMin = arr[i]!!
        }
    }
    for (i in 0..8001) {
        if (dupl[i] == max) {
            maxNums.add(i - 4000)
        }
        if (dupl[i] > max) { // 기존 max보다 더 큰 값이 나오면 array를 초기화시키고 dupl[i]를 추가한다.
            for (j in 0 until maxNums.size) {
                maxNums[j] = -99999
            }
            maxNums.add(i - 4000)
            max = dupl[i]
        }
    }

    var tempMaxNums = mutableListOf<Int>() // 0인 것들은 모두 빼주기 위함
    for (j in 0 until maxNums.size) {
        if (maxNums[j] != -99999) {
            tempMaxNums.add(maxNums[j])
        }
    }

    println(avg.roundToInt()) // 평균 출력
    println(sortedArr[n / 2]) // 중앙값 출력
    val arealMaxNums = tempMaxNums.sortedWith(compareBy { it }).reversed()
    if (arealMaxNums.size > 1) {
        println(arealMaxNums[arealMaxNums.size - 2])//값이 많으면 끝에서 두번째 최빈값
    } else {
        println(arealMaxNums[0])//최빈값이 하나면 그냥 하나 출력
    }
    println(realMax - realMin)

    //println(arealMaxNums)

}