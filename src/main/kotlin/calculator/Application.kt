package calculator

fun calculate(text: String?): Int {
    if (text.isNullOrBlank()) {
        return 0
    }

    // 테스트 코드
    return 1
}


fun main() {
    // TODO: 프로그램 구현
    println("덧셈할 문자열을 입력해 주세요.")
    val str = readLine()

    println("결과 : " + calculate(str))
}