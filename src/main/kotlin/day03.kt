package day03

val input = util.readInput("day03.txt")
    .split("\n")

fun String.compartments() = listOf(
    substring(0, length / 2),
    substring(length / 2, length)
)

val Char.priority
    get() = when {
        isLowerCase() -> this - 'a' + 1
        else -> this - 'A' + 27
    }

fun String.shared(): Char {
    val (a, b) = compartments()

    return a.first { it in b }
}

fun List<String>.shared() = first().first { item -> all { item in it } }

fun part1() = input.sumOf { it.shared().priority }

fun part2() = input.chunked(3).sumOf {
    it.shared().priority
}

fun main() {
    println("part 1 = ${part1()}")
    println("part 2 = ${part2()}")
}
