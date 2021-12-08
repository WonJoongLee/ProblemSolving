fun main() {
    val arr = IntArray(10001)
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    repeat(br.readLine().toInt()) {
        arr[br.readLine().toInt()]++
    }
    br.close()
    arr.forEachIndexed { index, value ->
        bw.write("${index}\n".repeat(value))
    }
    bw.close()
}