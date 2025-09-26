fun main() {
    // List -> Set
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    val setOfNumbers = numbers.toSet()
    println("Numbers: $numbers")
    println("Unique numbers (Set): $setOfNumbers")

    // Set operations
    val set1 = setOf(1, 2, 3)
    val set2 = mutableSetOf(3, 4, 5)
    println("Intersection: ${set1.intersect(set2)}") // [3]
    println("Union: ${set1.union(set2)}") // [1, 2, 3, 4, 5]

    // Map (mutable)
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges["Barbara"] = 42
    peopleAges["Joe"] = 51

    // In từng phần tử
    peopleAges.forEach { println("${it.key} is ${it.value}") }

    // In tất cả trong 1 dòng
    println(
        peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ")
    )

    // Lọc tên có ít hơn 4 ký tự
    val filteredNames = peopleAges.filter { it.key.length < 4 }
    println("Filtered names: $filteredNames") // {Ann=23, Joe=51}

    // Làm việc với list từ
    val words = listOf("about", "acute", "balloon", "best", "brief", "class")
    val filteredWords = words
        .filter { it.startsWith("b", ignoreCase = true) }
        .shuffled() // xáo trộn
        .take(2)    // lấy 2 phần tử
        .sorted()   // sắp xếp lại
    println("Filtered words: $filteredWords")

    // Lambda function
    val triple: (Int) -> Int = { a: Int -> a * 3 }
    println("Triple of 5 = ${triple(5)}")

    // Làm việc với class Game
    val game = Game()
    game.initWord("kotlin") // gán từ mới
    println("Scrambled word: ${game.currentScrambledWord}")

    // Nullable + toán tử Elvis (?:)
    var quantity: Int? = null
    println("Quantity khi null: ${quantity ?: 0}") // 0
    quantity = 4
    println("Quantity khi gán 4: ${quantity ?: 0}") // 4
}

class Game {
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var wordsList: MutableList<String> = mutableListOf()
    private lateinit var currentWord: String

    fun initWord(word: String) {
        currentWord = word
        _currentScrambledWord = word.toCharArray().apply { shuffle() }.joinToString("")
        wordsList.add(word)
    }
}
