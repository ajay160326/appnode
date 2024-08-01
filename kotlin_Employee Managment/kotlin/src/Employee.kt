 class Employee(
    val id: Int,
    val name: String,
    val position: String,
    val salary: Double
) {
     fun copy( id: Int? = 1,name: String? = "Ajay", position: String? = "developer", salary: Double? = 500000.0): Employee {
         return Employee(
             id = this.id,
             name = name ?: this.name,
             position = position ?: this.position,
             salary = salary ?: this.salary
         )

     }
 }
 

