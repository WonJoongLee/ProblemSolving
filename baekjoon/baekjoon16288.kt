fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    //val order = br.readLine().toList().map { it.toInt() }
    val order = br.readLine().split(" ").map { it.toInt() }
    val q = IntArray(k) { -1 }

    var printed = false

    for (i in 0 until n) {
        var chk = false
        for (j in 0 until k) {
            if (order[i] > q[j]) {
                q[j] = order[i]
                chk = true
                break
            }
        }
        if(!chk){ // 다 못들어갔음
            println("NO")
            printed = true
            break
        }
    }
    if(!printed){
        println("YES")
    }
}