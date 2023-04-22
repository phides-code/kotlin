fun meeting(s: String): String {
    // val names = s.uppercase().replace(":", ",").split(";")

    // val invertedNames = names.map {
    //     "(" + it.substringAfter(',') + ", " + it.substringBefore(',') + ")"
    // }

    // return invertedNames.sorted().joinToString(separator = "")

    return s.uppercase().replace(":", ",").split(";").map {
        "(" + it.substringAfter(',') + ", " + it.substringBefore(',') + ")"
    }.sorted().joinToString(separator = "")

}

fun main() {
    println(meeting(
        "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill"
    ))
}
