package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.solution.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.24
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/12910
 */
public class Divisor implements Solution {
    @Override
    public Object setUp() {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
        return solution(arr, divisor);
    }

    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr);

        for (int number : arr) {
            if (number % divisor == 0) {
                answer.add(number);
            }
        }

        if (answer.isEmpty()) {
            answer.add(-1);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
