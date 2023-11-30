fun main() {
    val scanner = java.util.Scanner(System.`in`)
    val numbers = IntArray(3) { scanner.nextInt() }
    numbers.sort()
    for (number in numbers) {
        print("$number ")
    }
}
