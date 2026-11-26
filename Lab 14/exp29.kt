fun main() {
    println("----- Read-only List -----")
    val list = listOf(10, 20, 30, 40)
    println("List: $list")
    println("Contains 20: ${list.contains(20)}")
    println("Get element at index 1: ${list.get(1)}")
    println("\n----- Mutable List -----")
    val mutableList = mutableListOf(10, 20, 30)
    println("Original List: $mutableList")
    mutableList.add(40)
    println("After adding 40: $mutableList")
    mutableList.remove(20)
    println("After removing 20: $mutableList")
    println("\n----- Read-only Set -----")
    val set = setOf(10, 20, 30, 20)
    println("Set: $set")
    println("Contains 10: ${set.contains(10)}")
    println("\n----- Mutable Set -----")
    val mutableSet = mutableSetOf(10, 20, 30)
    println("Original Set: $mutableSet")
    mutableSet.add(40)
    println("After adding 40: $mutableSet")
    mutableSet.remove(20)
    println("After removing 20: $mutableSet")
    println("\n----- Read-only Map -----")
    val map = mapOf("A" to 90, "B" to 80, "C" to 70)
    println("Map: $map")
    println("Get value of A: ${map.get("A")}")
    println("Contains B: ${map.containsKey("B")}")
    println("\n----- Mutable Map -----")
    val mutableMap = mutableMapOf("A" to 90, "B" to 80)
    println("Original Map: $mutableMap")
    mutableMap["C"] = 70
    println("After adding C: $mutableMap")
    mutableMap.remove("B")
    println("After removing B: $mutableMap")
    println("\n----- Functional Transformations -----")
    val numbers = listOf(1, 2, 3, 4, 5)
    val doubled = numbers.map { it * 2 }
    println("After map: $doubled")
    val filtered = numbers.filter { it > 2 }
    println("After filter: $filtered")
    val sum = numbers.reduce { a, b -> a + b }
    println("After reduce (sum): $sum")
    println("\n----- Sorting and Grouping -----")
    data class Student(val name: String, val percentage: Int)
    val students = listOf(
        Student("Aman", 85),
        Student("Riya", 92),
        Student("Rahul", 65),
        Student("Neha", 78),
        Student("Priya", 45)
    )
    val sortedStudents = students.sortedByDescending { it.percentage }
    println("Sorted Students:")
    sortedStudents.forEach { println(it) }
    val groupedStudents = students.groupBy {
        if (it.percentage >= 60) "Pass" else "Fail"
    }
    println("\nGrouped Students:")
    println(groupedStudents)
}
