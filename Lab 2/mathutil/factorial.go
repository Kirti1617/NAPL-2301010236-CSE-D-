package mathutil
func Factorial(n int) int {
	if n < 0 {
		return 0
	}
	result := 1
	for i := 1; i <= n; i++ {
		result = result * i
	}

	return result
}