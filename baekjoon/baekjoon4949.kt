import java.util.Scanner
import java.util.Stack

fun main(args: Array<String>) : Unit{
    val sc : Scanner = Scanner(System.`in`)
    while(true) {
        val string = sc.nextLine()
        var stack = Stack<Char>()
        if(string == ".") break
        var j = 0
        //println(string)
        for(i in string.indices){
            //println(string[i])
            if(string[i]=='(' || string[i]==')' || string[i]=='[' || string[i]==']'){
                stack.push(string[i])
                //println(string[i])
                j++
                if(j != 1 && stack[j-1]==')' && stack[j-2]=='('){
                    stack.pop()
                    stack.pop()
                    j -= 2
                }else if(j != 1 && stack[j-1]==']' && stack[j-2]=='['){
                    stack.pop()
                    stack.pop()
                    j -= 2
                }
                //println(stack)
            }else continue
        }
        if(stack.isNotEmpty()){
            println("no")
        }else{
            println("yes")
        }
    }
}
