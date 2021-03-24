fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = mutableListOf<Int>()
    arr.add(1)
    arr.add(2)
    arr.add(3)
    if (n >= 4) {
        for (i in 4..n) {
            arr.add((arr[i - 2] + arr[i - 3]) % 15746)
        }
        println(arr[n - 1])
    } else {
        println(arr[n - 1] % 15746)
    }
}