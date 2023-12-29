package yearnlune.lab.codetester.solution.programmers

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase
import kotlin.math.max
import kotlin.math.min

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.19
 * DESCRIPTION : https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */
class DesktopCleanup : SolutionBase {
    override fun setUp(): IntArray {
        val wallpaper: Array<String> = arrayOf("#")
        return solution(wallpaper)
    }

    @MainFunction
    fun solution(wallpaper: Array<String>): IntArray {
        val answer: IntArray = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MIN_VALUE, Int.MIN_VALUE)

        wallpaper.forEachIndexed { y, s ->
            s.toCharArray().mapIndexed { x, c ->
                if (c == '#') {
                    answer[0] = min(answer[0], y)
                    answer[1] = min(answer[1], x)
                    answer[2] = max(answer[2], y + 1)
                    answer[3] = max(answer[3], x + 1)
                }
            }
        }

        return answer
    }
}