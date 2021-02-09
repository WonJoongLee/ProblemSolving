fun main() {
    val br = System.`in`.bufferedReader()
    val (A, B, C) = br.readLine().split(' ').map { it.toLong() }
    fun power(a: Long, b: Long, c: Long): Long {
        if (b == 1L) return a
        val temp = power(a, b / 2, c) % c
        return if (b % 2 == 0L) {
            temp * temp % c
        } else {
            temp * temp % c * a % c
        }
    }
    println(power(A % C, B, C))
}