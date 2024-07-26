data class User(val id: Int, val name: String)

class UserManager {
    private val users = mutableListOf<User>()

    fun addUser(user: User) {
        if (users.none { it.id == user.id }) {
            users.add(user)
        } else {
            println("User with ID ${user.id} already exists.")
        }
    }

    fun removeUser(userId: Int) {
        val userToRemove = users.find { it.id == userId }
        if (userToRemove != null) {
            users.remove(userToRemove)
        } else {
            println("User with ID $userId not found.")
        }
    }

    fun listUsers(): List<User> {
        return users.toList()
    }
}
