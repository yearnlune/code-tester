package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.30
 * DESCRIPTION : https://www.hackerrank.com/challenges/find-the-median/problem
 */
class FIndTheMedian : SolutionBase {
    override fun setUp(): Int {
        val arr = arrayOf(0, 1, 2, 4, 5, 6, 3)
        return findMedian(arr)
    }

    @MainFunction
    fun findMedian(arr: Array<Int>): Int {
        arr.sort()
        return arr[arr.size / 2]
    }
}