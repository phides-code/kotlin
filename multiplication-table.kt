// Your task, is to create N×N multiplication table, of size provided in parameter.

// For example, when given size is 3:

// 1 2 3
// 2 4 6
// 3 6 9
// For the given example, the return value should be:

// [[1,2,3],[2,4,6],[3,6,9]]

fun multiplicationTable(size: Int): Array<IntArray> {

    var outerArray = emptyArray<IntArray>()

    var i = 1
    while (i <= size) {

        var innerArray = IntArray(0)

        var j = 1
        while (j <= size) {
            innerArray += (i*j)
            j++
        }

        outerArray += innerArray
        i++
    }

    return outerArray;
}

fun main(args: Array<String>) {

    if (args.size == 0 || args[0].toIntOrNull() == null || args[0].toInt() <= 0) {
        println("Please provide a positive integer argument")
        return
    }

    val tableSize = args[0].toInt()

    val result = multiplicationTable(tableSize);

    for (element in result) {
        println(element.contentToString())
    }

}
