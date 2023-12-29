package yearnlune.lab.codetester.solution.programmers

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.19
 * DESCRIPTION : https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */
class WalkInThePark : SolutionBase {
    override fun setUp(): IntArray {
        val park = arrayOf("OSO", "OOO", "OXO", "OOO")
        val routes = arrayOf("E 2", "S 3", "W 1")
        return solution(park, routes)
    }

    val constructions = mutableMapOf<Pair<Int, Int>, Boolean>()

    @MainFunction
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var current = 0 to 0
        var height = park.size
        var width = 0
        park.forEachIndexed { y, array ->
            array.toCharArray()
                .forEachIndexed { x, c ->
                    if (c == 'S') {
                        current = x to y
                    }
                    if (c == 'X') {
                        constructions[x to y] = true
                    }
                }
            width = array.length
        }


        val directionMap = mapOf(
            "N" to { current: Pair<Int, Int>, distance: Int ->
                {
                    if ((1..distance)
                            .any { constructions.contains(current.first to current.second - it) }
                    ) {
                        current
                    } else {
                        current.first to current.second - distance
                    }
                }
            },
            "W" to { current: Pair<Int, Int>, distance: Int ->
                {
                    if ((1..distance)
                            .any { constructions.contains(current.first - it to current.second) }
                    ) {
                        current
                    } else {
                        current.first - distance to current.second
                    }
                }
            },
            "S" to { current: Pair<Int, Int>, distance: Int ->
                {
                    if ((1..distance)
                            .any { constructions.contains(current.first to current.second + it) }
                    ) {
                        current
                    } else {
                        current.first to current.second + distance
                    }

                }
            },
            "E" to { current: Pair<Int, Int>, distance: Int ->
                {
                    if ((1..distance)
                            .any { constructions.contains(current.first + it to current.second) }
                    ) {
                        current
                    } else {
                        current.first + distance to current.second
                    }

                }
            },
        )

        routes.forEach {
            val tokens = it.split(" ")
            val direction = tokens[0]
            val distance = tokens[1].toInt()
            val candidate = directionMap[direction]!!(current, distance)()
            if (candidate.first in 0 until width &&
                candidate.second in 0 until height
            ) {
                current = candidate
            }
        }

        return intArrayOf(current.second, current.first)
    }
}