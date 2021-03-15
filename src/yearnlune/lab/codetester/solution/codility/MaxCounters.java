package yearnlune.lab.codetester.solution.codility;

import java.util.Arrays;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.02.28
 * DESCRIPTION : https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
 */
public class MaxCounters implements Solution {

	@Override
	public Object setUp() {
		return null;
	}

	public int[] solution(int N, int[] A) {
		int M = A.length;
		int[] counters = new int[N];
		int maxCount = 0;
		int standardCount = 0;

		for (int K = 0; K < M; K++) {
			int X = A[K];
			if (X < N + 1) {
				int count = 0;
				if (counters[X - 1] < standardCount) {
					count = standardCount + 1;
					counters[X - 1] = count;
					System.out.println("standardCount #" + K + " count: " + count);
				} else {
					count = ++counters[X - 1];
					System.out.println("increasedCount #" + K + " count: " + count);
				}
				maxCount = Math.max(maxCount, count);
			} else {
				standardCount = maxCount;
				System.out.println("sync #" + K + " standardCount: " + standardCount + " maxCount: "
					+ maxCount);
			}
			System.out.println(
				"#" + K + " " + Arrays.toString(counters) + " standardCount: " + standardCount + " maxCount: "
					+ maxCount);
		}

		for (int i = 0; i < N; i++) {
			if (counters[i] < standardCount) {
				counters[i] = standardCount;
			}
		}
		System.out.println("#TOTAL " + Arrays.toString(counters));
		return counters;
	}
}
