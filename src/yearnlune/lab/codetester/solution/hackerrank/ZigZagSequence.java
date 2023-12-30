package yearnlune.lab.codetester.solution.hackerrank;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

import java.util.Arrays;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2023.12.30
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-zig-zag-sequence/problem
 */
public class ZigZagSequence implements SolutionBase {
    @Override
    public Object setUp() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        int n = 7;
        return findZigZagSequence(a, n);
    }

    @MainFunction
    public Object findZigZagSequence(int[] a, int n) {
        Arrays.sort(a);
        int mid = n / 2;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;
        System.out.println(Arrays.toString(a));
        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
            System.out.println(Arrays.toString(a));
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
        //1 2 3 7 6 5 4
        return "";
    }
}
