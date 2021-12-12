package basic

/**
 * 関数について
 */

fun main(args: Array<String>) {
    result("succ ${succ(31)}")
    hello()
    hello("yusuke!")

    sum(1, 2, 3)
    //可変長引数に配列を渡す時は*をつけてコンパイラが認識できるようにする
    sum(*intArrayOf(1, 2, 3))
    val ints: IntArray = intArrayOf(2, 3, 4)
    sum(*ints)

    //
    sumSaiki(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
}

fun result(mes: String) {
    print("${mes} \n")
}

fun succ(i: Int): Int = i + 1

fun square(i: Int): Int = i * i

fun max(a: Int, b: Int): Int = if (b <= a) a else b

/**
 * デフォルト引数をとることが可能
 */
fun hello(name: String = "world") {
    result("Hello, ${name}")
}

/**
 * 可変長引数
 * varargを書くだけで引数が可変的に取れる
 * 可変長引数は配列として扱われる
 *
 * caution!可変長引数は一つの関数について1つまでしか持てない！
 */
fun sum(vararg ints: Int): Int {
    var sum = 0
    for (i in ints) {
        sum += i
    }
    return sum
}

/**
 * 再帰呼び出し
 */
fun sumSaiki(nums: List<Long>): Long =
    if (nums.isEmpty()) 0
    // list.dro(n)
    // リストの先頭からn個の要素を除いた部分リスト
    else nums.first() + sumSaiki(nums.drop(1))

/**
 * 再帰呼び出し（TCO）
 */
tailrec fun sumSaikiSNonStackOverflow(nums: List<Long>, accumulator: Long = 0): Long =
    if (nums.isEmpty()) accumulator
    else sumSaikiSNonStackOverflow(nums.drop(1), accumulator + nums.first())


/**
 * ローカル関数（go()）
 */
fun sumLocalFunction(numbers : List<Long>): Long {
    tailrec fun go(nums: List<Long>, accumulator: Long = 0): Long =
        if (nums.isEmpty()) accumulator
        else go(nums.drop(1), accumulator + nums.first())
    return go(numbers, 0)
}

/**
 * 結果を返さない関数
 * 実際にはUnit型の結果を返している
 * Unit型の返却の際にはreturnを省略可能（普通は省略する）
 */
class Counter {
    private var cnt = 0;

    fun countUp(): Unit {
        cnt++
    }
    fun getCount() :Int = cnt
}


