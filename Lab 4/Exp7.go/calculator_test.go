package main

import (
	"testing"
)

// Test 1: Division
func TestDivide(t *testing.T) {

	result, err := divide(10, 2)

	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}

	if result != 5 {
		t.Errorf("Expected 5, got %v", result)
	}

	// Test division by zero
	_, err = divide(10, 0)

	if err == nil {
		t.Error("Expected division by zero error")
	}
}

// Test 2: Square Root
func TestSquareRoot(t *testing.T) {

	result, err := squareRoot(25)

	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}

	if result != 5 {
		t.Errorf("Expected 5, got %v", result)
	}

	// Test negative number
	_, err = squareRoot(-25)

	if err == nil {
		t.Error("Expected negative number error")
	}
}

// Test 3: Input Validation
func TestParseNumber(t *testing.T) {

	result, err := parseNumber("123")

	if err != nil {
		t.Errorf("Unexpected error: %v", err)
	}

	if result != 123 {
		t.Errorf("Expected 123, got %v", result)
	}

	// Test empty input
	_, err = parseNumber("")

	if err == nil {
		t.Error("Expected empty input error")
	}

	// Test non-numeric input
	_, err = parseNumber("hello")

	if err == nil {
		t.Error("Expected invalid input error")
	}
}