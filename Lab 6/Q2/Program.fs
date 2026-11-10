// For more information see https://aka.ms/fsharp-console-apps
let rec isPrime n divisor =
    if n <= 1 then
        false
    elif divisor * divisor > n then
        true
    elif n % divisor = 0 then
        false
    else
        isPrime n (divisor + 1)

printfn "Enter a number:"
let n = int (System.Console.ReadLine())

if isPrime n 2 then
    printfn "%d is Prime" n
else
    printfn "%d is Not Prime" n