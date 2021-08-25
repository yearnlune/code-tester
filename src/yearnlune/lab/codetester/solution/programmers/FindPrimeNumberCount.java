package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.04.05
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/12921
 */
public class FindPrimeNumberCount implements SolutionBase {
	@Override
	public Object setUp() {
		int n = 2;
		return solution(n);
	}

    @MainFunction
	public int solution(int n) {
		int answer = 0;
		boolean[] numbers = new boolean[n + 1];

		numbers[0] = true;
		numbers[1] = true;
		numbers[2] = false;

		if (n > 2) {
			numbers[3] = false;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 2; i * j <= n; j++) {
				if (!numbers[i * j]) {
					numbers[i * j] = true;
				}
			}
		}

		for (boolean isNotPrimeNumber : numbers) {
			if(!isNotPrimeNumber)
				answer++;
		}

		return answer;
	}

}
