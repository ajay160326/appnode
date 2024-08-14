func printNumbers(_ numbers: Int...) {
    for number in numbers {
        print(number)
    }
}

// Call the function with different numbers of arguments
printNumbers(1, 2, 3, 4, 5)
printNumbers(10, 20)
printNumbers()
