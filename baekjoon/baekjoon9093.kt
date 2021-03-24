fun main() {
    val br = System.`in`.bufferedReader()
    repeat(br.readLine().toInt()) {
        for(i in br.readLine().split(" ")){
            print("${i.reversed()} ")
        }
        println()
    }
}
