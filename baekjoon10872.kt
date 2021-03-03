fun main() {
    val br = System.`in`.bufferedReader()
    var answer = 1
    for(i in 1..br.readLine().toInt()){
        answer *= i
    }
    println(answer)
}