package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

class SuperDigit : SolutionBase {
    override fun setUp(): Any {
        return superDigit("1", 4)
    }

    @MainFunction
    fun superDigit(n: String, k: Int): Int {
        var sum = n.toCharArray().sumOf { it.toString().toLong() } * k
        if (sum.toString().length > 1) {
            return superDigit(sum.toString(), 1)
        }
        return sum.toInt()
    }
}