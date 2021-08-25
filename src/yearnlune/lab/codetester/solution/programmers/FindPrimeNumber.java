package yearnlune.lab.codetester.solution.programmers;

import java.util.HashSet;
import java.util.Set;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.30
 * DESCRIPTION :
 */
public class FindPrimeNumber implements SolutionBase {
	Set<Integer> set = new HashSet<>();

	@Override
	public Object setUp() {
		String numbers = "1234123";
		return solution(numbers);
	}

    @MainFunction
	public int solution(String numbers) {
		String[] numberArray = new String[numbers.length()];

		for (int i = 0; i < numbers.length(); i++) {
			numberArray[i] = String.valueOf(numbers.charAt(i));
		}

		for (int length = 1; length <= numberArray.length; length++) {
			boolean[] isVisited = new boolean[numbers.length()];
			makeNumber(numberArray, isVisited, "", 0, length);
		}

		return set.size();
	}

	public void makeNumber(String[] numberArray, boolean[] isVisited, String current, int index,
		int currentLength) {
		if (currentLength == 0) {
			if (current.startsWith("0"))
				return;
			int candidateNumber = Integer.parseInt(current);

			if (isPrimeNumber(candidateNumber)) {
				set.add(candidateNumber);
			}
		} else {
			for (int i = 0; i < numberArray.length; i++) {
				if (!isVisited[i]) {
					isVisited[i] = true;
					makeNumber(numberArray, isVisited, numberArray[i] + current, i + 1, currentLength - 1);
					isVisited[i] = false;
				}
			}
		}
	}

	public boolean isPrimeNumber(int number) {
		if (number == 2)
			return true;
		if (number < 2 || number % 2 == 0)
			return false;

		int standard = (int)Math.floor(Math.sqrt(number));

		for (int i = 3; i <= standard; i += 2) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

}
