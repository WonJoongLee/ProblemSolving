import java.util.Scanner

fun main(){
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    for(i in 0 until n){
        val a = sc.nextInt()
        val b = sc.nextInt()
        var ans = 1
        /*b일 때까지 반복하면서 a를 ans에 곱해준다.
        * 끝자리만 보기 위해서 여기서 %10 처리를 해준다.*/
        for(j in 1..b){
            ans = (ans*a)%10
        }
        /*%10을 해주면 0도 생길 수 있는데, 이를 대비해서 10을 출력할 수 있게 해준다*/
        if(ans==0) println("10")
        else
            println(ans)
    }
}