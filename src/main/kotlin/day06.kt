package day06

val input = util.readInput("day06.txt")

fun String.findDistinct(length: Int) = indices.first {
    it >= length && input.substring(it - length, it).toCharArray().distinct().size == length
}

fun part1() = input.findDistinct(4)
fun part2() = input.findDistinct(14)

fun main() {
    println("part 1 = ${part1()}")
    println("part 2 = ${part2()}")
}
