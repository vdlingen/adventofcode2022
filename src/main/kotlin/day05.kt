package day05

val input = util.readInput("day05.txt")
    .split("\n\n")
    .let { (stacks, instructions) ->
        Pair(
            parseStacks(stacks),
            parseInstructions(instructions)
        )
    }

data class Instruction(val amount: Int, val from: Int, val to: Int)

fun parseStacks(input: String): List<List<Char>> {
    val lines = input.split("\n")

    val indices = lines.last().split("\\s+".toRegex()).mapNotNull { it.takeIf { it.isNotBlank() }?.toInt() }
    println(indices)

    return indices.map { index ->
        lines.take(lines.size - 1)
            .mapNotNull { line ->
                (1 + (index - 1) * 4).takeIf { it < line.length }?.let { line[it] }?.takeIf { it.isUpperCase() }
            }
    }
}

fun parseInstructions(input: String) = input
    .split("\n")
    .mapNotNull { instruction ->
        "move (\\d+) from (\\d+) to (\\d+)"
            .toRegex()
            .matchEntire(instruction)
            ?.let { Instruction(it.groupValues[1].toInt(), it.groupValues[2].toInt(), it.groupValues[3].toInt()) }
    }

fun Instruction.run(stacks: List<List<Char>>) = stacks.mapIndexed { index, stack ->
    when (index + 1) {
        from -> stack.takeLast(stack.size - amount)
        to -> stacks[from - 1].take(amount).reversed() + stack
        else -> stack
    }
}

fun Instruction.run2(stacks: List<List<Char>>) = stacks.mapIndexed { index, stack ->
    when (index + 1) {
        from -> stack.takeLast(stack.size - amount)
        to -> stacks[from - 1].take(amount) + stack
        else -> stack
    }
}

fun part1() = input.second
    .fold(input.first) { stacks, instruction -> instruction.run(stacks) }
    .map { it.first() }
    .joinToString("")

fun part2() = input.second
    .fold(input.first) { stacks, instruction -> instruction.run2(stacks) }
    .map { it.first() }
    .joinToString("")

fun main() {
    println("part 1 = ${part1()}")
    println("part 2 = ${part2()}")
}
