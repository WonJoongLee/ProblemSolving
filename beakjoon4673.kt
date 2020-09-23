fun main(){
    var chknum = 0
    val array: Array<Int> = Array(10036) { 0 } // 0(거짓)인 상태로 두고 만들어지면 해당 array 1로 변경
    for( i in 1 until 10001){
        when{
            /*i가 1이상 10 이하일때*/
            i < 10 ->{
                chknum = i * 2
                array[chknum] = 1
            }
            (10<=i) and (i<=99) -> {
                val s = i.toString()
                chknum = i + s[0].toInt() + s[1].toInt() - 48*2
                array[chknum] = 1
            }
            (100<=i) and (i<=999) -> {
                val s = i.toString()
                chknum = i + s[0].toInt() + s[1].toInt() + s[2].toInt() - 48 * 3
                array[chknum] = 1
            }
            (1000<=i) and (i<=9999) -> {
                val s = i.toString()
                chknum = i + s[0].toInt() + s[1].toInt() + s[2].toInt() + s[3].toInt() - 48 * 4
                array[chknum] = 1
            }

        }
    }
    for(i in 1 until array.size){
        if((array[i]==0) and (i<10000)){
            println(i)
        }
    }
}