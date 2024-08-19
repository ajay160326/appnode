import Foundation

// Function 1 
func Area(length: Int, width: Int){
   let result = length * width 
   print("Function 1: Result=", result)
}

// Function 2
func Area(l: Int, w: Int){
   let result = l * w
   print("Function 2: Result=", result)
}

// Calling function 1
Area(length: 23, width: 3)

// Calling function 2
Area(l:13, w: 3)