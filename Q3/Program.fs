// For more information see https://aka.ms/fsharp-console-apps
open System
open System.Text.RegularExpressions

// Step 1: Reverse and palindrome

let reverseString (s: string) =
    s |> Seq.rev |> String.Concat

let isPalindrome (s: string) =
    s = reverseString s

printfn "PALINDROME CHECK"

["madam"; "hello"; "level"]
|> List.iter (fun s ->
    printfn "%s -> %s -> %b"
        s (reverseString s) (isPalindrome s)
)

// Step 2: Transform string

let transformString (s: string) =
    if s |> Seq.forall Char.IsLetter then
        s.ToUpper()
    elif s |> Seq.forall Char.IsDigit then
        s + s
    else
        s

printfn "\nSTRING TRANSFORMATION"

["hello"; "1234"; "abc123"]
|> List.iter (fun s ->
    printfn "%s -> %s" s (transformString s)
)

// Step 3: Email validation

let isValidEmail (email: string) =
    Regex.IsMatch(email, @"^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$")

printfn "\nEMAIL VALIDATION"

["abc@gmail.com"; "test@yahoo.in"; "invalidemail"]
|> List.iter (fun e ->
    printfn "%s -> %b" e (isValidEmail e)
)