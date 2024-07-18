import java.time.LocalDate

data class Event(
    val name: String,
    val date: LocalDate,
    val attendeeCount: Int
)

fun main() {
    val techConference = Event("Tech Conference", LocalDate.of(2024, 7, 20), 500)
    println("Event: ${techConference.name}")
    println("Date: ${techConference.date}")
    println("Expected Attendees: ${techConference.attendeeCount}")
}
