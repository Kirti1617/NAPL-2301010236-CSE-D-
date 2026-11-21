fun main() {

    // 1. Hello World

    println("Hello Kotlin!!!")


    // 2. Employee Bonus Calculation

    val deptCode = "IT"
    val yearsOfExperience = 6
    val salary = 50000.0

    val bonusPercentage = when (deptCode) {
        "IT" -> if (yearsOfExperience > 5) 20 else 10
        "HR" -> if (yearsOfExperience > 3) 15 else 10
        else -> 10
    }

    val bonusAmount = salary * bonusPercentage / 100

    println("\nEmployee Bonus Details")
    println("Department: $deptCode")
    println("Years of Experience: $yearsOfExperience")
    println("Salary: $salary")
    println("Bonus Percentage: $bonusPercentage%")
    println("Bonus Amount: $bonusAmount")


    // 3. Average of Individual Digits

    print("\nEnter an integer: ")
    val number = readLine()!!.toInt()

    var temp = kotlin.math.abs(number.toLong())
    var sum = 0
    var count = 0

    if (temp == 0L) {
        count = 1
    }

    while (temp > 0) {
        val digit = (temp % 10).toInt()
        sum += digit
        count++
        temp /= 10
    }

    val average = sum.toDouble() / count

    println("Sum of digits: $sum")
    println("Number of digits: $count")
    println("Average of digits: $average")
}
