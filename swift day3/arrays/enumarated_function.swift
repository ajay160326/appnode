
// Defining and initializing an array
var someArr:[Int] = [3, 56, 23, 34, 5, 78, 9]

print("Array Elements with their index value:")

// Iterating over the array using for-in loop along with enumerated() function
for (index, element) in someArr.enumerated() {
   print("Value at index = \(index) is \(element)")