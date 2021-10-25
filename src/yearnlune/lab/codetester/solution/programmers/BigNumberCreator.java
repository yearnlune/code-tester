package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

import java.util.Stack;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.10.25
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42883
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
        int popCount = 0;
        char[] numbers = number.toCharArray();

        for (int i = 0; i < numbers.length; ++i) {
            char candidate = numbers[i];
            while (!stack.isEmpty() && stack.peek() < candidate && popCount < k) {
                popCount++;
                stack.pop();
            }

            if (number.length() - k > stack.size()) {
                stack.push(candidate);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            result += stack.get(i);
        }

        return result;
    }
}
