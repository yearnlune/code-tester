package yearnlune.lab.codetester.solution.hackerrank;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MiniMaxSum implements SolutionBase {
    @Override
    public Object setUp() {
        try {
            return solution();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @MainFunction
    public Object solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        miniMaxSum(arr);

        bufferedReader.close();
        return "";
    }

    public void miniMaxSum(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0L;
        for (Integer e : arr) {
            min = Math.min(min, e);
            max = Math.max(max, e);
            sum += e;
        }

        System.out.println((sum - max) + " " + (sum - min));
    }
}
