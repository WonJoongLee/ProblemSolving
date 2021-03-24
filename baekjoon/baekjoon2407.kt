import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val (tempN, tempM) = br.readLine().split(' ')
    var n = BigInteger(tempN)
    var m = BigInteger(tempM)
    var mother = BigInteger("1")
    var son = BigInteger("1")
    if (n.divide(BigInteger("2")) < m) m = n.minus(m)
    val sonStart = n.minus(m).toInt()
    for (i in sonStart+1L..n.toInt()) {
        son = son.multiply(BigInteger("$i"))
    }
    for(i in 1L..m.toInt()){
        mother = mother.multiply(BigInteger("$i"))
    }
    println(son/mother)
}
