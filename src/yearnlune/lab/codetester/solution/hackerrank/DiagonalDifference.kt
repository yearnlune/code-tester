package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase
import kotlin.math.abs

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.30
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-diagonal-difference/
 */
class DiagonalDifference : SolutionBase {
    override fun setUp(): Any {
        val arr = arrayOf(arrayOf(11, 2, 4), arrayOf(4, 5, 6), arrayOf(10, 8, -12))
        return diagonalDifference(arr)
    }

    @MainFunction
    fun diagonalDifference(arr: Array<Array<Int>>): Int {
        val diagonals = intArrayOf(0, 0)
        for (y: Int in arr.indices) {
            for (x: Int in arr[y].indices) {
                if (x == y) {
                    diagonals[0] = diagonals[0] + arr[y][x]
                }
                if (x + y == arr.size - 1) {
                    diagonals[1] = diagonals[1] + arr[y][x]
                }
            }
        }

        return abs(diagonals[0] - diagonals[1])
    }
}