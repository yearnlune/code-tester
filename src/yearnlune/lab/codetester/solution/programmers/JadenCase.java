package yearnlune.lab.codetester.solution.programmers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.29
 * DESCRIPTION :
 */
public class JadenCase implements Solution {
	@Override
	public Object setUp() {
		String s = "3people unFollowed me";
		return solution(s);
	}

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
