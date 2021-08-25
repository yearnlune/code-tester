package yearnlune.lab.codetester.solution.programmers;

import java.util.ArrayList;
import java.util.List;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.15
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/12906
 */
public class UniqueNumber implements SolutionBase {
	@Override
	public Object setUp() {
		int[] arr = {1,1,3,3,0,1,1};
		return solution(arr);
	}

    @MainFunction
	public int[] solution(int[] arr) {
		List<Integer> answer = new ArrayList<>();
		int temp;

		answer.add(arr[0]);

		for (int i = 1; i < arr.length; i++) {
			temp = arr[i - 1];
			if (temp == arr[i])
				continue;
			answer.add(arr[i]);
		}

		return answer.stream()
			.mapToInt(Integer::intValue)
			.toArray();
	}
}
