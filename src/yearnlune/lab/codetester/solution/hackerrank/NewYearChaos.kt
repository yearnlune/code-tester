package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase
import kotlin.math.max

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2024.1.1
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-new-year-chaos/problem
 */
class NewYearChaos : SolutionBase {
    override fun setUp(): Any {
        val q = arrayOf(1, 2, 5, 3, 7, 8, 6, 4)
        return minimumBribes(q)
    }

    @MainFunction
    fun minimumBribes(q: Array<Int>): Unit {
        var bribes = 0
        for (i: Int in q.indices) {
            if (q[i] - (i + 1) > 2) {
                return println("Too chaotic")
            }

            for (j: Int in max(0, q[i] - 2)..i) {
                if (q[j] > q[i]) bribes++
            }
        }

        return println(bribes)
    }
}