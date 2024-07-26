class Schedule {
    private val events = mutableListOf<Event>()

    fun addEvent(event: Event) {
        events.add(event)
    }

    fun getEvents(): List<Event> = events

    fun filterByDate(date: String): List<Event> {
        return events.filter { it.date == date }
    }

    fun filterByType(type: String): List<Event> {
        return events.filter { it.type == type }
    }
}
