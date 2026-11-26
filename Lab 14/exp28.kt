fun main() {
    var name: String = "Kirti"
    var city: String? = null
    println("Non-nullable name: $name")
    println("Nullable city: $city")
    city = "Delhi"
    var address: String? = null
    println("Address length: ${address?.length}")
    address = "Delhi"
    println("Address length: ${address?.length}")
    var username: String? = null
    var result = username ?: "Guest"
    println("Username: $result")
    var message: String? = null
    try {
        println(message!!.length)
    } catch (e: NullPointerException) {
        println("NullPointerException caught!")
    }
}
