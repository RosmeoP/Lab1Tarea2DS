interface MyNumber {
    fun isPrime(): Boolean
    fun isEven(): Boolean
    fun isOdd(): Boolean
    val value: Int
}


open class BaseNumber(override val value: Int) : MyNumber {

    override fun isPrime(): Boolean {
        if (value < 2) return false
        for (i in 2 until   value) {
            if (value % i == 0) return false
        }
        return true
    }

    override fun isEven(): Boolean {
        return value % 2 == 0
    }

    override fun isOdd(): Boolean {
        return value % 2 != 0
    }
}


class EvenNumber(value: Int) : BaseNumber(value){
    init {
        require(isEven()){
            "The number $value is not even"
        }
    }
}

class OddNumber(value: Int) : BaseNumber(value){
    init {
        require(isOdd()){
            "The number $value is not odd"
        }
    }
}

class PrimeNumber(value: Int) : BaseNumber(value) {
    init {
        require(isPrime()) { "The number $value is not prime." }
    }
}

fun countNumbers(n: Int) {
    var primeCount = 0
    var evenCount = 0
    var oddCount = 0

    for (i in 1..n) {
        val number = BaseNumber(i)

        if (number.isPrime()) primeCount++
        if (number.isEven()) evenCount++
        if (number.isOdd()) oddCount++
    }

    println("Primes: $primeCount")
    println("Even: $evenCount")
    println("Odd: $oddCount")
}

fun main() {
    val n = 100
    countNumbers(n)
}
