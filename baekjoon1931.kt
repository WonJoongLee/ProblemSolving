import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = mutableListOf<Pair<Int, Int>>()
    val ansList = mutableListOf<Pair<Int, Int>>()
    var endTime = 0
    repeat(br.readLine().toInt()){
        val (a, b)= br.readLine().toString().split(' ').map{it.toInt()}
        arr.add(Pair(a,b))
    }
    arr.sortBy { it.first }
    arr.sortBy { it.second }
    ansList.add(arr[0]) // 일단 제일 일찍 끝나는 회의 추가
    endTime = arr[0].second
    for(i in 1 until arr.size){
        //println("first : ${arr[i].first}, endTime : $endTime")
        if(arr[i].first >= endTime){ // 만약 탐색한 회의의 시작 시간이 맨 마지막에 들어간 회의의 끝나는 시간보다 빠르면 추가한다.
//            if(arr[i].first == ansList[ansList.size-1].first || arr[i].second == ansList[ansList.size-1].second){ // 중복 처리를 해줘야 함.
//                continue
//            }
            endTime = arr[i].second
            ansList.add(arr[i])
        }
    }
    //println(ansList)
    println(ansList.size)
}