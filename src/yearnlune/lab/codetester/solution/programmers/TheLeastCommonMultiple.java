package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.18
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/12953
 */
public class TheLeastCommonMultiple implements SolutionBase {
	@Override
	public Object setUp() {
		int[] arr = {2, 6, 8, 14};
		return solution(arr);
	}

    @MainFunction
	public int solution(int[] arr) {
		int answer = 0;
		boolean isFound = false;
		while (!isFound) {
			answer++;

			int i = 0;
			for (; i < arr.length; i++) {
				if (answer % arr[i] > 0) {
					break;
				}
			}

			if (i == arr.length) {
				isFound = true;
			}
		}

		return answer;
	}
}
