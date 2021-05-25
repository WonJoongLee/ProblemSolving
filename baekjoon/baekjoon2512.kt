fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }.sorted()
    var limit = br.readLine().toInt()
    var max = nums.maxOrNull()
    var start = 0
    var end = max ?: 0
    var mid = 0
    while (start <= end) {
        mid = (start + end) / 2
        var sum = 0
        for (i in nums.indices) {
            sum += if (nums[i] > mid) {
                mid
            } else {
                nums[i]
            }
        }
        if (sum > limit) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    println(end)
}