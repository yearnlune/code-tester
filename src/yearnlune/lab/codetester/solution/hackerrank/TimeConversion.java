package yearnlune.lab.codetester.solution.hackerrank;

import yearnlune.lab.codetester.handler.MainFunction;
import yearnlune.lab.codetester.solution.SolutionBase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConversion implements SolutionBase {
    @Override
    public Object setUp() {
        try {
            return solution();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @MainFunction
    public Object solution() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        System.out.println(timeConversion(s));

        bufferedReader.close();

        return "";
    }

    public String timeConversion(String s) {
        String regex = "(\\d+):(\\d+):(\\d+)(PM|AM)";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(s);
        int hour = 0;
        int minute = 0;
        int seconds = 0;
        String meridiem = "";
        if (matcher.find()) {
            hour = Integer.parseInt(matcher.group(1));
            minute = Integer.parseInt(matcher.group(2));
            seconds = Integer.parseInt(matcher.group(3));
            meridiem = matcher.group(4);

            if (hour >= 12 && meridiem.equals("AM")) {
                hour %= 12;
            } else if (hour < 12 && meridiem.equals("PM")) {
                hour += 12;
            }
        }
        return String.format("%02d:%02d:%02d%n", hour, minute, seconds);
    }
}
