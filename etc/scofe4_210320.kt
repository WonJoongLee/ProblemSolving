fun main(){
    val br = System.`in`.bufferedReader()
    val (likeA, likeB, likeC, likeD, likeE) = br.readLine().split(" ").map { it.toFloat() }
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    data class Content(var seen : Char, var genre : Char, var i : Int, var j : Int, var like : Float)
    val contentList = mutableListOf<Content>()
    var pos = 0
    for(i in 0 until n){
        val temp = br.readLine().toString()
        for(j in temp.indices){
            contentList.add(Content(temp[j], 'X', i, j, -1F))
        }
    }
    pos = 0
    for(i in 0 until n){
        val temp = br.readLine().toString()
        for(j in temp){
            contentList[pos].genre = j
            when(j){
                'A'->{
                    contentList[pos].like = likeA
                }
                'B'->{
                    contentList[pos].like = likeB
                }
                'C'->{
                    contentList[pos].like = likeC
                }
                'D'->{
                    contentList[pos].like = likeD
                }
                'E'->{
                    contentList[pos].like = likeE
                }
            }
            pos++
        }
    }
    //입력받는 것 끝!!

    //우선순위 1
    var yContentList =mutableListOf<Content>() // 아예 안본거
    var oContentList =mutableListOf<Content>() // 끝까지 안본거

    for(i in contentList){
        if(i.seen == 'Y'){//본적 없는 것
            yContentList.add(i)
        }
    }
    //yContentList = yContentList.sortedWith(compareBy({it.like}, {it.i}, {it.j})).toMutableList()
    yContentList = yContentList.sortedWith(compareBy({-it.like}, {it.i}, {it.j})).toMutableList()
    //yContentList.reverse()
    for(i in contentList){
        if(i.seen == 'O'){//끝까지 안본거
            oContentList.add(i)
        }
    }
    oContentList = oContentList.sortedWith(compareBy({-it.like}, {it.i}, {it.j})).toMutableList()
    //oContentList.reverse()
    for(i in yContentList){
        println("${i.genre} ${i.like} ${i.i} ${i.j}")
    }
    for(i in oContentList){
        println("${i.genre} ${i.like} ${i.i} ${i.j}")
    }
}