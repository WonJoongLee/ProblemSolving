fun main() {
    val br = System.`in`.bufferedReader()
    repeat(br.readLine().toInt()) {
        val n = br.readLine().toInt()
        val list = br.readLine().split(' ').map { it.toInt() }
        var c0 = 0
        var c1 = 0
        var c2 = 0
        for (i in list.indices) {
            when (list[i] % 3) {
                0 -> c0++
                1 -> c1++
                2 -> c2++
            }
        }
        var ans = 0
        val avg = (c0 + c1 + c2) / 3
        while (true) {
            if (c1 == c2 && c0 == c1) break
            if(c0>avg){
                c0--
                c1++
                ans++
            }
            if(c1>avg){
                c1--
                c2++
                ans++
            }
            if(c2>avg){
                c2--
                c0++
                ans++
            }
        }
        println(ans)
    }
}