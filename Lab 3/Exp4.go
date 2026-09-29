package main
import "fmt"
import "os"
import "bufio"
type Person struct {
	Name   string
	Age    int
	Job    string
	Salary float64
}
func (p Person) Read() Person {
	reader:= bufio.NewReader(os.Stdin)
	fmt.Print("Enter Name: ")
	fmt.Scan(&p.Name)
	reader.ReadLine()
	fmt.Print("Enter Age: ")
	fmt.Scan(&p.Age)
	reader.ReadLine()
	fmt.Print("Enter Job: ")
	fmt.Scan(&p.Job)
	reader.ReadLine()
	fmt.Print("Enter Salary: ")
	fmt.Scan(&p.Salary)
	reader.ReadLine()
	return p
}
func(p Person) Display(){
	fmt.Println("Name of the person is:",p.Name)
	fmt.Println("Age of the person is:",p.Age)
	fmt.Println("Job of the person is:",p.Job)
	fmt.Println("Salary of the person is:",p.Salary)
}
func main(){
	

	var p1 Person
	var p2 Person
	fmt.Println("Enter details for Person 1:")
	p1 = p1.Read()
	p1.Display()
	fmt.Println("Enter details for person 2:")
	p2 = p2.Read()
	p2.Display()
}