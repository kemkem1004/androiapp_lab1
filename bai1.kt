fun main() {
    println("Hello, world!")
    println("This is the text to print!")

    // Assign once, cannot change.
    val age = 5
    val name = "Rover"

    // Assign and change as needed.
    var roll = 6
    var rolledValue: Int = 4

    println("You are already $age!")
    println("You are already $age days old, $name!")

    // Define the function.
    fun printHello() {
        println("Hello Kotlin")
    }

    fun printBorder(border: String, timesToRepeat: Int) {
        repeat(timesToRepeat) {
            print(border)
        }
        println()
    }

    fun roll(): Int {
        return (1..6).random()
    }

    fun printDefaultBorder() {
        repeat(23) {
            print("=")
        }
        println()
    }

    fun printCakeBottom(age: Int, layers: Int) {
        repeat(layers) {
            repeat(age + 2) {
                print("@")
            }
            println()
        }
    }

    // Ví dụ if else
    val num = 4
    if (num > 4) {
        println("The variable is greater than 4")
    } else if (num == 4) {
        println("The variable is equal to 4")
    } else {
        println("The variable is less than 4")
    }

    // Trò chơi xúc xắc
    val rollResult = roll()
    val luckyNumber = 4

    when (rollResult) {
        luckyNumber -> println("You won! You rolled the lucky number $luckyNumber!")
        1 -> println("So sorry! You rolled a 1. Try again!")
        2 -> println("Sadly, you rolled a 2. Try again!")
        3 -> println("Unfortunately, you rolled a 3. Try again!")
        4 -> println("No luck! You rolled a 4. Try again!")
        5 -> println("Don't cry! You rolled a 5. Try again!")
        6 -> println("Apologies! you rolled a 6. Try again!")
    }

    // Hiển thị xúc xắc bằng text/emoji
    val diceRoll = roll()
    val diceFace = when (diceRoll) {
        1 -> "🎲 [1]"
        2 -> "🎲 [2]"
        3 -> "🎲 [3]"
        4 -> "🎲 [4]"
        5 -> "🎲 [5]"
        else -> "🎲 [6]"
    }
    println("Dice face: $diceFace")

    // Class Dice (1 phiên bản duy nhất)
    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    val myFirstDice = Dice(6)
    println("My first dice rolled: ${myFirstDice.roll()}")

    // Call the functions.
    printHello()
    printBorder("*", 10)
    printDefaultBorder()
    println("You rolled: ${roll()}")
    printCakeBottom(age, 3)
}
