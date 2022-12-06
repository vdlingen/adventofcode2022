package day06

val input = util.readInput("day06.txt")

fun String.findDistinct(length: Int) = indices.first { index ->
    input.substring(index, minOf(index + length, this.length)).toCharArray().distinct().size == length
} + length

fun part1() = input.findDistinct(4)
fun part2() = input.findDistinct(14)

fun main() {
    println("part 1 = ${part1()}")
    println("part 2 = ${part2()}")
}
