package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.17
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/12916
 */
public class PyChecker implements Solution {
	@Override
	public Object setUp() {
		String s = "pPoooyY";
		return solution(s);
	}

	boolean solution(String s) {
		int pNumber = 0;
		int yNumber = 0;

		s = s.toLowerCase();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'p') {
				pNumber++;
			} else if (s.charAt(i) == 'y') {
				yNumber++;
			}
		}

		return pNumber == yNumber;
	}
}
