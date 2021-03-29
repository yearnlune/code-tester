package yearnlune.lab.codetester.solution.programmers;

import java.util.HashSet;
import java.util.Set;

import yearnlune.lab.codetester.solution.Solution;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.29
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/42890
 */
public class CandidateKey implements Solution {
	String[][] relation;
	Set<String> candidateHashSet = new HashSet<>();

	@Override
	public Object setUp() {
		String[][] relation = {
			{"1", "1", "2", "3", "4"},
			{"1", "1", "3", "3", "5"},
			{"2", "1", "3", "3", "5"}
		};

		return solution(relation);
	}

	public int solution(String[][] relation) {
		this.relation = relation;
		int maxColumnLength = relation[0].length;
		int[] columnsIndex = new int[maxColumnLength];

		for (int column = 0; column < maxColumnLength; column++) {
			columnsIndex[column] = column;
		}

		for (int candidateSize = 1; candidateSize <= maxColumnLength; candidateSize++) {
			boolean[] isVisit = new boolean[maxColumnLength];
			findCandidate(columnsIndex, isVisit, 0, candidateSize, candidateSize);
		}

		return candidateHashSet.size();
	}

	private void findCandidate(int[] candidates, boolean[] visited, int startIndex, int standardLength, int currentLength) {
		if (currentLength == 0) {
			Integer[] candidateCase = new Integer[standardLength];
			String candidateString = "";

			int j = 0;
			for (int i = 0; i < candidates.length; i++) {
				if (visited[i]) {
					candidateCase[j++] = candidates[i];
					candidateString += candidates[i];
				}
			}

			for (String candidate : candidateHashSet) {
				int count = 0;
				for (int i = 0; i < candidateCase.length; i++) {
					if (candidate.contains(String.valueOf(candidateCase[i]))) {
						count++;
					}
				}

				if (count == candidate.length()) {
					return;
				}
			}

			Set<String> hashSet = new HashSet<>();
			for (int row = 0; row < this.relation.length; row++) {
				String tuple = "";
				for (int candidate = 0; candidate < standardLength; candidate++) {
					tuple += this.relation[row][candidateCase[candidate]];
				}
				hashSet.add(tuple);
			}

			if (hashSet.size() == this.relation.length) {
				this.candidateHashSet.add(candidateString);
			}
		} else {
			for (int i = startIndex; i < candidates.length; i++) {
				visited[i] = true;
				findCandidate(candidates, visited, i + 1, standardLength, currentLength - 1);
				visited[i] = false;
			}
		}
	}

}
