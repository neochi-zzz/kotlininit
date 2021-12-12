package basic

/**
 * 基本的な記法たち
 */

fun main(args: Array<String>) {

    /**
     * セット
     */
    val intsSet: Set<Int> = setOf(1, 2, 1, 3)
    print("Set : ${intsSet} \n")

    val charSet: MutableSet<Char> = mutableSetOf('4', '3', '3', '1');
    print("MutableSet : ${charSet} \n")

    /**
     * マップ
     */
    val numMap: Map<String, Int> = mapOf("one" to 1, "two" to 2)
    print("Map : ${numMap} \n")

    val charMap: MutableMap<String, Char> = mutableMapOf("a" to 'A', "b" to 'B')
    print("MutableMap : ${charMap} \n")

    /**
     * レンジ
     */
    val range: IntRange = 12..15
    print("range : ${range} \n")
    print("5 in range is ${5 in range} \n")
    print("5 !in range is ${5 !in range} \n")

    // tolistを使うとrangeオブジェクトをlistに変換できる（not mutable）
    val rangeToList: List<Int> = (1..5).toList()
    print("rangeToList : ${rangeToList} \n")

    //逆順もできるよ（回りくどいし分かりづらいから使いたくないけど）
    val rangeToReverseList: List<Int> = range.reversed().toList()
    print("rangeToReverseList : ${rangeToReverseList} \n")

    //reversedを使うよりもdownToを使うと良い
    val rangeDownToList: List<Int> = (5 downTo 1).toList()
    print("rangeDownToList : ${rangeDownToList} \n")

    //刻み幅をつけてrangeを生成することも可能
    val rangeToStepList: List<Int> = (1..5 step 2).toList()
    val rangeToDownStepList: List<Int> = (100 downTo 0 step 25).toList()
    print("stepList : ${rangeToStepList} \n")
    print("downStepList : ${rangeToDownStepList} \n")


    /**
     * 条件分岐 if
     * javaと同じように記述することが可能だが、kotlinならではの書き方もできる
     */
    val bool: Boolean = true
    val x = if (bool) {
        // bool = true ならx = 1, falseならx = 2となる
        1
    } else {
        2
    }

    // 条件分岐のチェーンも作れる
    val score: Int = 75
    val y: Char =
            if (score >= 90) 'A'
            else if (score >= 80) 'B'
            else if (score >= 70) 'C'
            else 'D'
    print("y = ${y}\n")


    /**
     * 条件分岐 when
     * javaのSwitchを強化した感じ
     */

    val xAnswer: Boolean =
            when (x) {
                1 -> true
                2, 3 -> false
                else -> false
            }
    print("xAnswer : ${xAnswer}\n")

    //条件分岐の中に定数以外を指定できる
    val yAnswer: String =
            when (y) {
                'A' -> "大変よくできました"
                'B' -> "よくできました"
                myValue() -> "まあまあできたのでは？"
                else -> "留年"
            }
    print("yAnswer : ${yAnswer}\n")

    //isを使って型判定もできるよ
    val str: String = "hello"
    val blank = when (str) {
        is String -> " "
        else -> true
    }
    printValue("blank : ${blank}")

    //else-ifのブロックチェーンが簡単にできる
    val valueY: Char = when {
        score >= 90 -> 'A'
        score >= 80 -> 'B'
        score >= 70 -> 'C'
        else -> 'D'
    }
    printValue("valueY : ${valueY}")


    /**
     * whileループ
     */

    var count = 3
    while (count-- > 0) {
        printValue("while")
    }

    // do-while
    // javaと違う点は、doの中で定義した変数をwhileの条件文として指定できること
    do {
        printValue("do-while")
        val next = Math.random() < 0.5
    } while (next)


    /**
     * for ループ
     */

    for (x in arrayOf(1, 2, 3, 4)) {
        printValue("for x ${x}")
    }

    val names : List<String> = listOf("りんご","ゴリラ","ラッパ")
    for (name in names) {
        printValue(name)
    }

    for (i in 1..10 step 2) {
        printValue("${i}")
    }

    // breakもcontinueも当然ある
    var golliraIndex : Int  = -1
    for (index in names.indices) {
        if (names[index] == "ゴリラ") {
            golliraIndex = index
            break
        }
    }

    // ラベル付きのジャンプもサポート
    // break@ラベル名、continue@ラベル名でジャンプ可能

    jump@ for (x in 1..10) {
        for (y in 1..10) {
            printValue("(${x}, ${y})")
            if (y == 5) {
                continue@jump
            }
        }
    }

}


fun printValue(message: String) {
    print("${message}\n")
}

fun myValue(): Char {
    return 'C'
}
