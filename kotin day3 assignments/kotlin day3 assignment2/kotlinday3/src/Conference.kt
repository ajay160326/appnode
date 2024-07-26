data class Conference(private val _id: Int, private val _type: String, private var _date: String) : Event {
    override val id: Int
        get() = _id
    override val type: String
        get() = _type
    override var date: String
        get() = _date
        set(value) {
            _date = value
        }

    override fun schedule(): String {
        return "Conference scheduled on $date"
    }

    override fun reschedule(newDate: String): String {
        date = newDate
        return "Conference rescheduled to $newDate"
    }
}
