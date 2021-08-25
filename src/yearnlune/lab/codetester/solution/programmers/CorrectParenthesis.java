package yearnlune.lab.codetester.solution.programmers;

import java.util.Stack;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.11
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/12909
 */
public class CorrectParenthesis implements SolutionBase {
	@Override
	public Object setUp() {
		String s = "(())())()(";
		return solution(s);
	}

    @MainFunction
	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char parenthesis = s.charAt(i);
			if (!stack.isEmpty() &&
				stack.peek() == '(' &&
				parenthesis == ')') {
				stack.pop();
			} else {
				stack.push(parenthesis);
			}
		}

		return stack.isEmpty();
	}
}
