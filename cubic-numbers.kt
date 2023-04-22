// testing("Once upon a midnight dreary, while100 I pondered, 9026315weak and weary -827&()", "Unlucky")
// testing("Once 1000upon a midnight 110dreary, while100 I pondered, 9026315weak and weary -827&()", "0 0 Lucky")

fun isSumOfCubes(s: String): String {

    fun get3DigitNumbers(s: String): List<Int> {
        val numbers = Regex("\\d+").findAll(s).map { it.value }.toList()
        var max3DigitNumbers = mutableListOf<Int>()

        for (number in numbers) {
            var numberAsString = number.toString()

            while (numberAsString.length > 3) {
                max3DigitNumbers.add(numberAsString.substring(0, 3).toInt())
                numberAsString = numberAsString.substring(3)
            }

            max3DigitNumbers.add(numberAsString.toInt())
        }

        return max3DigitNumbers
    }

    fun checkCubic(num: Int): Boolean {
        val numAsString = num.toString()
        var sum = 0
        
        for (i in numAsString) {
            sum += Math.pow(i.toString().toDouble(), 3.0).toInt()
        }

        return num == sum
    }
    
    val max3DigitNumbers = get3DigitNumbers(s)
    var sumOfCubics = 0 
    var listOfCubics = ""
    var returnString = ""

    for (i in max3DigitNumbers) {
        if (checkCubic(i)) {
            sumOfCubics += i
            listOfCubics += i.toString() + " "
        }
    }
    
    if (listOfCubics.length > 0) {
        returnString += listOfCubics
        returnString += sumOfCubics.toString() + " Lucky"
    } else {
        returnString += "Unlucky"
    }

    return returnString

}

fun main(args: Array<String>) {
    val s = args.joinToString(" ")

    println(isSumOfCubes(s))
}
