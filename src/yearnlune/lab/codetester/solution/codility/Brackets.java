package yearnlune.lab.codetester.solution.codility;

import java.util.Stack;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.01
 * DESCRIPTION : https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 */
public class Brackets implements Solution {
	int answer = 1;
	Stack<Character> stack = new Stack<>();

	@Override
	public Object setUp() {
		String S = "{[()()]}";

		return solution(S);
	}

	public int solution(String S) {
		for (char c : S.toCharArray()) {
			if (!isNested(c)) {
				stack.push(c);
			} else {
				stack.pop();
			}
		}

		if (!stack.empty()) {
			answer = 0;
		}

		return answer;
	}

	private boolean isNested(char s) {
		boolean isNested = false;

		if (stack.empty())
			return false;

		char lastElement = stack.peek();
		switch (s) {
			case ']':
				if (lastElement == '[')
					isNested = true;
				break;
			case '}':
				if (lastElement == '{')
					isNested = true;
				break;
			case ')':
				if (lastElement == '(')
					isNested = true;
				break;
			default:
		}
		return isNested;
	}
}
