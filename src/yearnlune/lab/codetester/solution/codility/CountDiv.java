package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.02.28
 * DESCRIPTION : https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 *
 *  0 % N = 0;
 *
 */
public class CountDiv implements Solution {

	@Override
	public Object setUp() {
		return null;
	}

	public int solution(int A, int B, int K) {
		int answer = 0;

		double quotientA = Math.ceil((double)A / K);
		int quotientB = B / K;

		quotientA--;

		answer = quotientB - (int)quotientA;
		return answer;
	}
}
