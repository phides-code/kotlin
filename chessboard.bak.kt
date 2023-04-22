import java.math.BigInteger

fun game(n: Long): String {
    val bigN = BigInteger.valueOf(n)

    fun greatestCommonDivisor(a: BigInteger, b: BigInteger): BigInteger {
        if (b == BigInteger.valueOf(0)) return a
        return greatestCommonDivisor(b, a % b)
    }

    fun simplifyFraction(numerator: BigInteger, denominator: BigInteger): Pair<BigInteger, BigInteger> {
        val gcd = greatestCommonDivisor(numerator, denominator)
        return Pair(numerator / gcd, denominator / gcd)
    }
    
    var sumNumerator: BigInteger = BigInteger.valueOf(0)
    var sumDenominator: BigInteger = BigInteger.valueOf(1)

    var i = BigInteger.valueOf(1)
    while (i <= bigN) {

        var numerator = BigInteger.valueOf(1)
        while (numerator <= bigN) {

            val denominator = i + numerator
        
            sumNumerator = (sumNumerator * denominator) + (numerator * sumDenominator) 
            sumDenominator *= denominator

            val simplifiedFraction = simplifyFraction(sumNumerator, sumDenominator)
            sumNumerator = simplifiedFraction.first
            sumDenominator = simplifiedFraction.second

            numerator++
        }

        i++
    }

    var result = "[$sumNumerator"

    if (sumDenominator != BigInteger.valueOf(1)) {
        result += ", $sumDenominator"
    }

    result += "]"

    return result
}

fun main(args: Array<String>) { 
    println(game(args[0].toLong()))
}

// 1/2, 2/3, 3/4, 4/5, 5/6, 6/7, 7/8, 8/9

// On row 2 (2nd row from the bottom) we have:

// 1/3, 2/4, 3/5, 4/6, 5/7, 6/8, 7/9, 8/10

// On row 3:

// 1/4, 2/5, 3/6, 4/7, 5/8, 6/9, 7/10, 8/11

// until last row:

// 1/9, 2/10, 3/11, 4/12, 5/13, 6/14, 7/15, 8/16

