package yearnlune.lab.codetester;

import yearnlune.lab.codetester.handler.SolutionHandler;

public class Main {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		StringBuilder stringBuilder = new StringBuilder();
		String answerString = "";

		SolutionHandler solutionHandler = new SolutionHandler();
		answerString = solutionHandler.solution("BinaryGap");

		stringBuilder.append("# SOLVE : ");
		stringBuilder.append(answerString);
		stringBuilder.append("\n");

		System.out.println(stringBuilder.toString());
	}

}
