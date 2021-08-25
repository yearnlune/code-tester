package yearnlune.lab.codetester.solution.programmers;

import java.util.Arrays;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.16
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class CompletedPlayerYet implements SolutionBase {
	@Override
	public Object setUp() {
		String[] participant = {"a", "b", "c", "d"};
		String[] completion = {"a", "c", "b"};

		return solution(participant, completion);
	}

    @MainFunction
	public String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);

		int i;
		for (i = 0; i < completion.length; ++i) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return participant[i];
	}
}
