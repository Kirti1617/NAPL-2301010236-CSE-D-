// For more information see https://aka.ms/fsharp-console-apps

open MongoDB.Bson
open MongoDB.Driver

// Connect to MongoDB
let client = MongoClient("mongodb://localhost:27017")
let database = client.GetDatabase("CollegeDB")
let collection = database.GetCollection<BsonDocument>("Students")

let id = ObjectId.GenerateNewId()

let showData () =
    let records = collection.Find(FilterDefinition<BsonDocument>.Empty).ToList()
    printfn "\nStudent Records:"
    for student in records do
        printfn "%O" student

// CREATE
let student = BsonDocument()
student.Add("_id", id)
student.Add("Name", "Rahul")
student.Add("Age", 20)

collection.InsertOne(student)
printfn "After CREATE:"
showData()

// READ
let filter = Builders<BsonDocument>.Filter.Eq("_id", id)
let result = collection.Find(filter).FirstOrDefault()

printfn "\nAfter READ:"
printfn "%O" result

// UPDATE
let update = Builders<BsonDocument>.Update
                 .Set("Name", "Aman")
                 .Set("Age", 21)

collection.UpdateOne(filter, update)
printfn "\nAfter UPDATE:"
showData()

// DELETE
collection.DeleteOne(filter)
printfn "\nAfter DELETE:"
showData()


