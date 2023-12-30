package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase
import kotlin.math.max

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.30
 * DESCRIPTION : https://www.hackerrank.com/challenges/palindrome-index/problem
 */
class PalindromeIndex : SolutionBase {
    override fun setUp(): Any {
        return palindromeIndex("hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh")
//        return palindromeIndex("aaab")
    }

    @MainFunction
    fun palindromeIndex(s: String): Int {
        val arr = s.toCharArray()
        val candidates = arrayOf(-1, -1)
        var swift = 0
        for (i in 0 until arr.size / 2) {
            val first = arr[i]
            val second = arr[arr.size - 1 - i - swift]
            if (first == second) {
                continue
            } else {
                if (candidates[0] == -1) {
                    if (first == arr[arr.size - 1 - i - 1]) {
                        candidates[0] = arr.size - 1 - i
                        swift++
                    }
                } else {
                    candidates[0] = -1
                    break
                }
            }
        }

        swift = 0

        for (i: Int in 0 until arr.size / 2) {
            val first = arr[i + swift]
            val second = arr[arr.size - 1 - i]
            if (first == second) {
                continue
            } else {
                if (candidates[1] == -1) {
                    if (arr[i + 1] == second) {
                        candidates[1] = i
                        swift++
                    }
                } else {
                    candidates[1] = -1
                    break
                }
            }
        }

        return max(candidates[0], candidates[1])
    }
}