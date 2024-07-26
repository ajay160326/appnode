fun main() {
    // Create some test transactions
    val transaction1 = Transaction(1, 100.0)
    val transaction2 = Transaction(2, 200.0)

    // Test generic functions
    val transactions = listOf(transaction1, transaction2)
    printTransactions(transactions)

    // Test UserManager
    val userManager = UserManager()
    val user1 = User(1, "Alice")
    val user2 = User(2, "Bob")

    userManager.addUser(user1)
    userManager.addUser(user2)
    userManager.removeUser(1)

    println("Users after removal:")
    userManager.listUsers().forEach { println(it) }
}
