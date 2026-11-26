// For more information see https://aka.ms/fsharp-console-apps

open System
type Shape() =
    abstract member Area: unit -> float
    default this.Area() = 0.0

type Circle(radius: float) =
    inherit Shape()

    override this.Area() =
        Math.PI * radius * radius

type Rectangle(length: float, breadth: float) =
    inherit Shape()

    override this.Area() =
        length * breadth

[<EntryPoint>]
let main argv =

    let c = Circle(5.0)
    let r = Rectangle(4.0, 6.0)

    
    printfn "Circle Area: %f" (c.Area())
    printfn "Rectangle Area: %f" (r.Area())

    
    let shapes: Shape list =
        [ c :> Shape; r :> Shape ]

    printfn "\nPolymorphism:"

    for shape in shapes do
        printfn "Area: %f" (shape.Area())

    0

