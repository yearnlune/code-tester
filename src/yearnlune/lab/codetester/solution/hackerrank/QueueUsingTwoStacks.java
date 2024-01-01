package yearnlune.lab.codetester.solution.hackerrank;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

import java.util.Scanner;
import java.util.Stack;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2024.1.1
 * DESCRIPTION : https://www.hackerrank.com/challenges/one-week-preparation-kit-merge-two-sorted-linked-lists/problem
 */
public class QueueUsingTwoStacks implements SolutionBase {
    @Override
    public Object setUp() {
        main();
        return "";
    }

    @MainFunction
    public void main() {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int q = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < q; i++) {
            String action = sc.nextLine();
            String[] tokens = action.split(" ");
            switch (tokens[0]) {
                case "1":
                    s1.push(Integer.parseInt(tokens[1]));
                    break;
                case "2":
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                    s2.pop();
                    while (!s2.isEmpty()) {
                        s1.push(s2.pop());
                    }
                    break;
                case "3":
                    System.out.println(s1.get(0));
                    break;
            }
        }
        sc.close();
    }
}
