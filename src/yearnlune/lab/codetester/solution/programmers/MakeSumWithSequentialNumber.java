package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.02.28
 * DESCRIPTION : 연속된 숫자로 sum 구하기
 */
public class MakeSumWithSequentialNumber implements SolutionBase {
	@Override
	public Object setUp() {
		return null;
	}

    @MainFunction
	public int solution(int n) {
		int answer = 0;
		for (int startWith = 1; startWith <= n; startWith++) {
			int sum = 0;
			for (int idx = 0; idx < n - startWith + 1; idx++) {
				sum += (startWith + idx);
				if (sum == n) {
					answer++;
					break;
				}
				if (sum > n) {
					break;
				}
			}
		}

		return answer;
	}
}
