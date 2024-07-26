fun <T> printTransactions(transactions: Collection<T>) {
    transactions.forEach { println(it) }
}

fun <T> filterTransactions(transactions: Collection<T>, predicate: (T) -> Boolean): List<T> {
    return transactions.filter(predicate)
}

fun <T, K> mapTransactions(transactions: Map<K, T>, transform: (T) -> T): Map<K, T> {
    return transactions.mapValues { (_, value) -> transform(value) }
}
