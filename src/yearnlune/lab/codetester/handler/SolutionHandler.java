package yearnlune.lab.codetester.handler;

import yearnlune.lab.codetester.solution.Solution;
import yearnlune.lab.codetester.solution.codility.*;
import yearnlune.lab.codetester.solution.programmers.*;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.15
 * DESCRIPTION :
 */
public class SolutionHandler {

    HashMap<String, SolutionMeta> solutionFactory = new HashMap<>();

    public SolutionHandler() {
        setUp();
    }

    public void setUp() {
        registerSolution(BinaryGap.class, "solution");
        registerSolution(Brackets.class, "solution");
        registerSolution(CountDiv.class, "solution");
        registerSolution(CyclicRotation.class, "solution");
        registerSolution(MaxCounters.class, "solution");
        registerSolution(MaxProductOfThree.class, "solution");
        registerSolution(PermMissingElem.class, "solution");
        registerSolution(CompletedPlayerYet.class, "solution");
        registerSolution(PhoneNumberList.class, "solution");
        registerSolution(KthNumber.class, "solution");
        registerSolution(PracticeTest.class, "solution");
        registerSolution(GymSuit.class, "solution");
        registerSolution(SelectTwoNumberAndThenAdd.class, "solution");
        registerSolution(TruckPassingTheBridge.class, "solution");
        registerSolution(CustomStringSort.class, "solution");
        registerSolution(JadenCase.class, "solution");
        registerSolution(CandidateKey.class, "solution");
        registerSolution(FindPrimeNumber.class, "solution");
        registerSolution(MoreSpicy.class, "solution");
        registerSolution(FindPrimeNumberCount.class, "solution");
        registerSolution(StringCompression.class, "solution");
        registerSolution(DecimalGame.class, "solution");
        registerSolution(JustThatSong.class, "solution");
        registerSolution(BigNumber.class, "solution");
        registerSolution(GameFestival.class, "solution");
        registerSolution(OneTwoFour.class, "solution");
        registerSolution(CaesarPassword.class, "solution");
        registerSolution(CorrectParenthesis.class, "solution");
        registerSolution(ParenthesisRotation.class, "solution");
        registerSolution(EvenAndOdd.class, "solution");
        registerSolution(UniqueNumber.class, "solution");
        registerSolution(PyChecker.class, "solution");
        registerSolution(TheLeastCommonMultiple.class, "solution");
        registerSolution(OddOccurrencesInArray.class, "solution");
        registerSolution(FrogJmp.class, "solution");
        registerSolution(MissingInteger.class, "solution");
        registerSolution(GenomicRangeQuery.class, "solution");
        registerSolution(Distinct.class, "solution");
    }

    private <T extends Solution> void registerSolution(Class<T> solution, String methodName) {
        String solutionName = solution.getSimpleName();

        solutionFactory.computeIfAbsent(solutionName, s -> {
            return SolutionMeta.builder()
                    .solution(solution)
                    .solutionMethod(findMethod(solution, methodName))
                    .build();
        });
    }

    private <T> Method findMethod(Class<T> solution, String methodName) {
        Method solutionMethod = null;
        Method[] methods = solution.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                solutionMethod = method;
            }
        }

        return solutionMethod;
    }

    public String solution(String solutionName) {
        String output = "";
        SolutionMeta solutionMeta = solutionFactory.get(solutionName);
        try {
            Solution solution = solutionMeta.getSolution().newInstance();
            output = toString(solution.setUp());
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return output;
    }

    public <T> String toString(T t) {
        StringBuilder stringBuilder = new StringBuilder();
        Class tClass = t.getClass();

        if (tClass.isPrimitive()) {
            stringBuilder.append(t);
        } else if (tClass.isArray()) {
            if (t instanceof Object[]) {
                stringBuilder.append(Arrays.deepToString((Object[]) t));
            } else {
                int tLength = Array.getLength(t);
                Object[] output = new Object[tLength];

                for (int i = 0; i < tLength; ++i) {
                    output[i] = Array.get(t, i);
                }

                stringBuilder.append(Arrays.toString(output));
            }
        } else {
            System.out.println("OUTPUT TYPE: " + tClass.getSimpleName());
            stringBuilder.append(t.toString());
        }

        return stringBuilder.toString();
    }

    public static class SolutionMeta {
        private Class<? extends Solution> solution;

        private Method solutionMethod;

        public SolutionMeta() {
        }

        public SolutionMeta(Builder builder) {
            this.solution = builder.solution;
            this.solutionMethod = builder.solutionMethod;
        }

        public Class<? extends Solution> getSolution() {
            return solution;
        }

        public Method getSolutionMethod() {
            return solutionMethod;
        }

        public String getSolutionMethodName() {
            return solutionMethod.getName();
        }

        public List<?> getSolutionMethodParameterList() {
            return Arrays.stream(solutionMethod.getParameterTypes()).collect(Collectors.toList());
        }

        public Object getSolutionMethodReturnValue() {
            return solutionMethod.getReturnType();
        }

        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            private Class<? extends Solution> solution;

            private Method solutionMethod;

            public Builder solution(Class<? extends Solution> solution) {
                this.solution = solution;
                return this;
            }

            public Builder solutionMethod(Method solutionMethod) {
                this.solutionMethod = solutionMethod;
                return this;
            }

            public SolutionMeta build() {
                return new SolutionMeta(this);
            }
        }

    }
}
