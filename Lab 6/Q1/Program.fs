// For more information see https://aka.ms/fsharp-console-apps
open System

let getDivision percentage =
    match percentage with
    | p when p >= 60.0 -> "First Division"
    | p when p >= 50.0 -> "Second Division"
    | p when p >= 40.0 -> "Third Division"
    | _ -> "Fail"

[<EntryPoint>]
let main argv =

    printf "Enter marks for Subject 1: "
    let m1 = float (Console.ReadLine())

    printf "Enter marks for Subject 2: "
    let m2 = float (Console.ReadLine())

    printf "Enter marks for Subject 3: "
    let m3 = float (Console.ReadLine())

    printf "Enter marks for Subject 4: "
    let m4 = float (Console.ReadLine())

    let total = m1 + m2 + m3 + m4
    let percentage = total / 4.0

    let division = getDivision percentage

    printfn "\nTotal Marks: %.2f" total
    printfn "Percentage: %.2f%%" percentage
    printfn "Division: %s" division

    0
