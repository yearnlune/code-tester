package yearnlune.lab.codetester.solution.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.02.28
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/72411
 */
public class MenuRenewal implements SolutionBase {
	HashMap<String, Integer> candidateMapByCourseSize;
	int maxOrderByCourseSize;

	@Override
	public Object setUp() {
		return null;
	}

    @MainFunction
	public String[] solution(String[] orders, int[] course) {
		List<String> answerList = new ArrayList<>();

		for (int courseCount : course) {
			/* INIT */
			candidateMapByCourseSize = new HashMap<>();
			maxOrderByCourseSize = 0;

			makeCourse(orders, courseCount);

			/* ELECTION */
			for (String candidate : candidateMapByCourseSize.keySet()) {
				if (maxOrderByCourseSize > 1 &&
					candidateMapByCourseSize.get(candidate) == maxOrderByCourseSize) {
					answerList.add(candidate);
				}
			}
		}

		Collections.sort(answerList);
		String[] answer = new String[answerList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}

	public void makeCourse(String[] orders, int courseCount) {
		for (String order : orders) {
			makeCandidate(order, courseCount, 0, "", 0);
		}
	}

	public void makeCandidate(String order, int courseCount, int depth, String temp, int idx) {
		if (courseCount == depth) {
			char[] characterArrays = temp.toCharArray();
			Arrays.sort(characterArrays);
			String candidate = "";

			for (char characterArray : characterArrays) {
				candidate += characterArray;
			}

			candidateMapByCourseSize.put(candidate, candidateMapByCourseSize.getOrDefault(candidate, 0) + 1);
			maxOrderByCourseSize = Math.max(maxOrderByCourseSize, candidateMapByCourseSize.get(candidate));
			return;
		}

		for (int i = idx; i < order.length(); i++) {
			makeCandidate(order, courseCount, depth + 1, temp + order.charAt(i), i + 1);
		}
	}
}
