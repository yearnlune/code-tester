package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.02.27
 * DESCRIPTION : https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
 */
public class CyclicRotation implements SolutionBase {

	@Override
	public Object setUp() {
		return solution(new int[]{1, 2}, 3);
	}

    @MainFunction
	public int[] solution(int[] A, int K) {
		int[] solve = new int[A.length];

		int totalSize = A.length;
		if (totalSize == 0) {
			return A;
		}

		int rotate = K % totalSize;
		if (rotate == 0) {
			return A;
		}

		int j = 0;
		for (int i = totalSize - rotate; i < totalSize; ++i) {
			solve[j++] = A[i];
		}

		for (int i = 0; i < totalSize - rotate; ++i) {
			solve[j++] = A[i];
		}

		return solve;
	}
}
