package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.10
 * DESCRIPTION :
 */
public class CaesarPassword implements Solution {
	@Override
	public Object setUp() {
		String s = "z Z a B";
		int n = 5;

		return solution(s, n);
	}

	public String solution(String s, int n) {
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char refined = c;
			if (c >= 65 && c <= 90) {
				refined += n;
				if (refined > 90)
					refined -= 26;
			} else if(c >= 97 && c <= 122) {
				refined += n;
				if (refined > 122)
					refined -= 26;
			}
			answer += refined;
		}

		return answer;
	}
}
