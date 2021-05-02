package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.04.19
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/12985
 */
public class GameFestival implements Solution {
	@Override
	public Object setUp() {
		int n = 8;
		int a = 4;
		int b = 7;
		return solution(n, a, b);
	}

	public int solution(int n, int a, int b) {
		int answer = 0;

		while (a != b) {
			a = (a + 1) / 2;
			b = (b + 1) / 2;
			answer++;
		}

		return answer;
	}
}
