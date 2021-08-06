package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.08.06
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/82612
 */
public class CalculateInsufficientAmount implements Solution {

    @Override
    public Object setUp() {
        int price = 3;
        int money = 20;
        int count = 4;

        return solution(price, money, count);
    }

    public long solution(int price, int money, int count) {
        long answer = 0;
        long totalCost = 0;

        for (int i = 1; i <= count; i++) {
            totalCost += ((long) price * i);
        }

        long insufficientAmount = money - totalCost;

        if (insufficientAmount < 0) {
            answer = -insufficientAmount;
        }

        return answer;
    }
}
