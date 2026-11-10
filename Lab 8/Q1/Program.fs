// For more information see https://aka.ms/fsharp-console-apps

open System

// Base Class
type Shape() =
    abstract member Area: unit -> float
    default this.Area() = 0.0

// Derived Class 1
type Circle(radius: float) =
    inherit Shape()

    override this.Area() =
        Math.PI * radius * radius

// Derived Class 2
type Rectangle(length: float, breadth: float) =
    inherit Shape()

    override this.Area() =
        length * breadth

// Main Program
[<EntryPoint>]
let main argv =

    // Creating objects
    let c = Circle(5.0)
    let r = Rectangle(4.0, 6.0)

    // Calling methods
    printfn "Circle Area: %f" (c.Area())
    printfn "Rectangle Area: %f" (r.Area())

    // Polymorphism
    let shapes: Shape list =
        [ c :> Shape; r :> Shape ]

    printfn "\nPolymorphism:"

    for shape in shapes do
        printfn "Area: %f" (shape.Area())

    0

