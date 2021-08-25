package yearnlune.lab.codetester.solution.codility;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.05.19
 * DESCRIPTION : https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/start/
 */
public class FrogJmp implements SolutionBase {
	@Override
	public Object setUp() {
		int X = 10;
		int Y = 85;
		int D = 30;

		return solution(X, Y, D);
	}

    @MainFunction
	public int solution(int X, int Y, int D) {
		return (Y-X) % D == 0 ? (Y-X) / D : (Y-X) / D + 1;
	}
}
