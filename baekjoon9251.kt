import java.lang.Integer.max

fun main(){
    val br = System.`in`.bufferedReader()
    val firstStr = br.readLine()
    val secondStr = br.readLine()
    val arr = Array(secondStr.length+1){IntArray(firstStr.length+1)}
    for(i in 0 until firstStr.length + 1){
        arr[0][i] = 0 // arr 행령의 첫 행을 0으로 초기화
    }
    for(i in 0 until secondStr.length+1){
        arr[i][0] = 0 // arr 행렬의 첫 열을 0으로 초기화
    }

    for(i in 1 until secondStr.length + 1){
        for(j in 1 until firstStr.length+1) {
            if(firstStr[j-1] == secondStr[i-1]){
                arr[i][j] = arr[i-1][j-1] + 1
            }
            else{
                arr[i][j] = max(arr[i-1][j], arr[i][j-1])
            }
        }
    }
    println(arr[secondStr.length][firstStr.length])
}