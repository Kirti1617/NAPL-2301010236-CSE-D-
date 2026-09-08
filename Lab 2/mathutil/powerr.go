package mathutil

func Power(base, exponent int) int {
	result := 1

	for i := 1; i <= exponent; i++ {
		result = result * base
	}

	return result
}