import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, c, r) = br.readLine().split(' ').map { it -> it.toInt() }
    n = (2.0).pow(n).toInt()
    var ans = 0
    fun search(curSize: Int, curX: Int, curY: Int) {
        if (curSize > 1) {
            if(c<curX+curSize/2&&r<curY+curSize/2){ // 2사분면에 위치해있다면
                search(curSize / 2, curX, curY)
            }else if(c<curX+curSize/2&&r>=curY+curSize/2){ // 1사분면
                ans += (curSize/2)*(curSize/2)*1
                search(curSize / 2, curX, curY + curSize / 2)
            }else if(c>=curX+curSize/2&&r<curY+curSize/2){ // 3사분면
                ans += (curSize/2)*(curSize/2)*2
                search(curSize / 2, curX + curSize / 2, curY)
            }else if(c>=curX+curSize/2&&r>=curY+curSize/2){ // 4사분면
                ans += (curSize/2)*(curSize/2)*3
                search(curSize / 2, curX + curSize / 2, curY + curSize / 2)
            }
        }
    }
    search(n, 0, 0)
    println(ans)
}
