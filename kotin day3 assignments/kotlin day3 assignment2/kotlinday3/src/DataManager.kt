class DataManager<T> {
    private val data = mutableListOf<T>()

    fun addItem(item: T) {
        data.add(item)
    }

    fun removeItem(item: T) {
        data.remove(item)
    }

    fun getItems(): List<T> = data.toList()
}
