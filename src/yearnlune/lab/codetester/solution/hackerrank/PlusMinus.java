package yearnlune.lab.codetester.solution.hackerrank;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.30
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/
 */
public class PlusMinus implements SolutionBase {
    @Override
    public Object setUp() {
        try {
            return solution();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @MainFunction
    public Object solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        plusMinus(arr);

        bufferedReader.close();
        return "";
    }

    public void plusMinus(List<Integer> arr) {
        int[] d = {0, 0, 0};
        for (Integer n : arr) {
            if (n > 0) {
                d[0]++;
            } else if (n < 0) {
                d[1]++;
            } else {
                d[2]++;
            }
        }

        System.out.println(String.format("%.5f", ((double) d[0] / arr.size())));
        System.out.println(String.format("%.5f", ((double) d[1] / arr.size())));
        System.out.println(String.format("%.5f", ((double) d[2] / arr.size())));
    }
}
