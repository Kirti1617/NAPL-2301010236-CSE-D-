data class Student(
    val id: Int,
    val name: String,
    val email: String?
)
data class Course(
    val courseName: String,
    val instructor: String?,
    val capacity: Int
)
data class Registration(
    val student: Student,
    val course: Course,
    val marks: Int
)
fun Student.studentInfo(): String {
    return "ID: $id, Name: $name, Email: ${email ?: "Not Available"}"
}
fun Course.courseInfo(): String {
    return "Course: $courseName, Instructor: ${instructor ?: "Not Assigned"}"
}
fun Course.availableSeats(enrolled: Int): Int {
    return capacity - enrolled
}
class ReportBuilder {
    var title: String = ""
    var content: String = ""

    fun build(): String {
        return """
            ===== $title =====
            $content
        """.trimIndent()
    }
}
fun report(block: ReportBuilder.() -> Unit): String {
    val builder = ReportBuilder()
    builder.block()
    return builder.build()
}
fun main() {
    val s1 = Student(1, "Aman", "aman@gmail.com")
    val s2 = Student(2, "Riya", null)
    val s3 = Student(3, "Rahul", "rahul@gmail.com")
    val s4 = Student(4, "Neha", "neha@gmail.com")
    val c1 = Course("Kotlin", "Mr. Sharma", 3)
    val c2 = Course("Java", null, 2)
    val registrations = listOf(
        Registration(s1, c1, 85),
        Registration(s2, c1, 90),
        Registration(s3, c1, 75),
        Registration(s4, c2, 88)
    )
    println("===== STUDENT INFORMATION =====")
    val studentNames = registrations.map { it.student.name }
    println("Student Names: $studentNames")
    val passedStudents = registrations.filter { it.marks >= 80 }
    println("Students with marks >= 80:")
    passedStudents.forEach {
        println(it.student.name)
    }
    val totalMarks = registrations.map { it.marks }.reduce { a, b -> a + b }
    println("Total Marks: $totalMarks")
    val groupedCourses = registrations.groupBy { it.course.courseName }
    println("Students grouped by course:")
    groupedCourses.forEach { (course, students) ->
        println("$course: ${students.map { it.student.name }}")
    }
    println("\n===== EXTENSION FUNCTIONS =====")
    println(s1.studentInfo())
    println(c1.courseInfo())
    val enrolledInKotlin = registrations.count { it.course == c1 }
    println("Available seats in Kotlin: ${c1.availableSeats(enrolledInKotlin)}")
    println("\n===== DSL REPORT =====")
    val output = report {
        title = "Course Registration Report"
        content = """
            Total Students: ${registrations.size}
            Average Marks: ${registrations.map { it.marks }.average()}
            Passed Students: ${registrations.count { it.marks >= 80 }}
            Courses: ${registrations.map { it.course.courseName }.distinct()}
        """.trimIndent()
    }
    println(output)
}