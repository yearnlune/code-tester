package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.solution.Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.20
 * DESCRIPTION : https://app.codility.com/programmers/lessons/6-sorting/
 */
public class Distinct implements Solution {
    @Override
    public Object setUp() {
        int[] A = {2, 1, 1, 2, 3, 1};
        return solution(A);
    }

    public int solution(int[] A) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            uniqueNumbers.add(A[i]);
        }

        return uniqueNumbers.size();
    }
}
