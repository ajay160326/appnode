import Foundation

// Function 1 
func Addition(num1: Int, num2: Int){

   // Adding two values
   let result = num1 + num2
   print("Function 1: Result = ", result)
}

// Function 2  
func Addition(num1: String, num2: String){

   // Adding two values
   let result = num1 + num2 
   print("Function 2: Result = ", result)
}

// Calling function 1
Addition(num1: 23, num2: 34)

// Calling function 2
Addition(num1: "Hello!", num2: "Tutorialspoint")