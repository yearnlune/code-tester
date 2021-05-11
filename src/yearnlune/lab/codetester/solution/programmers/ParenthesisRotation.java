package yearnlune.lab.codetester.solution.programmers;

import java.util.Stack;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.12
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/76502
 */
public class ParenthesisRotation implements Solution {
	@Override
	public Object setUp() {
		String s = "}]()[{";
		return solution(s);
	}

	public int solution(String s) {
		int answer = 0;
		Stack<Character> stack = new Stack<>();

		for (int startIndex = 0; startIndex < s.length(); startIndex++) {
			for (int j = 0; j < s.length(); j++) {
				int next = (startIndex + j) % s.length();
				char parenthesis = s.charAt(next);

				if (!stack.isEmpty() &&
					stack.peek() < parenthesis &&
					parenthesis - stack.peek() < 3) {
					stack.pop();
				} else {
					stack.push(parenthesis);
				}
			}

			if (stack.isEmpty()) {
				answer++;
			}

			stack.clear();
		}

		return answer;
	}
}
