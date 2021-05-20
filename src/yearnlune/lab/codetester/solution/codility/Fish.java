package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.solution.Solution;

import java.util.Stack;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.20
 * DESCRIPTION : https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/
 */
public class Fish implements Solution {
    @Override
    public Object setUp() {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {0, 1, 0, 0, 0};

        return solution(A, B);
    }

    public int solution(int[] A, int[] B) {
        int upFishCount = 0;
        Stack<Integer> downFish = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) downFish.push(i);
            else {
                while (!downFish.isEmpty()) {
                    if (A[i] > A[downFish.peek()]) downFish.pop();
                    else break;
                }
                if (downFish.isEmpty()) upFishCount++;
            }
        }

        return upFishCount + downFish.size();
    }
}
