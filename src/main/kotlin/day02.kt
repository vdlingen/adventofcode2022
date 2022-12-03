package day02

val input = util.readInput("day02.txt")
    .split("\n")
    .map { it.split(" ") }

fun String.parseMove() = when (this) {
    "A", "X" -> Move.Rock
    "B", "Y" -> Move.Paper
    "C", "Z" -> Move.Scissors
    else -> error("Failed to parse move")
}

enum class Move(val score: Int) {
    Rock(1),
    Paper(2),
    Scissors(3),
}

fun Move.beatsMove() = when (this) {
    Move.Rock -> Move.Scissors
    Move.Paper -> Move.Rock
    Move.Scissors -> Move.Paper
}

fun Move.result(other: Move) = when {
    this.beatsMove() == other -> 6
    this == other -> 3
    else -> 0
}

fun part1() = input.sumOf {
    val my = it[1].parseMove()
    val other = it[0].parseMove()

    my.result(other) + my.score
}
fun part2() = input.sumOf {
    val other = it[0].parseMove()
    val my = when (it[1]) {
        "X" -> other.beatsMove()
        "Y" -> other
        "Z" -> other.beatsMove().beatsMove()
        else -> error("Failed to parse expected result")
    }

    my.result(other) + my.score
}

fun main() {
    println("part 1 = ${part1()}")
    println("part 2 = ${part2()}")
}
