package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.05
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/12899
 */
public class OneTwoFour implements SolutionBase {
	@Override
	public Object setUp() {
		int n = 10;
		return solution(n);
	}

    @MainFunction
	public String solution(int n) {
		String[] numbers = {"4", "1", "2", ""};
		String answer = "";

		while (n > 0) {
			answer = numbers[n % 3] + answer;
			if (n % 3 == 0) n--;
			n /= 3;
		}

		return answer;
	}
}
