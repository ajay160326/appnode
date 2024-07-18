import java.time.LocalDateTime

data class Event(val id: Int, val name: String, val date: LocalDateTime)

class EventManager {
    private val events = mutableListOf<Event>()
    private var nextId = 1

    fun addEvent(name: String, date: LocalDateTime): Int {
        val event = Event(nextId++, name, date)
        events.add(event)
        return event.id
    }

    fun removeEvent(id: Int): Boolean {
        return events.removeIf { it.id == id }
    }

    fun listEvents() {
        events.forEach { println("ID: ${it.id}, ${it.name} on ${it.date}") }
    }
}

fun main() {
    val manager = EventManager()
    val concertId = manager.addEvent("Concert", LocalDateTime.now().plusDays(10))
    manager.addEvent("Conference", LocalDateTime.now().plusDays(20))

    println("Events after adding:")
    manager.listEvents()

    manager.removeEvent(concertId)
    println("\nEvents after removing Concert:")
    manager.listEvents()
}