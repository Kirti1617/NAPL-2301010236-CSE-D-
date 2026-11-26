
let list1 = [1; 2; 3; 4; 5]
let list2 = [6; 7; 8; 9; 10]

let square1 = List.map (fun x -> x * x) list1
let square2 = List.map (fun x -> x * x) list2

printfn "Map - Square of List 1: %A" square1
printfn "Map - Square of List 2: %A" square2

let even1 = List.filter (fun x -> x % 2 = 0) list1
let even2 = List.filter (fun x -> x % 2 = 0) list2

printfn "\nFilter - Even numbers in List 1: %A" even1
printfn "Filter - Even numbers in List 2: %A" even2

let sum1 = List.fold (fun acc x -> acc + x) 0 list1
let sum2 = List.fold (fun acc x -> acc + x) 0 list2

printfn "\nFold - Sum of List 1: %d" sum1
printfn "Fold - Sum of List 2: %d" sum2
