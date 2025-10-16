package calculator

fun calculate(text: String?): Int {
    if (text.isNullOrBlank()) {
        return 0
    }

    val numbersAsStrings = splitInput(text)

    return sumNumbers(numbersAsStrings)
}

private fun splitInput(text: String): List<String> {
    return text.split("[,:]".toRegex())
}

private fun sumNumbers(numbers: List<String>): Int {
    var sum = 0
    for (numberStr in numbers) {
        val num = numberStr.toInt()
        sum += num
    }

    return sum
}

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val str = readLine()

    println("결과 : ${calculate(str)}")
}