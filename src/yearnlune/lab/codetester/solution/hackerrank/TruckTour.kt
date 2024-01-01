package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2024.1.1
 * DESCRIPTION : https://www.hackerrank.com/challenges/truck-tour/problem
 */
class TruckTour : SolutionBase {
    override fun setUp(): Any {
        val petrolpumps =
            arrayOf(arrayOf(46675, 40604), arrayOf(95711, 49370), arrayOf(25140, 76805), arrayOf(60012, 40610), arrayOf(31614, 56881))
        return truckTour(petrolpumps)
    }

    @MainFunction
    fun truckTour(petrolpumps: Array<Array<Int>>): Int {
        var answer = 0
        for (i: Int in petrolpumps.indices) {
            if (petrolpumps[i][0] >= petrolpumps[i][1]) {
                var cap = 0L
                var failure = false
                for (j: Int in i until petrolpumps.size) {
                    cap = (cap + petrolpumps[j][0]) - petrolpumps[j][1]
                    if (cap < 0) {
                        failure = true
                        break
                    }
                }

                if (!failure) {
                    for (j: Int in 0 until i) {
                        cap = (cap + petrolpumps[j][0]) - petrolpumps[j][1]
                        if (cap < 0) {
                            break
                        }
                    }
                }

                if (cap >= 0) {
                    answer = i
                    break
                }
            }
        }

        return answer
    }
}