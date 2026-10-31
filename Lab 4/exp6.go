package main
import "fmt"
func square(ch chan string) {
	fmt.Println("Square Goroutine Started")
	result := 5 * 5
	ch <- fmt.Sprintf("Square of 5 = %d", result)
	fmt.Println("Square Goroutine Completed")
}
func cube(ch chan string) {
	fmt.Println("Cube Goroutine Started")
	result := 3 * 3 * 3
	ch <- fmt.Sprintf("Cube of 3 = %d", result)
	fmt.Println("Cube Goroutine Completed")
}
func fibonacci(ch chan string) {
	fmt.Println("Fibonacci Goroutine Started")
	a, b := 0, 1
	result := ""
	for i := 0; i < 7; i++ {
		result += fmt.Sprintf("%d ", a)
		a, b = b, a+b
	}
	ch <- "Fibonacci Series = " + result
	fmt.Println("Fibonacci Goroutine Completed")
}
func main() {
	ch := make(chan string, 3)
	go square(ch)
	go cube(ch)
	go fibonacci(ch)
	fmt.Println("\nResults:")
	for i := 0; i < 3; i++ {
		fmt.Println(<-ch)
	}
	fmt.Println("All tasks completed!")
}
