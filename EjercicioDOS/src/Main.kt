interface getFizzBuzz{
    fun printFizzBuzz(start: Int, end: Int)
}


class FizzBuzz : getFizzBuzz {

    override fun printFizzBuzz(start: Int, end: Int) {

        if (start > end) {
            throw IllegalArgumentException("El valor de inicio no puede ser mayor que el valor final.")
        }

        if (start < 1 || end < 1) {
            throw IllegalArgumentException("El rango de números debe ser positivo.")
        }


        for (i in start..end) {
            when {
                i % 3 == 0 && i % 5 == 0 -> println("FizzBuzz")
                i % 3 == 0 -> println("Fizz")
                i % 5 == 0 -> println("Buzz")
                else -> println(i)
            }
        }
    }
}


fun main() {
    val fizzBuzz = FizzBuzz()

    try {
        fizzBuzz.printFizzBuzz(1, 100)

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
