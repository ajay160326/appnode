fun main() {
    val repository = EmployeeRepository()
    var running = true

    while (running) {
        println("Employee Management System")
        println("1. Add Employee")
        println("2. View Employee")
        println("3. View All Employees")
        println("4. Update Employee")
        println("5. Delete Employee")
        println("6. Exit")
        print("Choose an option: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Enter Name: ")
                val name = readLine().orEmpty()
                print("Enter Position: ")
                val position = readLine().orEmpty()
                print("Enter Salary: ")
                val salary = readLine()?.toDoubleOrNull() ?: 0.0
                val employee = repository.addEmployee(name, position, salary)
                println("Added Employee: $employee")
            }
            2 -> {
                print("Enter Employee ID: ")
                val id = readLine()?.toIntOrNull()
                val employee = id?.let { repository.getEmployee(it) }
                if (employee != null) {
                    println("Employee: $employee")
                } else {
                    println("Employee not found.")
                }
            }
            3 -> {
                val employees = repository.getAllEmployees()
                if (employees.isNotEmpty()) {
                    employees.forEach { println(it) }
                } else {
                    println("No employees found.")
                }
            }
            4 -> {
                print("Enter Employee ID: ")
                val id = readLine()?.toIntOrNull()
                if (id != null && repository.getEmployee(id) != null) {
                    print("Enter New Name: ")
                    val name = readLine().orEmpty()
                    print("Enter New Position: ")
                    val position = readLine().orEmpty()
                    print("Enter New Salary: ")
                    val salary = readLine()?.toDoubleOrNull() ?: 0.0
                    val success = repository.updateEmployee(id, name, position, salary)
                    if (success) {
                        println("Employee updated successfully.")
                    } else {
                        println("Failed to update employee.")
                    }
                } else {
                    println("Employee not found.")
                }
            }
            5 -> {
                print("Enter Employee ID: ")
                val id = readLine()?.toIntOrNull()
                val success = id?.let { repository.deleteEmployee(it) } ?: false
                if (success) {
                    println("Employee deleted successfully.")
                } else {
                    println("Failed to delete employee.")
                }
            }
            6 -> {
                running = false
                println("Exiting...")
            }
            else -> {
                println("Invalid option. Please try again.")
            }
        }
    }
}
