package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.29
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/12951
 */
public class JadenCase implements SolutionBase {
	@Override
	public Object setUp() {
		String s = "3people unFollowed me";
		return solution(s);
	}

    @MainFunction
	public String solution(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		s = s.toLowerCase();

		char pre = ' ';
		for (int i = 0; i < s.length(); i++) {
			char character = s.charAt(i);
			if (pre == ' ' && character >= 97 && character < 123) {
				character -= 32;
			}
			stringBuilder.append(character);
			pre = character;
		}

		return stringBuilder.toString();
	}
}
