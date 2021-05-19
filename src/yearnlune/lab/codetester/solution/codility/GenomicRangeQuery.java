package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.solution.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.20
 * DESCRIPTION : https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/
 */
public class GenomicRangeQuery implements Solution {
    @Override
    public Object setUp() {
        String S = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};

        return solution(S, P, Q);
    }

    public int[] solution(String S, int[] P, int[] Q) {
        final Map<Character, Integer> dnaMeta = initDnaMeta();
        int[] answer = new int[P.length];
        int[] counts = {0, 0, 0, 0};
        int[][] minCounts = new int[S.length()][counts.length];

        for (int i = 0; i < S.length(); i++) {
            counts[dnaMeta.get(S.charAt(i))]++;
            for (int j = 0; j < counts.length; j++) {
                minCounts[i][j] = counts[j];
            }
        }

        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < counts.length; j++) {
                int endCount = minCounts[Q[i]][j];
                int startCount = 0;
                if (P[i] != 0) startCount = minCounts[P[i] - 1][j];

                if (endCount - startCount > 0) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }

    private Map<Character, Integer> initDnaMeta() {
        Map<Character, Integer> dna = new HashMap<>();
        dna.put('A', 0);
        dna.put('C', 1);
        dna.put('G', 2);
        dna.put('T', 3);

        return dna;
    }
}
