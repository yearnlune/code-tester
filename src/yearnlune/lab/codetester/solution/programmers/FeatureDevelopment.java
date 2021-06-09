package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.solution.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.06.10
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42586
 */
public class FeatureDevelopment implements Solution {
    @Override
    public Object setUp() {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        return solution(progresses, speeds);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deployCounts = new ArrayList<>();
        LinkedList<Integer> estimatedDays = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            estimatedDays.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        int count = 1;
        int before = estimatedDays.pop();
        while (!estimatedDays.isEmpty()) {
            int estimatedDay = estimatedDays.pop();

            if (before < estimatedDay) {
                before = estimatedDay;
                deployCounts.add(count);
                count = 1;
            } else {
                count++;
                before = Math.max(before, estimatedDay);
            }
        }

        deployCounts.add(count);

        return deployCounts.stream().mapToInt(Integer::intValue).toArray();
    }
}
