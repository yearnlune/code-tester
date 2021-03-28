package yearnlune.lab.codetester.solution.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.28
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/12915
 */
public class CustomStringSort implements Solution {
	@Override
	public Object setUp() {
		String[] strings = {"sun", "bed", "car"};
		int n = 1;

		return solution(strings, n);
	}

	public String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		List<String> stringList = new ArrayList<>();

		for (String string : strings) {
			String targetString = String.valueOf(string.charAt(n));
			stringList.add(targetString.concat("@" + string));
		}

		Collections.sort(stringList);

		int i = 0;
		for (String targetString : stringList) {
			answer[i++] = targetString.split("@")[1];
		}

		return answer;
	}
}
