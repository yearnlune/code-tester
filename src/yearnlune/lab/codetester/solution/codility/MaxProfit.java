package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.21
 * DESCRIPTION :
 */
public class MaxProfit implements Solution {
    @Override
    public Object setUp() {
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};

        return solution(A);
    }

    public int solution(int[] A) {
        int answer = 0;

        if (A.length < 2) return answer;

        int beforeMax = 0;
        for (int i = 1; i < A.length; i++) {
            int diff = A[i] - A[i - 1];
            beforeMax = Math.max(beforeMax + diff, diff);
            answer = Math.max(answer, beforeMax);
        }

        return answer;
    }
}
