package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.30
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-grid-challenge/problem
 */
class GridChallenge : SolutionBase {
    override fun setUp(): Any {
        val grid = arrayOf("ebacd", "fghij", "olmkn", "trpqs", "xywuv")
        return gridChallenge(grid)
    }

    @MainFunction
    fun gridChallenge(grid: Array<String>): String {
        var valid = "YES"
        val g = grid.map { it.toCharArray().sorted() }

        for (y: Int in 1 until g.size) {
            for (x: Int in g[0].indices) {
                if (g[y][x] < g[y - 1][x]) {
                    valid = "NO"
                    break
                }
            }
        }
        return valid
    }
}