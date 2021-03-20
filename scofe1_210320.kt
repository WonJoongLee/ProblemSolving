fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    data class Person(val id: Int, val startHour: Int, val startMin: Int, val endHour: Int, val endMin: Int) // id는 몇 번 째 사람인지

    val personList = Array(21) { Person(-1, -1, -1,-1,-1) }
    for (i in 1..n) {
        val temp = br.readLine().toString()
        val startHour = temp.slice(0..1).toInt()
        val startMin = temp.slice(3..4).toInt()
        val endHour = temp.slice(8..9).toInt()
        val endMin = temp.slice(11..12).toInt()
        println("$startHour, $startMin, $endHour, $endMin")
        personList[i] = Person(i, startHour, startMin, endHour, endMin)
    }
    for (i in 1..n) {
        println(personList[i])
    }

    //제일 늦게부터 되는 사람 찾는 부분
    var maxHour = -1
    var maxMin = -1
    for (i in 1..n) {
        val curPerson = personList[i]
        //시간이 더 늦다면 초기화
        if(curPerson.startHour>=maxHour){
            //만약 시간까지 같다면 분을 확인
            if(curPerson.startHour == maxHour){
                //분까지 더 늦다면 초기화
                if(curPerson.startMin > maxMin){
                    maxHour = curPerson.startHour
                    maxMin = curPerson.startMin
                }
            }else{ // 시작시간이 다르면 더 크기 떄문에 그냥 초기화
                maxHour = curPerson.startHour
                maxMin = curPerson.startMin
            }
        }
    }

    var minHour = 24
    var minMin = 60
    for (i in 1..n) {
        val curPerson = personList[i]
        //시간이 더 빠르다면 초기화
        if(curPerson.endHour <= minHour){
            //만약 시간까지 같다면 분 비교
            if(curPerson.endHour==minHour){
                if(curPerson.endMin < minMin){
                    minHour = curPerson.endHour
                    minMin = curPerson.endMin
                }
            }else{
                minHour = curPerson.endHour
                minMin = curPerson.endMin
            }
        }
    }

    var check = false // 만약 겹치는 시간이 없다면 true로 바꿈
    println("$maxHour, $maxMin, $minHour, $minMin")
    if(maxHour >= minHour){
        if(maxHour == minHour){ // 시간이 같다면 분 비교
            if(maxMin > minMin){
                check = true
            }
        }else{ // 그냥 maxHour가 더 크면 check true로 변경
            check = true
        }
    }
    var finalMaxHour = ""
    var finalMaxMin = ""
    var finalMinHour = ""
    var finalMinMin = ""
    if(check){
        println("-1")
    }else{
        finalMaxHour = if(maxHour <= 9 ){
            "0".plus(maxHour.toString())
        }else{
            maxHour.toString()
        }

        finalMaxMin = if(maxMin <= 9){
            "0".plus(maxMin.toString())
        }else{
            maxMin.toString()
        }

        finalMinHour = if(minHour <= 9){
            "0".plus(minHour.toString())
        }else{
            minHour.toString()
        }

        finalMinMin = if(minMin <= 9){
            "0".plus(minMin.toString())
        }else{
            minMin.toString()
        }

        println("$finalMaxHour:$finalMaxMin ~ $finalMinHour:$finalMinMin")
    }
}