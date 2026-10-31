package main
import "fmt"
func main() {
    var a, b int
    var x, y float64
    var n int
    var err error
    for {
        fmt.Println("Enter two integers:")
        n, err = fmt.Scan(&a, &b)
        if err == nil && n == 2 && a >= -1000 && a <= 1000 && b >= -1000 && b <= 1000 {
            break
        } else {
            fmt.Println("Invalid input! Try again.")
        }
    }
    fmt.Println("Integer Addition:", a+b)
    fmt.Println("Integer Subtraction:", a-b)
    fmt.Println("Integer Multiplication:", a*b)
    for {
        fmt.Println("\nEnter two decimal numbers:")
        n, err = fmt.Scan(&x, &y)
        if err == nil && n == 2 && x >= -1000 && x <= 1000 && y >= -1000 && y <= 1000 {
            break
        } else {
            fmt.Println("Invalid input! Try again.")
        }
    }
    fmt.Println("Float Addition:", x+y)
    fmt.Println("Float Subtraction:", x-y)
    fmt.Println("Float Multiplication:", x*y)

}
