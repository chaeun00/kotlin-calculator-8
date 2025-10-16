package calculator

fun calculate(text: String?): Int {
    if (text.isNullOrBlank()) {
        return 0
    }

    val numbersAsStrings = splitInput(text)

    return sumNumbers(numbersAsStrings)
}

private fun splitInput(text: String): List<String> {
    val regex = "//(.*)\n(.*)".toRegex()
    val matchResult = regex.find(text.replace("\\n", "\n"))

    if (matchResult != null) {
        val (customDelimiter, numbersPart) = matchResult.destructured
        return numbersPart.split(customDelimiter)
    }

    return text.split("[,:]".toRegex())
}

private fun sumNumbers(numbers: List<String>): Int {
    return numbers.sumOf { it.toInt() }
}

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val str = readLine()

    println("결과 : ${calculate(str)}")
}