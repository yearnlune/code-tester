package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.02.28
 * DESCRIPTION : https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 */
public class MaxProductOfThree implements SolutionBase {

    @Override
    public Object setUp() {
        return solution(new int[] {1, 2, 3, 4, 5, 6});
    }

    @MainFunction
    public int solution(int[] A) {
        int N = A.length;

        int[] candidates;

        if (A.length > 6) {
            candidates = new int[6];

            int[] maxOfThree = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
            int[] minOfThree = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};

            for (int i = 0; i < N; i++) {
                int maxProduct = A[i];
                int minProduct = A[i];

                for (int j = 0; j < 3; j++) {
                    int prev = maxOfThree[j];

                    maxOfThree[j] = Math.max(maxOfThree[j], maxProduct);

                    if (prev != maxOfThree[j]) {
                        maxProduct = prev;
                    }
                }

                for (int j = 0; j < 3; j++) {
                    int prev = minOfThree[j];

                    minOfThree[j] = Math.min(minOfThree[j], minProduct);

                    if (prev != minOfThree[j]) {
                        minProduct = prev;
                    }
                }
            }

            for (int i = 0; i < 6; i++) {
                if (i < 3) {
                    candidates[i] = maxOfThree[i];
                } else {
                    candidates[i] = minOfThree[i - 3];
                }
            }

        } else {
            candidates = A;
        }
        return calculateMax(candidates);
    }

    public int calculateMax(int[] candidates) {
        int maxValue = Integer.MIN_VALUE;
        int candidatesLength = candidates.length;

        for (int i = 0; i < candidatesLength - 2; i++) {
            for (int j = i + 1; j < candidatesLength - 1; j++) {
                for (int k = j + 1; k < candidatesLength; k++) {
                    maxValue = Math.max(maxValue, candidates[i] * candidates[j] * candidates[k]);
                }
            }
        }

        return maxValue;
    }

    /* 0 2 0 6 1*/

}
