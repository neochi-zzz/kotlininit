package basic

/**
 * non-local-return
 * ラムダ式では最後の式の評価結果が返り値となるが
 * 外側の関数からのreturnが可能
 */
inline fun forEach(str : String, f: (Char) -> Unit ){
    for (c in str) {
        f(c)
    }
}

fun containsDigit(str : String): Boolean{
    forEach(str) {
        if (it.isDigit())
            return true
    }
    return false
}

/**
 * retun at label
 * ループの時のラベル制御と同じ
 * 関数名@ でもできる
 */
inline fun forEachLabel(str : String, f: (Char) -> Unit ){
    for (c in str) {
        f(c)
    }
}

fun containsDigitLabel(str : String): Boolean{
    var result = false
    forEach(str) here@{
        if (it.isDigit())
            result = true
            return@here
    }
    return result
}

fun main() {
    println(containsDigit("ABCD5FR"))
    println(containsDigitLabel("DDD4DDdjd"))
}
