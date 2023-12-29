package yearnlune.lab.codetester.solution.programmers

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.19
 * DESCRIPTION : https://school.programmers.co.kr/learn/courses/30/lessons/178871
 */
class Racing : SolutionBase {
    override fun setUp(): Array<String> {
        val players = arrayOf("mumu", "soe", "poe", "kai", "mine")
        val callings = arrayOf("kai", "kai", "mine", "mine")
        return solution(players, callings)
    }

    @MainFunction
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val answer = mutableListOf<String>()
        val map: MutableMap<String, Int> = players.mapIndexed { i, name -> name to i }.toMap().toMutableMap()
        val reverseMap: MutableMap<Int, String> = players.mapIndexed { i, name -> i to name }.toMap().toMutableMap()

        callings.forEach {
            val sourceRank = map[it]!!
            val targetName = reverseMap[sourceRank - 1]!!
            map[it] = sourceRank - 1;
            reverseMap[sourceRank] = targetName
            reverseMap[sourceRank - 1] = it
            map[targetName] = sourceRank
        }

        for (i: Int in players.indices) {
            answer.add(reverseMap[i]!!)
        }

        return answer.toTypedArray()
    }
}