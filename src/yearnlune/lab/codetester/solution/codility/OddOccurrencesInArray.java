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
 * DESCRIPTION : https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
 */
public class OddOccurrencesInArray implements SolutionBase {
	@Override
	public Object setUp() {
		int[] A = {9, 3, 9, 3, 9, 7, 9};

		return solution(A);
	}

    @MainFunction
	public int solution(int[] A) {
		int answer = 0;
		Set<Integer> numberCounters = new HashSet<>();

		for (int num : A) {
			if (numberCounters.contains(num)) {
				numberCounters.remove(num);
			} else {
				numberCounters.add(num);
			}
		}

		for (Integer number : numberCounters) {
			answer = number;
		}

		return answer;
	}
}
