package basic

/**
 *
 */
fun main(args : Array<String>) {

}

/**
 * 関数オブジェクトを介してローカル変数を参照することができる
 * クロージャ：コードを記述した時のスコープで変数が扱える関数オブジェクトのこと
 */
fun counterSample() {
    val counter1 = getCounter()
    val counter2 = getCounter()
    println(counter1()) // 出力0
    println(counter1()) // 出力1
    println(counter2()) // 出力0
    println(counter1()) // 出力2
    println(counter2()) // 出力1

}

fun getCounter(): () -> Int {
    var count = 0;
    return {
        count++
    }
}