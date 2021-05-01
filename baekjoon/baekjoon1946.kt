fun main(){
    val br= System.`in`.bufferedReader()
    data class Person(val doc : Int, val view : Int)
    repeat(br.readLine().toInt()){
        val n = br.readLine().toInt()
        val personList = ArrayList<Person>()
        var cnt = 1
        repeat(n){
            val (doc, view) = br.readLine().split(" ").map { it.toInt() }
            personList.add(Person(doc, view))
        }
        personList.sortBy { it.doc } // sortBy는 원래 값에 적용을 시키고, sortedBy는 변화된 값을 return해준다.
        var prevViewRank = personList[0].view
        for(i in 1 until n){
            if(personList[i].view < prevViewRank){
                prevViewRank = personList[i].view
                cnt++
            }
        }
        println(cnt)
    }
}