package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.06.07
 * DESCRIPTION : https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
 */
public class TapeEquilibrium implements SolutionBase {
	@Override
	public Object setUp() {
		int[] A = {3, 1, 2, 4, 3};
		return solution(A);
	}

    @MainFunction
	public int solution(int[] A) {
		int answer = Integer.MAX_VALUE;
		int[] sum = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			sum[i] = A[i];
			if (i > 0) {
				sum[i] += sum[i - 1];
			}
		}

		int total = sum[sum.length - 1];
		for (int j = 1; j < sum.length; j++) {
			int left = sum[j - 1];
			int right = total - left;
			int between = Math.abs(left - right);

			answer = Math.min(answer, between);
		}

		return answer;
	}
}
