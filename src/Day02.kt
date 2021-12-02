

fun main() {
    fun part1(input: List<String>): Int {
        val (position, depth) = input.map {
            val direction = it.split(" ").first()
            val steps = it.split(" ").last().toInt()
            Pair(direction, steps)
        }.fold(Pair(0, 0)) { acc, value ->
            when (value.first) {
                "forward" -> acc.copy(first = acc.first + value.second)
                "up" -> acc.copy(second = acc.second - value.second)
                "down" -> acc.copy(second = acc.second + value.second)
                else -> acc
            }
        }
        return position * depth
    }

    fun part2(input: List<String>): Int {
        val (position, depth) = input.map {
            val direction = it.split(" ").first()
            val steps = it.split(" ").last().toInt()
            Pair(direction, steps)
        }.fold(Triple(0, 0, 0)) { acc, value ->
            when (value.first) {
                "forward" -> acc.copy(first = acc.first + value.second, second = acc.second + acc.third * value.second)
                "up" -> acc.copy(third = acc.third - value.second)
                "down" -> acc.copy(third = acc.third + value.second)
                else -> acc
            }
        }
        return position * depth
    }



    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
