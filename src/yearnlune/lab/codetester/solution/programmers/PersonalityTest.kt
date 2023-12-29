package yearnlune.lab.codetester.solution.programmers

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.19
 * DESCRIPTION : https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
class PersonalityTest : SolutionBase {
    override fun setUp(): String {
        val survey = arrayOf("AN", "CF", "MJ", "RT", "NA")
        val choices = intArrayOf(5, 3, 2, 7, 5)
        return solution(survey, choices)
    }

    @MainFunction
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        val scores = intArrayOf(0, 3, 2, 1, 0, 1, 2, 3)
        val data = mutableMapOf(
            'R' to 0,
            'T' to 0,
            'C' to 0,
            'F' to 0,
            'J' to 0,
            'M' to 0,
            'A' to 0,
            'N' to 0,
        )
        for (i: Int in survey.indices) {
            val tokens = survey[i].toCharArray()
            if (choices[i] < 4) {
                data[tokens[0]] = data[tokens[0]]!! + scores[choices[i]]
            } else if (choices[i] > 4) {
                data[tokens[1]] = data[tokens[1]]!! + scores[choices[i]]
            }
        }

        answer += if (data['R']!! >= data['T']!!) {
            'R'
        } else {
            'T'
        }

        answer += if (data['C']!! >= data['F']!!) {
            'C'
        } else {
            'F'
        }

        answer += if (data['J']!! >= data['M']!!) {
            'J'
        } else {
            'M'
        }

        answer += if (data['A']!! >= data['N']!!) {
            'A'
        } else {
            'N'
        }

        println(data)

        return answer
    }
}