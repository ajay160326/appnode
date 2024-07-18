import java.time.LocalDate

data class Transaction(
    val date: LocalDate,
    val amount: Double,
    val description: String
)

class TransactionList {
    val transactions = mutableListOf<Transaction>()

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun deleteTransaction(index: Int) {
        if (index in transactions.indices) {
            transactions.removeAt(index)
        } else {
            println("Invalid index")
        }
    }

    fun editTransaction(index: Int, newTransaction: Transaction) {
        if (index in transactions.indices) {
            transactions[index] = newTransaction
        } else {
            println("Invalid index")
        }
    }

    fun displayTransactions() {
        transactions.forEachIndexed { index, transaction ->
            println("$index: ${transaction.date} - $${transaction.amount} - ${transaction.description}")
        }
    }
}

fun main() {
    val transactionList = TransactionList()

    transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 1), 100.0, "Grocery"))
    transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 2), 50.0, "Gas"))
    transactionList.addTransaction(Transaction(LocalDate.of(2023, 7, 3), 200.0, "Rent"))

    println("Initial transactions:")
    transactionList.displayTransactions()

    transactionList.deleteTransaction(1)
    println("\nAfter deleting index 1:")
    transactionList.displayTransactions()

    transactionList.editTransaction(0, Transaction(LocalDate.of(2023, 7, 1), 120.0, "Grocery and Supplies"))
    println("\nAfter editing index 0:")
    transactionList.displayTransactions()
}