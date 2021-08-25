package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.04.12
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/17687
 */
public class DecimalGame implements SolutionBase {
	@Override
	public Object setUp() {
		int n = 16;
		int t = 16;
		int m = 3;
		int p = 2;
		return solution(n, t, m, p);
	}

    @MainFunction
	public String solution(int n, int t, int m, int p) {
		StringBuilder totalStringBuilder = new StringBuilder();
		StringBuilder answerStringBuilder = new StringBuilder();

		for (int i = 0; i < m * t; i++) {
			totalStringBuilder.append(Integer.toString(i, n).toUpperCase());
		}

		for (int i = p - 1; i < m * t; i += m) {
			answerStringBuilder.append(totalStringBuilder.charAt(i));
		}

		return answerStringBuilder.toString();
	}
}