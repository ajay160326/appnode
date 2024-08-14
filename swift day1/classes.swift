  class Person {
        var name: String
        var age: Int

        init(name: String, age: Int) {
            self.name = name
            self.age = age
        }

        func describe() -> String {
            return "\(name) is \(age) years old."
        }
    }

    let person = Person(name: "Jeevan", age: 30)
    print(person)