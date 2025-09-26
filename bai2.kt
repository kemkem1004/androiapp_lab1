package com.example.affirmations.model

import kotlin.math.PI
import kotlin.math.pow

// Lop truu tuong nha o
abstract class Dwelling(val residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int
    abstract fun floorArea(): Double

    fun hasRoom(): Boolean {
        return residents < capacity
    }
}

// Nha hinh vuong
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "go"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }
}

// Nha tron
open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "rom"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius.pow(2.0)
    }
}

// Mo rong nha tron nhieu tang
class RoundTower(residents: Int, radius: Double, val floors: Int) : RoundHut(residents, radius) {
    override val buildingMaterial = "da"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}

// Ham them topping (vararg)
fun addToppings(vararg toppings: String) {
    println("Them cac topping: ${toppings.joinToString(", ")}")
}

fun main() {
    // Tao cac doi tuong nha
    val squareCabin = SquareCabin(3, 10.0)
    val roundHut = RoundHut(2, 7.0)
    val roundTower = RoundTower(4, 5.0, 3)

    with(squareCabin) {
        println("=== Square Cabin ===")
        println("Chat lieu: $buildingMaterial")
        println("Dien tich: ${floorArea()}")
        println("Suc chua: $capacity")
        println("Con cho khong? ${hasRoom()}")
    }

    with(roundHut) {
        println("\n=== Round Hut ===")
        println("Chat lieu: $buildingMaterial")
        println("Dien tich: ${floorArea()}")
        println("Suc chua: $capacity")
        println("Con cho khong? ${hasRoom()}")
    }

    with(roundTower) {
        println("\n=== Round Tower ===")
        println("Chat lieu: $buildingMaterial")
        println("Dien tich: ${floorArea()}")
        println("Suc chua: $capacity")
        println("Con cho khong? ${hasRoom()}")
    }

    // Lam viec voi list
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println("\nSo phan tu: ${numbers.size}")
    println("Phan tu dau tien: ${numbers[0]}")
    println("Mau dao nguoc: ${listOf("do", "xanh", "luc").reversed()}")

    // MutableList
    val entrees = mutableListOf<String>()
    entrees.add("lasagna")
    entrees.add("spaghetti")
    entrees.remove("lasagna")
    println("Danh sach mon an: $entrees")

    // Vong lap for
    for (element in numbers) {
        println("Gia tri: $element")
    }

    // Vong lap while
    var index = 0
    while (index < numbers.size) {
        println("Index $index: ${numbers[index]}")
        index++
    }

    // Chuoi
    val name = "Android"
    println("Do dai ten: ${name.length}")

    val number = 10
    val groups = 5
    println("${number * groups} nguoi")

    // Phep gan toan tu
    var a = 10
    var b = 2
    a += b
    a -= b
    a *= b
    a /= b
    println("Gia tri cuoi cua a: $a")

    // Goi ham toppings
    addToppings("pho mai", "tom", "nam")
}
