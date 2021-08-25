package yearnlune.lab.codetester.solution.codility;

import java.util.HashSet;
import java.util.Set;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.20
 * DESCRIPTION : https://app.codility.com/programmers/lessons/6-sorting/
 */
public class Distinct implements SolutionBase {
    @Override
    public Object setUp() {
        int[] A = {2, 1, 1, 2, 3, 1};
        return solution(A);
    }

    @MainFunction
    public int solution(int[] A) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            uniqueNumbers.add(A[i]);
        }

        return uniqueNumbers.size();
    }
}
