package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.04.08
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/60057
 */
public class StringCompression implements SolutionBase {
	@Override
	public Object setUp() {
		String s = "aaaaaaaaaaaaaaaa";
		return solution(s);
	}

    @MainFunction
	public int solution(String s) {
		int answer = s.length();
		int stringLength = s.length();

		System.out.println("stringLength: " + stringLength);

		for (int i = stringLength / 2; i > 0; --i) {
			int candidate = 0;
			String temp = "";
			int count = 1;
			int countLength = 0;
			String parsedString = "";

			for (int j = 0; j < stringLength; j += i) {
				int end = j + i;
				if (end > stringLength) {
					end = stringLength;
				}
				parsedString = s.substring(j, end);

				if (temp.equals(parsedString)) {
					count++;
				} else {
					if (count > 1) {
						countLength = String.valueOf(count).length();
					} else {
						countLength = 0;
					}
					candidate += countLength + parsedString.length();
					temp = parsedString;
					count = 1;
				}
			}

			if (count > 1) {
				countLength = String.valueOf(count).length();
			} else {
				countLength = 0;
			}

			answer = Math.min(answer, candidate + countLength);
		}

		return answer;
	}
}
