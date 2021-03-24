import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    val str = br.readLine().toString()
    var ansArr = ""
    val stack = Stack<Char>()
    fun compare(ch : Char) : Int{
        return if(ch == '(') 0
        else if(ch=='+'||ch=='-') 1
        else 2
    }
    for(i in str.indices){
        if(str[i] in 'A'..'Z'){
            ansArr = ansArr.plus(str[i])
        }else if(str[i]=='('){
            stack.push(str[i])
        }else if(str[i]==')'){
            while(stack.isNotEmpty()){
                if(stack.peek() == '('){
                    stack.pop()
                    break
                }
                ansArr = ansArr.plus(stack.pop())
            }
        }else{
            while(stack.isNotEmpty() && compare(str[i])<=compare(stack.peek())){
                ansArr = ansArr.plus(stack.pop())
            }
            stack.push(str[i])
        }
    }
    while(stack.isNotEmpty()){
        ansArr = ansArr.plus(stack.pop())
    }
    println(ansArr)
}