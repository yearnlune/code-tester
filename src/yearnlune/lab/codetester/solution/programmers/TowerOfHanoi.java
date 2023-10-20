package yearnlune.lab.codetester.solution.programmers;

import java.util.ArrayList;
import java.util.List;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.10.19
 * DESCRIPTION : https://school.programmers.co.kr/learn/courses/30/lessons/12946
 */
public class TowerOfHanoi implements SolutionBase {
    @Override
    public Object setUp() {
        int n = 1;
        return solution(n);
    }

    @MainFunction
    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();
        move(n, 1, 2, 3, answer);
        return answer.toArray(int[][]::new);
    }

    public void move(int num, int from, int via, int to, List<int[]> answer) {
        if (num == 1) {
            answer.add(new int[] {from, to});
        } else {
            move(num - 1, from, to, via, answer);
            answer.add(new int[] {from, to});
            move(num - 1, via, from, to, answer);
        }
    }
}
