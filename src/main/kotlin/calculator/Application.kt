package calculator

import camp.nextstep.edu.missionutils.Console

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
    return numbers
        .filter { it.isNotBlank() }
        .map { s ->
            val number = s.toIntOrNull()
                ?: throw IllegalArgumentException("입력된 문자열에 숫자 이외의 값(${s})이 포함되어 있습니다.")

            if (number < 0) {
                throw IllegalArgumentException("음수(${number})는 입력할 수 없습니다.")
            }
            number
        }
        .sum()
}

fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val str = Console.readLine()

    println("결과 : ${calculate(str)}")
}