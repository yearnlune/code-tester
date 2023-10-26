package yearnlune.lab.codetester.solution.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * Date : 2023.10.16
 * Description : https://school.programmers.co.kr/learn/courses/30/lessons/152996
 */
public class SeesawPartner implements SolutionBase {
    @Override
    public Object setUp() {
        int[] weights = {100, 100, 270, 180, 360};
        return solution(weights);
    }

    @MainFunction
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> m = new HashMap<>();

        Arrays.sort(weights);

        for (int weight : weights) {
            Double computedWeight = Integer.valueOf(weight).doubleValue();
            m.compute(computedWeight, (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            });
        }

        for (double weight : weights) {
            if (m.containsKey(weight) && m.get(weight) > 1) {
                answer += m.get(weight) - 1;
                m.put(weight, m.get(weight) - 1);
            }
            if (m.containsKey(weight * 3 / 2)) {
                answer += (m.get(weight * 3 / 2));
            }
            if (m.containsKey(weight * 4 / 2)) {
                answer += (m.get(weight * 4 / 2));
            }
            if (m.containsKey(weight * 4 / 3)) {
                answer += (m.get(weight * 4 / 3));
            }
        }

        return answer;
    }
}
