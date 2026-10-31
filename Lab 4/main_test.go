package main
import "testing"
func TestDivide(t *testing.T) {
	result, err := divide(10, 2)
	if err != nil || result != 5 {
		t.Error("Division test failed")
	}
	_, err = divide(10, 0)
	if err == nil {
		t.Error("Expected division by zero error")
	}
}
func TestSquareRoot(t *testing.T) {
	result, err := squareRoot(25)
	if err != nil || result != 5 {
		t.Error("Square root test failed")
	}
	_, err = squareRoot(-9)
	if err == nil {
		t.Error("Expected negative number error")
	}
}
func TestCheckInput(t *testing.T) {
	result, err := checkInput("Hello")
	if err != nil || result != "Hello" {
		t.Error("Valid input test failed")
	}
	_, err = checkInput("")
	if err == nil {
		t.Error("Expected empty input error")
	}
}
