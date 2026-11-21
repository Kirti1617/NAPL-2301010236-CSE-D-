
fun main() {

    // 1. Function with Default Parameters

    fun employee(name: String = "Kirti", age: Int = 22) {
        println("Name: $name")
        println("Age: $age")
    }

    println("1. Default Parameters")

    employee()
    println("Calling with custom values:")
    employee("Rahul", 25)


    // 2. Function with Named Arguments

    println("\n2. Named Arguments")

    employee(age = 23, name = "Anushka")


    // 3. Function with Vararg

    println("\n3. Vararg Function")

    fun displayNumbers(vararg numbers: Int) {
        println("Numbers:")
        for (num in numbers) {
            println(num)
        }
    }

    displayNumbers(10, 20, 30, 40, 50)


    // 4. Higher-Order Function

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
