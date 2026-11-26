open System

let task1 =
    async {
        printfn "Task 1 started"
        do! Async.Sleep(3000)
        printfn "Task 1 completed"
        return "Result 1"
    }

let task2 =
    async {
        printfn "Task 2 started"
        do! Async.Sleep(1000)
        printfn "Task 2 completed"
        return "Result 2"
    }

let task3 =
    async {
        printfn "Task 3 started"
        do! Async.Sleep(2000)
        printfn "Task 3 completed"
        return "Result 3"
    }

let tasks = [| task1; task2; task3 |]

printfn "Starting parallel execution..."

let results = Async.Parallel tasks |> Async.RunSynchronously

printfn "\nAll tasks completed!"
for result in results do
    printfn "%s" result
