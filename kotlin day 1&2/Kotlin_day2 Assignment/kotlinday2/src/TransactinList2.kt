import java.time.LocalDate

open class Transactionn(
    open val date: LocalDate,
    open val amount: Double,
    open val description: String
) {
    override fun toString(): String = "$date - $${Math.abs(amount)} - $description"
}

class Income(
    override val date: LocalDate,
    amount: Double,
    override val description: String,
    val source: String
) : Transactionn(date, Math.abs(amount), description) {
    override fun toString(): String = "Income: ${super.toString()} (Source: $source)"
}

class Expense(
    override val date: LocalDate,
    amount: Double,
    override val description: String,
    val category: String
) : Transactionn(date, -Math.abs(amount), description) {
    override fun toString(): String = "Expense: ${super.toString()} (Category: $category)"
}

fun main() {
    val transactions = listOf(
        Income(LocalDate.of(2023, 7, 1), 1000.0, "Salary", "Employment"),
        Expense(LocalDate.of(2023, 7, 2), 50.0, "Groceries", "Food"),
        Income(LocalDate.of(2023, 7, 3), 200.0, "Freelance work", "Consulting"),
        Expense(LocalDate.of(2023, 7, 4), 100.0, "Electricity bill", "Utilities")
    )

    println("All transactions:")
    transactions.forEach { println(it) }

    println("\nTotal income: $${transactions.filterIsInstance<Income>().sumOf { it.amount }}")
    println("Total expenses: $${Math.abs(transactions.filterIsInstance<Expense>().sumOf { it.amount })}")
}