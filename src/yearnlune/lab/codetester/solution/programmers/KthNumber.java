package yearnlune.lab.codetester.solution.programmers;

import java.util.Arrays;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.16
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42748
 */
public class KthNumber implements SolutionBase {
	@Override
	public Object setUp() {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		return solution(array, commands);
	}

    @MainFunction
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		int commandNumber = 0;
		for (int[] command : commands) {
			int startAt = command[0] - 1;
			int endAt = command[1];
			int kth = command[2] - 1;

			int[] tempArray;
			tempArray = Arrays.copyOfRange(array, startAt, endAt);
			Arrays.sort(tempArray);
			answer[commandNumber++] = tempArray[kth];
		}

		return answer;
	}
}
