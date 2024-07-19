class Employee(
    val empId: Int,
    var name: String,
    var position: String,
    var salary: Double
) {
    fun displayEmployeeDetails() {
        println("ID: $empId, Name: $name, Position: $position, Salary: $salary")
    }
}



class EmployeeManagementSystem {
    private val employees = mutableListOf<Employee>()

    fun addEmployee(empId: Int, name: String, position: String, salary: Double) {
        val newEmployee = Employee(empId, name, position, salary)
        employees.add(newEmployee)
        println("Employee $name added successfully.")
    }

    fun removeEmployee(empId: Int) {
        val iterator = employees.iterator()
        while (iterator.hasNext()) {
            val employee = iterator.next()
            if (employee.empId == empId) {
                iterator.remove()
                println("Employee ${employee.name} removed successfully.")
                return
            }
        }
        println("Employee not found.")
    }

    fun displayAllEmployees() {
        if (employees.isEmpty()) {
            println("No employees to display.")
        } else {
            employees.forEach { it.displayEmployeeDetails() }
        }
    }

    fun findEmployeeById(empId: Int) {
        for (employee in employees) {
            if (employee.empId == empId) {
                employee.displayEmployeeDetails()
                return
            }
        }
        println("Employee not found.")
    }
}



fun main() {
    val ems = EmployeeManagementSystem()

    ems.addEmployee(1, "Alice", "Manager", 70000.0)
    ems.addEmployee(2, "Bob", "Engineer", 50000.0)
    ems.addEmployee(3, "Charlie", "Technician", 40000.0)

    println("\nAll Employees:")
    ems.displayAllEmployees()

    println("\nFind Employee by ID 2:")
    ems.findEmployeeById(2)

    println("\nRemoving Employee with ID 1")
    ems.removeEmployee(1)

    println("\nAll Employees after removal:")
    ems.displayAllEmployees()
}