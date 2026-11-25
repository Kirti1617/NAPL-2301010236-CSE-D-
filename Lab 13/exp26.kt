fun main() {
    fun employee(name: String = "Kirti", age: Int = 22) {
        println("Name: $name")
        println("Age: $age")
    }
    println("1. Default Parameters")
    employee()
    println("Calling with custom values:")
    employee("Rahul", 25)
    println("\n2. Named Arguments")
    employee(age = 23, name = "Anushka")
    println("\n3. Vararg Function")
    fun displayNumbers(vararg numbers: Int) {
        println("Numbers:")
        for (num in numbers) {
            println(num)
        }
    }
    displayNumbers(10, 20, 30, 40, 50)
    println("\n4. Higher-Order Function")
    fun calculate(
        numbers: List<Int>,
        operation: (Int) -> Int
    ) {
        for (num in numbers) {
            println("$num -> ${operation(num)}")
        }
    }
    val numberList = listOf(1, 2, 3, 4, 5)
    calculate(numberList) { it * 2 }
}
