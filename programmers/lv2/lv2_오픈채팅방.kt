class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()

        val hm : HashMap<String, String> = HashMap()
        val ansStrs = mutableListOf<Pair<String, String>>() // uid, 들어왔는지 나갔는지

        for(rec in record){
            if(rec[0]=='L'){
                val (a, b) = rec.split(" ").map{it.toString()}
                ansStrs.add(Pair(b, "Leave")) // b uid가 나감
            }else{
                val (a, b, c) = rec.split(" ").map{it.toString()}
                if(a[0]=='E'){ // Enter일 경우
                    hm.put(b, c)
                    ansStrs.add(Pair(b, "Enter")) // b uid가 들어옴
                }else if(a[0]=='C'){ // change일 경우
                    hm.replace(b, c)
                }
            }
        }

        for(ansStr in ansStrs){
            if(ansStr.second[0] == 'E'){ // 만약 들어왔다면
                answer = answer.plus("${hm[ansStr.first]}님이 들어왔습니다.")
            }else{ // 나갔다면
                answer = answer.plus("${hm[ansStr.first]}님이 나갔습니다.")
            }
        }

        return answer
    }
}