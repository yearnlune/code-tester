package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.13
 * DESCRIPTION :
 */
public class EvenAndOdd implements Solution {
	@Override
	public Object setUp() {
		int num = -9;
		return solution(num);
	}

	public String solution(int num) {
		String[] answers = {"Odd", "Even", "Odd"};

		return answers[(num % 2) + 1];
	}
}
