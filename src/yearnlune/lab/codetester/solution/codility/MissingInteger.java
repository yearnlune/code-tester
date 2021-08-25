package yearnlune.lab.codetester.solution.codility;

import java.util.HashSet;
import java.util.Set;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.19
 * DESCRIPTION : https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 */
public class MissingInteger implements SolutionBase {
	@Override
	public Object setUp() {
		int[] A = {1, 3, 6, 4, 1, 2};

		return solution(A);
	}

    @MainFunction
	public int solution(int[] A) {
		int answer = 1;
		Set<Integer> numbers = new HashSet<Integer>();

		for (int i = 0; i < A.length; i++) {
			numbers.add(A[i]);
		}

		while (true) {
			if (!numbers.contains(answer))
				break;
			answer++;
		}

		return answer;
	}
}
