package yearnlune.lab.codetester.solution.programmers;

import java.util.PriorityQueue;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.04.01
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class MoreSpicy implements SolutionBase {
	@Override
	public Object setUp() {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 711;

		return solution(scoville, k);
	}

    @MainFunction
	public int solution(int[] scovilles, int k) {
		int answer = -1;
		int min = 0;
		PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();

		for (int scoville : scovilles) {
			scovilleQueue.offer(scoville);
		}

		int i = 0;
		while (min < k && scovilleQueue.size() > 1) {
			int first = scovilleQueue.poll();
			int second = 0;

			if (!scovilleQueue.isEmpty()) {
				second = scovilleQueue.poll();
			}
			scovilleQueue.offer(mix(first, second));

			min = scovilleQueue.peek();
		}

		if (min >= k) {
			answer = scovilles.length - scovilleQueue.size();
		}

		return answer;
	}

	int mix(int first, int second) {
		return first + (second * 2);
	}
}
