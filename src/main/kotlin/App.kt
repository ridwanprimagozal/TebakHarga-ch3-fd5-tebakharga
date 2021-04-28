import generator.ItemPriceGenerator
import model.ItemPrice
import kotlin.math.absoluteValue
import kotlin.system.exitProcess

class App {

    private val items = ItemPriceGenerator.getItems()
    private lateinit var selectedItemPrice: ItemPrice
    private var inputPlayerOne = 0
    private var inputPlayerTwo = 0


    companion object {
        const val PRICE_EQUAL = 0
        const val PRICE_MORE_THAN = 1
        const val PRICE_LESS_THAN = 2

        @JvmStatic
        fun main(args: Array<String>) {
            App().runGame()
        }

    }


    fun runGame() {
        println("====================================")
        println("Game Tebak Harga")
        println("====================================")
        println("Start Game ? (Y/N)")
        if (readLine().equals("Y", ignoreCase = true)) {
            startGame()
        } else {
            println("Game Closed")
            exitProcess(0)
        }

    }


    private fun startGame() {
        selectedItemPrice = items[(0 until items.size).random()]
        printInfoItem(selectedItemPrice)
        inputPriceUser()
        checkWinner(checkPrice(inputPlayerOne),
            checkPrice(inputPlayerTwo))
    }

    private fun inputPriceUser() {
        println("Masukan Harga Pemain Pertama = ")
        readLine()?.toInt()?.let {
            inputPlayerOne = it
        }
        println("Masukan Harga Pemain Kedua = ")
        readLine()?.toInt()?.let {
            inputPlayerTwo = it
        }
    }


    private fun printInfoItem(selectedItemPrice: ItemPrice) {
        println("====================================")
        println("Tebaklah Harga = ${selectedItemPrice.itemName}")
        println("====================================")
    }

    private fun checkPrice(userInput: Int): Int {
        return when {
            userInput == selectedItemPrice.price -> {
                PRICE_EQUAL
            }
            userInput > selectedItemPrice.price -> {
                PRICE_MORE_THAN
            }
            else -> {
                PRICE_LESS_THAN

            }
        }

    }

    private fun checkWinner(resultPlayerOne: Int, resultPlayerTwo: Int) {

        println("=====================================")
        println("Harga untuk barang ${selectedItemPrice.itemName}, adalah ${selectedItemPrice.price}")
        println("Hasilnya adalah....")
        println("=====================================")
        if (resultPlayerOne == PRICE_EQUAL) {
            if (resultPlayerTwo == PRICE_EQUAL) {
                println("Keduanya Benar, Tidak ada yang menang")
            } else {
                println("Player 1 Menang")

            }
        } else {

            if (resultPlayerTwo == PRICE_EQUAL) {
                println("Player 2 Menang")
            } else {
                val diffOne = (inputPlayerOne - selectedItemPrice.price).absoluteValue
                val diffTwo = (inputPlayerTwo - selectedItemPrice.price).absoluteValue
                when {
                    (diffOne < diffTwo) -> {
                        println("Player 1 Mendekati Benar, Player 1 Menang")
                    }
                    (diffOne < diffTwo) -> {
                        println("Player 2 Mendekati Benar, Player 1 Menang")
                    }
                    else -> {
                        println("Keduanya hampir benar,tidak ada yang benar")
                    }

                }

            }

        }

    }

}

