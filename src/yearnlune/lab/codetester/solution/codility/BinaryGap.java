package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.02.27
 * DESCRIPTION : https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
 */
public class BinaryGap implements SolutionBase {

	@Override
	public Object setUp() {
		int N = 10;
		return solution(N);
	}

	@MainFunction
	public int solution(int N) {
		int solutionValue = 0;
		String binaryString = Integer.toBinaryString(N);

		if (hasBinaryGap(binaryString)) {
			solutionValue = calculateBinaryGap(N ,binaryString);
		}

		return solutionValue;
	}

	public boolean hasBinaryGap(String binaryString) {
		return binaryString.matches("[01]*10+1[01]*");
	}

	public int calculateBinaryGap(int N, String binaryString) {
		int maxLength = 0;

		String[] binaryGaps = binaryString.split("1");

		if (N % 2 == 0) {
			binaryGaps[binaryGaps.length - 1] = "";
		}

		for (String binaryGap : binaryGaps) {
			maxLength = Math.max(maxLength, binaryGap.length());
		}

		return maxLength;
	}
}
