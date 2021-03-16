package yearnlune.lab.codetester.solution.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.16
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class CompletedPlayerYet implements Solution {
	@Override
	public Object setUp() {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};

		return solution(participant, completion);
	}

	public String solution(String[] participant, String[] completion) {
		String answer = "";

		if (completion.length < 1) {
			return participant[0];
		}

		List<String> participantList = new ArrayList<>(Arrays.asList(participant));
		List<String> completionList = new ArrayList<>(Arrays.asList(completion));

		Collections.sort(participantList);
		Collections.sort(completionList);

		for (int i = 0; i < participantList.size(); ++i) {
			if (i == participantList.size() - 1) {
				answer = participantList.get(i);
				break;
			}
			if (!participantList.get(i).equals(completionList.get(i))) {
				answer = participantList.get(i);
				break;
			}
		}

		return answer;
	}
}
