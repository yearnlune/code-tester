package yearnlune.lab.codetester.solution.programmers

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.19
 * DESCRIPTION : https://school.programmers.co.kr/learn/courses/30/lessons/176963
 */
class MemoryScore : SolutionBase {
    override fun setUp(): IntArray {
        val name = arrayOf("may", "kein", "kain", "radi");
        val yearning = intArrayOf(5, 10, 1, 3)
        val photo = arrayOf(
            arrayOf("may", "kein", "kain", "radi"),
            arrayOf("may", "kein", "brin", "deny"),
            arrayOf("kon", "kain", "may", "coni")
        )
        return solution(name, yearning, photo)
    }

    @MainFunction
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val scoreMap = name.mapIndexed { i, n ->
            n to yearning[i]
        }.toMap()

        return photo.map {
            it.map { scoreMap[it] ?: 0 }.sumOf { it }
        }.toIntArray()
    }
}