package main
import "fmt"
func sliceOperations() {
	fmt.Println(" SLICE OPERATIONS ")
	students := []string{"Aman", "Riya", "Rahul"}
	fmt.Println("Initial Slice:", students)
	students = append(students, "Neha")
	fmt.Println("After Add:", students)
	index := 1
	students = append(students[:index], students[index+1:]...)
	fmt.Println("After Remove (index 1):", students)
	students[1] = "Priya"
	fmt.Println("After Update (index 1):", students)

}
func mapOperations() {
	fmt.Println(" MAP OPERATIONS ")
	marks := map[string]int{
		"Maths":    85,
		"English":  78,
		"Computer": 92,
	}
	fmt.Println("Initial Map:", marks)
	marks["Science"] = 88
	fmt.Println("After Insert:", marks)
	delete(marks, "English")
	fmt.Println("After Delete (English):", marks)
	value, exists := marks["Computer"]
	if exists {
		fmt.Println("Lookup Computer:", value)
	} else {
		fmt.Println("Computer not found")
	}

	fmt.Println("Final Map:", marks)
}