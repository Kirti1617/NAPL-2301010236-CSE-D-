package main
import (
	"fmt"
	"math"
)
func divide(a, b float64) (float64, error) {
	if b == 0 {
		return 0, fmt.Errorf("division by zero is not allowed")
	}
	return a / b, nil
}
func squareRoot(n float64) (float64, error) {
	if n < 0 {
		return 0, fmt.Errorf("negative number is not allowed")
	}
	return math.Sqrt(n), nil
}
func checkInput(s string) (string, error) {
	if s == "" {
		return "", fmt.Errorf("input cannot be empty")
	}
	return s, nil
}
func main() {
	fmt.Println("ERROR HANDLING")
	result, err := divide(10, 2)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Division:", result)
	}
	result, err = divide(10, 0)
	if err != nil {
		fmt.Println("Error:", err)
	}
	result, err = squareRoot(25)
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Square Root:", result)
	}
	result, err = squareRoot(-9)
	if err != nil {
		fmt.Println("Error:", err)
	}
	input, err := checkInput("")
	if err != nil {
		fmt.Println("Error:", err)
	} else {
		fmt.Println("Input:", input)
	}
}
