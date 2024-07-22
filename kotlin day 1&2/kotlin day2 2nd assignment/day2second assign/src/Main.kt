class Todo(
        var id: Int?,
        var title: String?,
        var description: String?,
        var status: TodoStatus?
) {
        init {
                // Check if id is null, throw IllegalArgumentException if null
                if (id == null) {
                        throw IllegalArgumentException("Todo id must not be null")
                }
        }
}

enum class TodoStatus {
        TODO,
        IN_PROGRESS,
        DONE
}

fun main() {
        // Creating a Todo object with nullable properties
        val todo1 = Todo(1, "Complete assignment", "Finish the Kotlin assignment", TodoStatus.TODO)
        val todo2 = Todo(2, "Study for exam", null, TodoStatus.IN_PROGRESS) // description is nullable

        // Uncomment below to see the exception being thrown
        // val todo3 = Todo(null, "Test", "This should throw an exception", TodoStatus.DONE)

        // Accessing properties of todo objects
        println("Todo 1: ${todo1.title} - ${todo1.description ?: "No description"} - Status: ${todo1.status}")
        println("Todo 2: ${todo2.title} - ${todo2.description ?: "No description"} - Status: ${todo2.status}")
}