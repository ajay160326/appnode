import java.time.LocalDate

data class Transaction(
    val amount: Double,
    val date: LocalDate,
    val category: String
)

fun categorizeTransaction(transaction: Transaction): String {
    return when (transaction.category.toLowerCase()) {
        "groceries", "restaurant" -> "Food"
        "electricity", "water", "gas" -> "Utilities"
        "movies", "games", "sports" -> "Entertainment"
        else -> "Other"
    }
}

fun main() {
    val transactions = listOf(
        Transaction(50.0, LocalDate.now(), "Groceries"),
        Transaction(30.0, LocalDate.now(), "Movies"),
        Transaction(100.0, LocalDate.now(), "Electricity"),
        Transaction(20.0, LocalDate.now(), "Books")
    )

    for (transaction in transactions) {
        val category = categorizeTransaction(transaction)
        println("Transaction of ${transaction.amount} on ${transaction.date} categorized as: $category")
    }
}
