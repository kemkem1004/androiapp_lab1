import kotlinx.coroutines.*

suspend fun layGiaTri(): Double {
    // mo phong cong viec nang
    delay(500) // gia lap xu ly lau
    return Math.random() * 100
}

suspend fun xuLyGiaTri() {
    val value = layGiaTri()
    println("Gia tri sau khi xu ly = ${"%.2f".format(value * 2)}")
}

fun main() = runBlocking {
    println("=== Vi du GlobalScope.launch ===")
    val job1 = GlobalScope.launch {
        val ketQua = layGiaTri()
        println("Ket qua tu GlobalScope.launch = ${"%.2f".format(ketQua)}")
    }
    job1.join()

    println("=== Goi ham suspend xuLyGiaTri() ===")
    xuLyGiaTri()

    println("=== Vi du huy Job ===")
    val job2: Job = GlobalScope.launch {
        repeat(5) {
            println("Dang lam viec $it ...")
            delay(200)
        }
    }
    delay(500) // cho chay mot chut
    job2.cancelAndJoin()
    println("Job2 da bi huy")

    println("=== runBlocking voi async/await ===")
    val deferred: Deferred<Double> = async { layGiaTri() }
    println("Gia tri nhan duoc = ${"%.2f".format(deferred.await())}")

    println("=== Vi du try/catch ===")
    try {
        hamNguyHiem()
    } catch (e: Exception) {
        println("Bat loi: ${e.message}")
    }

    println("=== Vi du enum + when ===")
    val huong = QuanLyDuLieu.Huong.BAC
    when (huong) {
        QuanLyDuLieu.Huong.BAC  -> println("Di ve huong Bac")
        QuanLyDuLieu.Huong.NAM  -> println("Di ve huong Nam")
        QuanLyDuLieu.Huong.TAY  -> println("Di ve huong Tay")
        QuanLyDuLieu.Huong.DONG -> println("Di ve huong Dong")
    }
}

fun hamNguyHiem() {
    throw Exception("Co loi xay ra trong ham nguy hiem!")
}

object QuanLyDuLieu {
    enum class Huong {
        BAC, NAM, TAY, DONG
    }
}
