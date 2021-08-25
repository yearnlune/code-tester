package yearnlune.lab.codetester;

import yearnlune.lab.codetester.handler.SolutionHandler;

public class Main {
	public static void main(String[] args) {
	    if (args.length < 1) {
            System.err.println("INSERT 'SOLUTION CLASS NAME' INTO ARGUMENT");
        } else {
            test(args[0]);
        }
	}

	public static void test(String solutionName) {
		StringBuilder stringBuilder = new StringBuilder();
		String answerString = "";

		SolutionHandler solutionHandler = new SolutionHandler();
		answerString = solutionHandler.solution(solutionName);

		stringBuilder.append("# SOLVE : ");
		stringBuilder.append(answerString);
		stringBuilder.append("\n");

		System.out.println(stringBuilder.toString());
	}

}
