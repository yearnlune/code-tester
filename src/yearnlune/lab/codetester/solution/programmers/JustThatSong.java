package yearnlune.lab.codetester.solution.programmers;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.04.15
 * DESCRIPTION : https://programmers.co.kr/learn/courses/30/lessons/17683
 */
public class JustThatSong implements SolutionBase {

	@Override
	public Object setUp() {
		String m = "CC#BCC#BCC#BCC#B";
		String[] musicInfos = {"13:55,14:00,FOO,CC#B", "04:01,04:08,BAR,CC#BCC#BCC#B"};
		return solution(m, musicInfos);
	}

    @MainFunction
	public String solution(String m, String[] musicInfos) {
		String answer = "(None)";
		int longer = Integer.MIN_VALUE;
		m = replaceKeySignature(m);

		for (String musicInfo : musicInfos) {
			String[] music = musicInfo.split(",");
			int startTime = convertMinutes(music[0]);
			int endTime = convertMinutes(music[1]);
			int runningTime = endTime - startTime;
			String musicName = music[2];
			String musicKeySignature = replaceKeySignature(music[3]);
			int musicKeySignatureLength = musicKeySignature.length();
			String total = "";

			if (longer >= runningTime) {
				continue;
			}

			for (int i = 0; i < runningTime; i++) {
				total += musicKeySignature.charAt(i % musicKeySignatureLength);
				if (i + 1 < runningTime &&
					musicKeySignature.charAt((i + 1) % musicKeySignatureLength) == '#') {
					total += musicKeySignature.charAt((++i) % musicKeySignatureLength);
				}
			}

			int startIndex = total.indexOf(m);
			if (startIndex > -1) {
				longer = runningTime;
				answer = musicName;
			}
		}

		return answer;
	}

	private int convertMinutes(String time) {
		String[] temp = time.split(":");
		return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
	}

	private String replaceKeySignature(String raw) {
		raw = raw.replaceAll("C#", "Z");
		raw = raw.replaceAll("D#", "Y");
		raw = raw.replaceAll("F#", "X");
		raw = raw.replaceAll("G#", "W");
		raw = raw.replaceAll("A#", "V");

		return raw;
	}
}
