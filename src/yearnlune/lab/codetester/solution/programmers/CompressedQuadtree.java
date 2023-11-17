package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * Date : 2023.10.16
 * Description : https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */
public class CompressedQuadtree implements SolutionBase {
    @Override
    public Object setUp() {
        int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1},
            {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1},
            {0, 0, 0, 0, 1, 1, 1, 1}};
        return solution(arr);
    }

    @MainFunction
    public int[] solution(int[][] arr) {
        int[] answer = {0, 0};
        int x = 0;
        int y = 0;

        return calc(x, y, arr.length, arr, answer);
    }

    int[] calc(int x, int y, int len, int[][] arr, int[] answer) {
        int candidate = 0;
        int count = 0;
        boolean comp = true;

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                candidate += arr[i][j];
                count++;
                if (candidate % count != 0) {
                    comp = false;
                    break;
                }
            }
        }

        if (comp) {
            if (candidate == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        } else {
            answer = calc(x, y, len / 2, arr, answer);
            answer = calc(x + len / 2, y, len / 2, arr, answer);
            answer = calc(x, y + len / 2, len / 2, arr, answer);
            answer = calc(x + len / 2, y + len / 2, len / 2, arr, answer);
        }

        return answer;
    }
}
