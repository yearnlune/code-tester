package yearnlune.lab.codetester.solution.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.20
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class GymSuit implements SolutionBase {
	Map<Integer, Integer> reservedMap = new HashMap<>();
	int answer = 0;

	@Override
	public Object setUp() {
		int n = 3;
		int[] lost = {3};
		int[] reserve = {3};

		return solution(n, lost, reserve);
	}

    @MainFunction
	public int solution(int n, int[] lost, int[] reserve) {
		Map<Integer, Integer> lostMap = Arrays.stream(lost)
			.boxed()
			.collect(Collectors.toMap(key -> key, value -> 1));

		for (int i = 0; i < reserve.length; ++i) {
			if (lostMap.containsKey(reserve[i])) {
				lostMap.remove(reserve[i]);
				continue;
			}
			reservedMap.put(reserve[i], 1);
		}

		answer = n - lostMap.size();

		for (Integer lostGymSuit : lostMap.keySet()) {
			if (lendGymSuit(lostGymSuit - 1)) {
				continue;
			}
			lendGymSuit(lostGymSuit + 1);
		}

		return answer;
	}

	public boolean lendGymSuit(int lostGymSuit) {
		boolean isLent = false;
		if (reservedMap.containsKey(lostGymSuit)) {
			reservedMap.remove(lostGymSuit);
			answer++;
			isLent = true;
		}
		return isLent;
	}
}
