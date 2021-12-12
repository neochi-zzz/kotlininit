package basic

fun square2(i: Int): Int = i * i

fun main(args: Array<String>) {
    println(::square2)
    /**
     *　関数オブジェクト
     */
    val sqFunction = ::square2
    println(sqFunction(5))


    println(firstK("dkdkdiieK"))
}

/**
 * 高階関数
 * 関数を引数にしたり、返り値として返すような関数
 * 一般に呼び出しコスト高め
 */
fun first(str: String, predicate: (Char) -> Boolean): Int {
    tailrec fun go(str: String, index: Int): Int =
        when {
            str.isEmpty() -> -1
            predicate(str.first()) -> index
            else -> go(str.drop(1), index + 1)
        }
    return go(str, 0)

}

fun firstK(str: String): Int {
    fun isK(c: Char): Boolean = c == 'K'
    return first(str, ::isK)
}

/**
 * ラムダ式
 * 関数オブジェクトを直接生成するもの
 * 型推論もはたらくようになっている。
 */
val square: (Int) -> Int = { i: Int ->
    i * i
}

//　引数が一つだけの時、特別に変数itが使える。
//　明示的に名前をつけたほうが良い場面があるから濫用に注意。
val cubed: (Int) -> Int = {
    it * it * it
}

//fun firstWhitespace(str: String): Int {
//    val isWhiteSpace: (Char) -> Boolean = {
//        it.isWhitespace()
//    }
//    return first(str, isWhiteSpace)
//}

//　ラムダ式を直接引数として渡したパターン
fun firstWhitespace(str: String): Int = first(str, {it.isWhitespace()})

//　構文糖衣
//　ラムダ式を引数リストの外に出すことができる特別な関数
fun firstWhitespaceSuger(str: String): Int =
        first(str) {it.isWhitespace()}