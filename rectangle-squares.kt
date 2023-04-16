fun sqInRect(lng: Int, wdth: Int): List<Int>? {
    if (lng == wdth) {
        return null
    }

    val listOfSquares = mutableListOf<Int>()

    var bigSide = if (lng > wdth) lng else wdth
    var smallSide = if (lng < wdth) lng else wdth

    while (smallSide > 0) {
        listOfSquares.add(smallSide)
        val remainingSide = bigSide - smallSide
        bigSide = if (smallSide > remainingSide) smallSide else remainingSide
        smallSide = if (smallSide <= remainingSide) smallSide else remainingSide
    }

    return listOfSquares
}

fun main(args: Array<String>) {
    val lng = args[0].toInt();
    val wdth = args[1].toInt();

    val result = sqInRect(lng, wdth)
    if (result != null) {
        println(result)
    } else {
        println("The rectangle is already a square.")
    }
}
