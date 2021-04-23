fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    data class Person(val weight : Int, val height : Int)
    val people = ArrayList<Person>()
    repeat(n){
        val (weight, height) = br.readLine().split(" ").map { it.toInt() }
        people.add(Person(weight, height))
    }
    for(i in 0 until n){
        val person = people[i]
        var rank = 1
        for(j in 0 until n){
            if(person.weight < people[j].weight && person.height < people[j].height){
                rank++
            }
        }
        print("$rank ")
    }
}