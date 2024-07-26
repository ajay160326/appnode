interface Event {
    val id: Int
    val type: String
    var date: String

    fun schedule(): String
    fun reschedule(newDate: String): String
}
