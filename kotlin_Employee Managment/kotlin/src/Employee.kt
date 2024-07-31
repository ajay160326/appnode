 class Employee(
    val id: Int,
    val name: String,
    val position: String,
    val salary: Double
) {
     fun copy(name: String? = null, position: String? = null, salary: Double? = null): Employee {
         return Employee(
             id = this.id,
             name = name ?: this.name,
             position = position ?: this.position,
             salary = salary ?: this.salary
         )

     }
 }
 

