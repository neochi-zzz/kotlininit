package basic.ObjectToClass

fun createBucket(_capacity: Int): Bucket = object : Bucket {
    override fun fill() {
        quantity = capacity
    }

    override fun drainAway() {
        quantity = 0
    }

    override fun pourTo(that: Bucket) {
        val  thatVacuity = that.capacity - that.quantity
        if (capacity <= thatVacuity) {
            that.quantity += quantity
            drainAway()
        } else {
            that.fill()
            quantity -= thatVacuity
        }
    }

    override val capacity = _capacity
    override var quantity: Int = 0

}