package yearnlune.lab.codetester.solution.programmers;

import java.util.LinkedList;
import java.util.Queue;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.22
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class TruckPassingTheBridge implements SolutionBase {
	@Override
	public Object setUp() {
		int bridgeLength = 100;
		int weight = 100;
		int[] truckWeights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

		return solution(bridgeLength, weight, truckWeights);
	}

    @MainFunction
	public int solution(int bridgeLength, int weight, int[] truckWeights) {
		int answer = 0;
		int passedTruckCount = 0;
		int currentWeight = 0;
		Queue<Integer> queue = new LinkedList<>();

		int i = 0;
		while (passedTruckCount < truckWeights.length) {
			answer++;
			int candidateTruck = 0;

			if (i < truckWeights.length) {
				candidateTruck = truckWeights[i];
			}

			if (queue.size() == bridgeLength) {
				int passedTruck = queue.poll();
				if (passedTruck != 0) {
					currentWeight -= passedTruck;
					passedTruckCount++;
				}
			}

			if (currentWeight + candidateTruck <= weight) {
				queue.add(candidateTruck);
				currentWeight += candidateTruck;
				i++;
			} else {
				queue.add(0);
			}
		}
		return answer;
	}
}
