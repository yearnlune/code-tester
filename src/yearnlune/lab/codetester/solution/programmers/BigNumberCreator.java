package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

import java.util.Stack;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.10.25
 * DESCRIPTION : https://school.programmers.co.kr/learn/courses/30/lessons/42883
 * <p>
 * GREEDY
 */
public class BigNumberCreator implements SolutionBase {

    @Override
    public Object setUp() {
        String number = "4177252841";
        int k = 4;
        return solution(number, k);
    }

    @MainFunction
    public String solution(String number, int k) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            char candidate = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < candidate && count < k) {
                stack.pop();
                count++;
            }
            if (number.length() - k > stack.size()) {
                stack.push(candidate);
            }
        }

        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }
}
