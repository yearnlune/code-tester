package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase
import kotlin.math.max

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.30
 * DESCRIPTION : https://www.hackerrank.com/challenges/flipping-the-matrix/problem
 */
class FlippingMatrix : SolutionBase {
    override fun setUp(): Int {
        val matrix = arrayOf(
            arrayOf(112, 42, 83, 119),
            arrayOf(56, 125, 56, 49),
            arrayOf(15, 78, 101, 43),
            arrayOf(62, 98, 114, 108)
        )
        return flippingMatrix(matrix)
    }

    @MainFunction
    fun flippingMatrix(matrix: Array<Array<Int>>): Int {
        var sum = 0
        val length = matrix.size
        for (y: Int in 0 until length / 2) {
            for (x: Int in 0 until length / 2) {
                sum += max(
                    matrix[y][x],
                    max(
                        matrix[length - y - 1][x],
                        max(
                            matrix[y][length - 1 - x],
                            max(
                                matrix[length - 1 - y][length - 1 - x],
                                0
                            )
                        )
                    )
                )
            }
        }
        return sum
    }
}