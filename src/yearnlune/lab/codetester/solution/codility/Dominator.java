package yearnlune.lab.codetester.solution.codility;

import java.util.HashMap;
import java.util.Map;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.20
 * DESCRIPTION : https://app.codility.com/programmers/lessons/8-leader/dominator/
 */
public class Dominator implements SolutionBase {
    @Override
    public Object setUp() {
        int[] A = {2, 1, 1, 3};

        return solution(A);
    }

    @MainFunction
    public int solution(int[] A) {
        Map<Integer, Integer> votes = new HashMap<>();
        Map<Integer, Integer> leaders = new HashMap<>();
        int candidate = 0;
        int maxCount = 0;

        for (int i = 0; i < A.length; i++) {
            int vote = A[i];
            int count = votes.getOrDefault(vote, 0) + 1;
            votes.put(vote, count);
            leaders.putIfAbsent(vote, i);

            if (count > maxCount) {
                candidate = vote;
                maxCount = count;
            }
        }

        return A.length > 0 && maxCount * 2 > A.length ? leaders.get(candidate) : -1;
    }
}
