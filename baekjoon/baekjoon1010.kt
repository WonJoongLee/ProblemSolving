fun main() {
    val br = System.`in`.bufferedReader()
    repeat(br.readLine().toInt()) {
        var (small, big) = br.readLine().split(" ").map { it.toLong() }.sorted()

        if (small > big / 2.0) {
            small = big - small
        }

        var tempSmall = 1.0
        var tempBig = 1.0
        var cntBig = big
        var cnt = 0

        while (true) {
            if (cnt == small.toInt()) break
            tempBig *= cntBig
            cntBig--
            cnt++
        }
        for (i in 1..small) {
            tempSmall *= i
        }
        println((tempBig / tempSmall).toInt())
    }
}