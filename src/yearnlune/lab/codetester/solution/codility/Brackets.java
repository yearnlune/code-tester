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
	Stack<String> stack = new Stack<>();

	@Override
	public Object setUp() {
		return null;
	}

	public int solution(String S) {
		for (char c : S.toCharArray()) {
			String s = String.valueOf(c);

			if (!isNested(s)) {
				stack.push(s);
			} else {
				stack.pop();
			}
		}

		if (!stack.empty()) {
			answer = 0;
		}

		return answer;
	}

	public boolean isNested(String s) {
		boolean isNested = false;

		if (stack.empty())
			return false;

		String lastElement = stack.peek();
		switch (s) {
			case "]":
				if (lastElement.equals("["))
					isNested = true;
				break;
			case "}":
				if (lastElement.equals("{"))
					isNested = true;
				break;
			case ")":
				if (lastElement.equals("("))
					isNested = true;
				break;
			default:

		}
		return isNested;
	}
}
