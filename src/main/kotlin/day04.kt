package day04

val input = util.readInput("day04.txt")
    .split("\n")
    .map {
        it.split(",").map {
            val range = it.split("-").map { it.toInt()}
            range.first() .. range.last()
        }
    }

fun part1() = input.count { (first, second) -> first.all { second.contains(it)} || second.all { first.contains(it) } }
fun part2() = input.count { (first, second) -> first.any { second.contains(it)} }

fun main() {
    println("part 1 = ${part1()}")
    println("part 2 = ${part2()}")
}
