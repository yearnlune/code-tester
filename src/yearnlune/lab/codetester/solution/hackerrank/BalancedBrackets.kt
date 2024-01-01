package yearnlune.lab.codetester.solution.hackerrank

import yearnlune.lab.codetester.handler.MainFunction
import yearnlune.lab.codetester.solution.SolutionBase
import java.util.Stack

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2024.1.1
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-balanced-brackets/problem
 */
class BalancedBrackets : SolutionBase {
    override fun setUp(): Any {
        return isBalanced("[({()})]")
    }

    @MainFunction
    fun isBalanced(s: String): String {
        val stack = Stack<Char>()
        for (it in s.toCharArray()) {
            if (stack.isNotEmpty() &&
                ((it == ']' && stack.peek() == '[') ||
                        (it == '}' && stack.peek() == '{') ||
                        (it == ')' && stack.peek() == '('))
            ) {
                stack.pop()
            } else if (it == ']' || it == '}' || it == ')') {
                return "NO"
            } else {
                stack.push(it)
            }
        }
        return if (stack.isEmpty()) "YES" else "NO"
    }
}