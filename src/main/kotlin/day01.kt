package day01

val input = util.readInput("day01.txt")
    .split("\n\n")
    .map { it.split("\n").map { it.toInt()} }

fun part1() = input.map { it.sum() }.maxOrNull()
fun part2() = input.map { it.sum() }.sortedDescending().subList(0, 3).sum()

fun main() {
    println("part 1 = ${part1()}")
    println("part 2 = ${part2()}")
}
