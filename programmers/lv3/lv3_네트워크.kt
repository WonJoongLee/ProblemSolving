import java.util.*
class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val arr = Array(n){ArrayList<Int>()}
        val q : Queue<Int> = LinkedList()
        val v = BooleanArray(n){false} // 방문했는지여부 체크

        for(i in 0 until n){
            for(j in 0 until n){
                if(computers[i][j] == 1){ // 연결되어 있다면 추가
                    arr[i].add(j)
                }
            }
        }

        for(i in 0 until n){
            if(v[i]) continue
            q.add(i)
            v[i] = true
            while(q.isNotEmpty()){
                val cur = q.poll()
                for(j in arr[cur]){
                    if(!v[j]){
                        v[j] = true
                        q.add(j)
                    }
                }
            }
            answer++
        }


        return answer
    }
}