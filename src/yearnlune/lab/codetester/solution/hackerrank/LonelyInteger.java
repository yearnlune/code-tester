package yearnlune.lab.codetester.solution.hackerrank;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.30
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-lonely-integer/
 */
public class LonelyInteger implements SolutionBase {
    @Override
    public Object setUp() {
        try {
            return solution();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @MainFunction
    public int solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        bufferedReader.close();
        return lonelyinteger(a);
    }

    public int lonelyinteger(List<Integer> a) {
        // Write your code here
        Map<Integer, Integer> m = new HashMap<>();
        for (Integer i : a) {
            m.compute(i, (k, v) -> {
                int value = 1;
                if (v != null) {
                    value = value + v;
                }
                return value;
            });
        }

        return m.keySet().stream().filter((key) -> m.get(key) != null && m.get(key) == 1).findFirst().get();
    }
}
