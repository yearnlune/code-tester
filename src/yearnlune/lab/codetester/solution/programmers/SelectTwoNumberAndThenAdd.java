package yearnlune.lab.codetester.solution.programmers;

import java.util.HashSet;
import java.util.Set;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.21
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/68644
 */
public class SelectTwoNumberAndThenAdd implements Solution {
	@Override
	public Object setUp() {
		int[] numbers = {5, 0, 2, 7};
		return solution(numbers);
	}

	public int[] solution(int[] numbers) {
		Set<Integer> answerSet = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				answerSet.add(numbers[i] + numbers[j]);
			}
		}

		return answerSet.stream().mapToInt(Integer::intValue).sorted().toArray();
	}
}
