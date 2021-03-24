import java.util.Scanner

fun main(args: Array<String>) : Unit{
    val sc = Scanner(System.`in`)
    val k = sc.nextInt()
    val n  : Long= sc.nextLong()
    val maxAvailable : Long
    val arr = mutableListOf<Long>()
    for(i in 0 until k){
        arr.add(sc.nextLong())
    }
    maxAvailable = arr.sum() / n
    halfFind(maxAvailable, n, arr)
}

fun halfFind(max : Long, n : Long, arr : MutableList<Long>){
    var mid : Long
    var sum : Long = 0
    var left : Long = 1
    var right : Long = max
    var maxLen : Long = -1

    while(left<=right){
        sum = 0
        mid = (left+right) / 2

        for(i in 0 until arr.size){
            sum += (arr[i] / mid)
        }
        if(sum>=n){ // sum이 n이상일 때만 보면 된다.
            if(maxLen<mid){
                maxLen = mid
            }
            left= mid+1
        }else{
            right = mid - 1
        }
    }
    println(maxLen)
}
