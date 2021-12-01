fun main() {
    fun part1(input: List<String>): Int {
        var previous: Int? = null
        var isBigger = 0
        for(i in input) {
            val current = i.toInt()
            previous?.let {
                if (it < current) {
                    isBigger += 1
                }
            }
            previous = current
        }
        return isBigger
    }

    fun part2(input: List<String>): Int =
        input.map {
           it.toInt()
       }.windowed(3).map {
           it.sum()
       }.windowed(2).map {
           it.first() < it.last()
       }.count {
           it
        }



    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
