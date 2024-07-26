fun main() {
    val schedule = Schedule()

    val meeting1 = Meeting(1, "Meeting", "2024-08-01")
    val meeting2 = Meeting(2, "Meeting", "2024-08-02")
    val conference = Conference(3, "Conference", "2024-08-01")

    schedule.addEvent(meeting1)
    schedule.addEvent(meeting2)
    schedule.addEvent(conference)

    println("Events on 2024-08-01:")
    schedule.filterByDate("2024-08-01").forEach { println(it) }

    println("Meetings:")
    schedule.filterByType("Meeting").forEach { println(it) }
}
