class Student(
    private val rollNo: Int,
    private var name: String,
    private var course: String,
    private var percentage: Double
) {
    fun updateDetails() {
        println("\nEnter details for Roll No: $rollNo")
        print("Enter Name: ")
        name = readLine()!!
        print("Enter Course: ")
        course = readLine()!!
        print("Enter Percentage: ")
        percentage = readLine()!!.toDouble()
    }
    fun displayDetails() {
        println("\n----- Student Details -----")
        println("Roll Number : $rollNo")
        println("Name        : $name")
        println("Course      : $course")
        println("Percentage  : $percentage%")
        println("---------------------------")
    }
}
fun main() {

    val student1 = Student(101, "Kirti", "CSE", 85.5)

    // Creating second Student object
    val student2 = Student(102, "Rahul", "IT", 90.0)

    println("STUDENT 1")
    student1.updateDetails()
    student1.displayDetails()
    println("\nSTUDENT 2")
    student2.updateDetails()
    student2.displayDetails()
}
