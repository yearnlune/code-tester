package yearnlune.lab.codetester.solution.programmers;

import java.util.Arrays;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.16
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class PhoneNumberList implements Solution {
	@Override
	public Object setUp() {
		String[] phoneBook = {"123","456","789"};
		return solution(phoneBook);
	}

	public boolean solution(String[] phone_book) {
		boolean answer = true;

		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; ++i) {
			boolean hasPrefix = true;
			String candidate = phone_book[i];
			String target = phone_book[i + 1];

			if (candidate.length() > target.length()) continue;

			for (int j = 0; j < candidate.length(); ++j) {
				if (candidate.charAt(j) != target.charAt(j)) {
					hasPrefix = false;
					break;
				}
			}

			if (hasPrefix) {
				answer = false;
				break;
			}
		}

		return answer;
	}

	public boolean improvedSolution(String[] phone_book) {
		Arrays.sort(phone_book);

		for (int i = 0; i < phone_book.length - 1; ++i) {
			String candidate = phone_book[i];
			String target = phone_book[i + 1];

			if (target.startsWith(candidate)) {
				return false;
			}
		}

		return true;
	}
}
