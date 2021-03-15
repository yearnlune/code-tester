package yearnlune.lab.codetester.handler;

import java.util.Arrays;
import java.util.Random;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.02.27
 * DESCRIPTION :
 */
public class RandomHandler {

	public static int createRandomInteger(boolean isOnlyPositive) {
		Random random = new Random();

		return isOnlyPositive ? random.nextInt(Integer.MAX_VALUE) : random.nextInt();
	}

	public static int[] createRandomIntegerArray(Integer maxLength, boolean isOnlyPositive) {
		int arrayLength = (int)(Math.random() * maxLength);

		Random random = new Random();

		int[] randomIntegerArray = new int[arrayLength];

		for (int i = 0; i < arrayLength; i++) {
			if (isOnlyPositive) {
				randomIntegerArray[i] = random.nextInt(Integer.MAX_VALUE);
			} else {
				randomIntegerArray[i] = random.nextInt();
			}
		}
		System.out.println("randomIntegerArray: " + Arrays.toString(randomIntegerArray));
		return randomIntegerArray;
	}

	public static int[] createRandomIntegerArrayBetweenEqual(Integer maxLength, int min, int max) {
		int arrayLength = new Random().nextInt(maxLength) + 3;

		int[] randomIntegerArray = new int[arrayLength];

		for (int i = 0; i < arrayLength; i++) {
			randomIntegerArray[i] = createRandomIntegerBetweenEqual(min, max);
		}
		System.out.println("randomIntegerArray: " + Arrays.toString(randomIntegerArray));
		return randomIntegerArray;
	}

	public static int createRandomIntegerBetweenEqual(int min, int max) {
		return new Random().nextInt(max - min + 1) + min;
	}

}
