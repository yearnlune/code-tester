package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.02.27
 * DESCRIPTION : https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
 */
public class PermMissingElem implements SolutionBase {

    @Override
    public Object setUp() {
        return solution(new int[] {1, 2, 3, 4, 5});
    }

    @MainFunction
    public int solution(int[] A) {
        int answer;
        int N = A.length;
        int total = 0;
        int max = 0;

        for (int i = 0; i < N; ++i) {
            max = Math.max(max, A[i]);
            total += A[i];
        }

        if (max != N + 1) {
            return N + 1;
        }

        int sequenceSum = calculateSequenceSum(max);
        answer = sequenceSum - total;
        return answer;
    }

    public int calculateSequenceSum(int value) {
        int sum = 0;
        for (int i = value; i > 0; --i) {
            sum += i;
        }
        return sum;
    }
}
