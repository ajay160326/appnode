data class Meeting(private val _id: Int, private val _type: String, private var _date: String) : Event {
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
        return "Meeting scheduled on $date"
    }

    override fun reschedule(newDate: String): String {
        date = newDate
        return "Meeting rescheduled to $newDate"
    }
}
