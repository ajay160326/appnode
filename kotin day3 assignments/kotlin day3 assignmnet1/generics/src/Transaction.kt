class Transaction(private var _id: Int, private var _amount: Double) {

    var id: Int
        get() = _id
        private set(value) {
            _id = value
        }

    var amount: Double
        get() = _amount
        set(value) {
            if (value >= 0) {
                _amount = value
            } else {
                throw IllegalArgumentException("Amount cannot be negative")
            }
        }

    // Optionally override toString for better output formatting
    override fun toString(): String {
        return "Transaction(id=$id, amount=$amount)"
    }
}
