
open Microsoft.Data.Sqlite

let connection = new SqliteConnection("Data Source=students.db")
connection.Open()

let execute sql =
    use cmd = connection.CreateCommand()
    cmd.CommandText <- sql
    cmd.ExecuteNonQuery() |> ignore

let showData () =
    use cmd = connection.CreateCommand()
    cmd.CommandText <- "SELECT * FROM Students"
    use reader = cmd.ExecuteReader()

    printfn "\nStudent Records:"
    while reader.Read() do
        printfn "ID: %d Name: %s Age: %d"
            (reader.GetInt32(0))
            (reader.GetString(1))
            (reader.GetInt32(2))

// Create table
execute "CREATE TABLE IF NOT EXISTS Students (Id INTEGER PRIMARY KEY, Name TEXT, Age INTEGER)"

// Remove old test record
execute "DELETE FROM Students WHERE Id = 1"

// CREATE
execute "INSERT INTO Students VALUES (1, 'Rahul', 20)"
printfn "After CREATE:"
showData()

// READ
printfn "\nAfter READ:"
showData()

// UPDATE
execute "UPDATE Students SET Name = 'Aman', Age = 21 WHERE Id = 1"
printfn "\nAfter UPDATE:"
showData()

// DELETE
execute "DELETE FROM Students WHERE Id = 1"
printfn "\nAfter DELETE:"
showData()

connection.Close()
