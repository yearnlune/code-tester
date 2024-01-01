package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2024.1.1
 * DESCRIPTION : https://www.hackerrank.com/challenges/pairs/problem
 */
class Pairs : SolutionBase {
    override fun setUp(): Any {
        val k = 2
        val arr = arrayOf(1, 5, 3, 4, 2)
        return pairs(k, arr)
    }

    @MainFunction
    fun pairs(k: Int, arr: Array<Int>): Int {
        val map = arr.associateWith { true }
        return arr.filter { map.containsKey(it + k) }.size
    }
}