package basic


/**
 * インライン関数
 */
inline fun log(debug : Boolean = true, message: () -> String) {
    if (debug) {
        println(message())
    }
}

fun main(args: Array<String>) {
    log { "このメッセージは出力される" }
    log (false){ "このメッセージは出力されない" }
}

/*
上記は概ね以下と同じコードと言える

fun main(args: Array<String>) {
    if (true) {
        println("このメッセージは出力される")
    }
    if (false) {
        println ("このメッセージは出力されない")
    }
}
 */