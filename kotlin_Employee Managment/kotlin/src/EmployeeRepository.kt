class EmployeeRepository {
    private val employees = mutableMapOf<Int, Employee>()
    private var nextId = 1

    fun addEmployee(name: String, position: String, salary: Double): Employee {
        val employee = Employee(nextId++, name, position, salary)
        employees[employee.id] = employee
        return employee
    }

    fun getEmployee(id: Int): Employee? {
        return employees[id]
    }

    fun getAllEmployees(): List<Employee> {
        return employees.values.toList()
    }

    fun updateEmployee(id: Int, name: String, position: String, salary: Double): Boolean {
        val employee = employees[id] ?: return false
        val updatedEmployee = employee.copy(name = name, position = position, salary = salary)
        employees[id] = updatedEmployee
        return true
    }

    fun deleteEmployee(id: Int): Boolean {
        return employees.remove(id) != null
    }
}
