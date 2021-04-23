fun main() {
    val br = System.`in`.bufferedReader()
    val dwarf = ArrayList<Int>()
    repeat(9) {
        dwarf.add(br.readLine().toInt())
    }
    val sum = dwarf.sum()
    var done = false
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (i == j) continue
            else {
                if (sum - dwarf[i] - dwarf[j] == 100) {
                    done = true
                    if (i > j) {
                        dwarf.removeAt(i)
                        dwarf.removeAt(j)
                    } else {
                        dwarf.removeAt(j)
                        dwarf.removeAt(i)
                    }
                    break
                }
            }
        }
        if (done) break
    }
    dwarf.sort()
    for (i in dwarf) {
        println(i)
    }
}