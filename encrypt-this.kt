// class EncryptThisTests {
//     @Test
//     fun testSample() {
//         // Example Test Cases
//         assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka", encryptThis("A wise old owl lived in an oak"))
//         assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp", encryptThis("The more he saw the less he spoke"))
//         assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare", encryptThis("The less he spoke the more he heard"))
//         assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri", encryptThis("Why can we not all be like that wise old bird"))
//         assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple", encryptThis("Thank you Piotr for all your help"))
//     }

// }

fun encryptThis(text:String): String{
    val wordArray = text.split(" ")
    var result = ""

    for (word in wordArray) {
        var i = 0
        for (letter in word) {
            if (i == 0) {
                result += letter.code.toString()
            } else if (i == 1) {
                result += word[word.length - 1]
            } else if (i == word.length - 1) {
                result += word[1]
            } else {
                result += letter
            }

            i++
        }
        result += " "
    }

    return result.dropLast(1)
}

fun main(args: Array<String>) { 
    println(encryptThis(args.joinToString(" ")))
}