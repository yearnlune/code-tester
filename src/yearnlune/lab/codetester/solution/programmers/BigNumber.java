package yearnlune.lab.codetester.solution.programmers;

import java.util.Arrays;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.01
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class BigNumber implements SolutionBase {
	@Override
	public Object setUp() {
		int[] numbers = {6, 10, 2};
		return solution(numbers);
	}

    @MainFunction
	public String solution(int[] numbers) {
		String stringNumber = Arrays.stream(numbers)
			.mapToObj(String::valueOf)
			.sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
			.reduce(String::concat)
			.orElse("");

		if (stringNumber.startsWith("0")) {
			stringNumber = "0";
		}

		return stringNumber;
	}
}
