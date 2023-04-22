/*
Write a function that takes in a string of one or more words, and returns the same string, but with all five or more letter words reversed (Just like the name of this Kata). Strings passed in will consist of only letters and spaces. Spaces will be included only when more than one word is present.

Examples:

spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw" 
spinWords( "This is a test") => returns "This is a test" 
spinWords( "This is another test" )=> returns "This is rehtona test"
*/
package spinwords

import spinwords.spinWords

fun spinWords(sentence: String): String {

    fun invertWord(word: String): String {
        var invertedWord = "";

        for (i in word.length - 1 downTo 0 ) {
             invertedWord += word[i]
        }

        return invertedWord
    }

    var result = "";

    val wordArray = sentence.split(" ")

    for (word in wordArray) {
        if (word.length >= 5) {
            result += invertWord(word) + " "
        } else {
            result += word + " "
        }
    }

    return result.dropLast(1)
}

fun main(args: Array<String>) {
    val sentence = args.joinToString(" ")

    println(spinWords(sentence))
}