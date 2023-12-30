package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.30
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-tower-breakers-1/problem
 */
class TowerBreakers : SolutionBase {
    override fun setUp(): Int {
        val n = 2
        val m = 2
        return towerBreakers(n, m)
    }

    @MainFunction
    fun towerBreakers(n: Int, m: Int): Int {
        return if (n % 2 == 0 || m == 1) { 2 } else { 1 };
    }
}