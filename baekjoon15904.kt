fun main(){
    val br = System.`in`.bufferedReader()
    val string = br.readLine()
    var u = false
    var c1 = false
    var p = false
    var c2 = false
    for(i in string.indices){
        if(string[i]== 'U'){
            u = true
        }
        if(u){
            if(string[i]== 'C'){
                c1 = true
            }
        }
        if(u && c1){
            if(string[i]=='P'){
                p = true
            }
        }
        if(u&&c1&&p){
            if(string[i]=='C'){
                c2 = true
            }
        }
    }
    if(u&&c1&&p&&c2) println("I love UCPC")
    else println("I hate UCPC")
}