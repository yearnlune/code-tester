package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.22
 * DESCRIPTION : https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/
 */
public class CountFactors implements SolutionBase {
    @Override
    public Object setUp() {
        int N = Integer.MAX_VALUE;
        return solution(N);
    }

    @MainFunction
    public int solution(int N) {
        int answer = 0;
        for (long i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                answer++;
                if (N / i != i) answer++;
            }
        }
        return answer;
    }
}
