package basic.ObjectToClass

interface Bucket {
    fun fill()
    fun drainAway()
    fun pourTo(that: Bucket)

    val capacity: Int
    var quantity: Int
}