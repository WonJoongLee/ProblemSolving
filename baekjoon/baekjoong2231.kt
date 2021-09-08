fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine()
    var cur = ""
    for (i in 1..n.toString().toInt()) {
        cur = i.toString()
        if (i + cur.sumOf { it.toString().toInt() } == n.toString().toInt()) {
            break
        }
    }
    if (cur == n.toString()) {
        println("0")
    } else {
        println(cur)
    }
}