package yearnlune.lab.codetester.solution.programmers;

import java.util.Arrays;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.17
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42840
 */
public class PracticeTest implements SolutionBase {
	@Override
	public Object setUp() {
		return solution(new int[]{1,2,3,4,5});
	}

    @MainFunction
	public int[] solution(int[] answers) {
		int[] answer = {};
		int maxScore = Integer.MIN_VALUE;

		int[][] testerAnswerPatterns = new int[][] {
			{},
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
		};

		for (int i = 1; i < testerAnswerPatterns.length; ++i) {
			int score = 0;
			int[] testerAnswer = testerAnswerPatterns[i];

			for (int j = 0; j < answers.length; ++j) {
				if (answers[j] == testerAnswer[j % testerAnswer.length]) {
					++score;
				}
			}

			if (score > maxScore) {
				answer = new int[] {i};
				maxScore = score;
			} else if (score == maxScore) {
				answer = Arrays.copyOf(answer, answer.length + 1);
				answer[answer.length - 1] = i;
			}
		}

		return answer;
	}
}
