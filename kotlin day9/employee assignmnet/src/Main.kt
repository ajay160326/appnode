import java.util.Scanner

fun main() {
    val employees = mutableListOf<Employee>()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Employee Management System")
        println("1. Add Employee")
        println("2. View Employees")
        println("3. Update Employee")
        println("4. Delete Employee")
        println("5. Exit")
        print("Enter your choice: ")

        when (scanner.nextInt()) {
            1 -> addEmployee(employees, scanner)
            2 -> viewEmployees(employees)
            3 -> updateEmployee(employees, scanner)
            4 -> deleteEmployee(employees, scanner)
            5 -> {
                println("Exiting...")
                break
            }
            else -> println("Invalid choice, please try again.")
        }
    }
}

fun addEmployee(employees: MutableList<Employee>, scanner: Scanner) {
    println("Enter Employee ID:")
    val id = scanner.nextInt()
    println("Enter Employee Name:")
    val name = scanner.next()
    println("Enter Employee Age:")
    val age = scanner.nextInt()
    println("Enter Employee Department:")
    val department = scanner.next()
    println("Enter Employee Salary:")
    val salary = scanner.nextDouble()

    employees.add(Employee(id, name, age, department, salary))
    println("Employee added successfully.")
}

fun viewEmployees(employees: List<Employee>) {
    if (employees.isEmpty()) {
        println("No employees found.")
    } else {
        for (employee in employees) {
            println(employee)
        }
    }
}

fun updateEmployee(employees: MutableList<Employee>, scanner: Scanner) {
    println("Enter Employee ID to update:")
    val id = scanner.nextInt()

    val employee = employees.find { it.id == id }
    if (employee != null) {
        println("Enter new name (current: ${employee.name}):")
        val newName = scanner.next()
        println("Enter new age (current: ${employee.age}):")
        val newAge = scanner.nextInt()
        println("Enter new department (current: ${employee.department}):")
        val newDepartment = scanner.next()
        println("Enter new salary (current: ${employee.salary}):")
        val newSalary = scanner.nextDouble()

        val updatedEmployee = employee.copy(name = newName, age = newAge, department = newDepartment, salary = newSalary)
        employees[employees.indexOf(employee)] = updatedEmployee
        println("Employee updated successfully.")
    } else {
        println("Employee not found.")
    }
}

fun deleteEmployee(employees: MutableList<Employee>, scanner: Scanner) {
    println("Enter Employee ID to delete:")
    val id = scanner.nextInt()

    val employee = employees.find { it.id == id }
    if (employee != null) {
        employees.remove(employee)
        println("Employee deleted successfully.")
    } else {
        println("Employee not found.")
    }
}