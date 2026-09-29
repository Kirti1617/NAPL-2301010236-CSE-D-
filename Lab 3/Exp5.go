package main
import "fmt"
func modifyValue(x *int) {
	*x = *x + 10
}
type Student struct {
	Name string
	Age  int
	Marks float64
}
func main() {
	num := 20
	fmt.Println("Value of num:", num)
	fmt.Println("Address of num:", &num)
	ptr := &num
	fmt.Println("Value using pointer:", *ptr)
	*ptr = 30
	fmt.Println("Value after modification:", num)
	value := 50
	fmt.Println("\nBefore function call:", value)
	modifyValue(&value)
	fmt.Println("After function call:", value)
	s := new(Student)
	s.Name = "Kirti"
	s.Age = 22
	s.Marks = 85.5
	fmt.Println("\nStruct details:")
	fmt.Println("Name:", s.Name)
	fmt.Println("Age:", s.Age)
	fmt.Println("Marks:", s.Marks)
	s.Age = 23
	fmt.Println("Age after modification:", s.Age)
	s.Marks = 90.0
	fmt.Println("Marks after modification:", s.Marks)
}