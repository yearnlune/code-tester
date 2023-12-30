package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.30
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-caesar-cipher-1/problem
 */
class CaesarCipher : SolutionBase {
    override fun setUp(): String {
        val s = "There's-a-starman-wating-in-the-sky"
        val k = 0
        return caesarCipher(s, k)
    }

    @MainFunction
    fun caesarCipher(s: String, k: Int): String {
        return s.toCharArray()
            .map {
                var candidate = it
                if ((it in 'a'..'z') || it in 'A'..'Z') {
                    candidate += (k % 26)
                    if ((candidate > 'Z' && it < 'a') || (candidate > 'z')) {
                        candidate -= 26
                    }
                }
                candidate
            }
            .joinToString("")
    }
}