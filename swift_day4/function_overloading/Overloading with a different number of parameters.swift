import Foundation

// Function 1 
func product(num1: Int, num2: Int){

   // Calculating product 
   let result = num1 * num2
   print("Function 1: Product = ", result)
}

// Function 2  
func product(num1: Int, num2: Int, num3: Int){

   // Calculating product 
   let result = num1 * num2 * num3
   print("Function 2: Product = ", result)
}

// Function 3 
func product(num1: Int, num2: Int, num3: Int, num4: Int){

   // Calculating product 
   let result = num1 * num2 * num3 * num4
   print("Function 3: Product = ", result)
}

// Calling function 1
product(num1: 23, num2: 34)

// Calling function 2
product(num1: 53, num2: 34, num3: 34)

// Calling function 3
product(num1: 23, num2: 34, num3: 55, num4: 21)