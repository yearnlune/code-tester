package yearnlune.lab.codetester.handler;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import yearnlune.lab.codetester.solution.SolutionBase;

/**
 * Project : code-tester
 * Created by IntelliJ IDEA
 * Author : DONGHWAN, KIM
 * DATE : 2021.03.15
 * DESCRIPTION :
 */
public class SolutionHandler {

    private static final String CLASS_FILE_SUFFIX = ".class";

    private static final String ROOT_PACKAGE = "yearnlune.lab.codetester.solution";

    private static final Class<? extends Annotation> MAIN_FUNCTION_ANNOTATION_CLASS = MainFunction.class;

    private final HashMap<String, SolutionMeta> solutionFactory = new HashMap<>();

    public SolutionHandler() {
        findClasses();
    }

    public String solution(String solutionName) {
        String output = "";
        SolutionMeta solutionMeta = solutionFactory.get(solutionName);
        try {
            if (solutionMeta.getSolution().getDeclaredConstructor().newInstance() instanceof SolutionBase solutionBase) {
				output = toString(solutionBase.setUp());
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Not found [" + solutionName + "] solution class");
        }
		return output;
    }

    public <T> String toString(T t) {
        StringBuilder stringBuilder = new StringBuilder();
        Class<?> tClass = t.getClass();

        if (tClass.isPrimitive()) {
            stringBuilder.append(t);
        } else if (tClass.isArray()) {
            if (t instanceof Object[]) {
                stringBuilder.append(Arrays.deepToString((Object[])t));
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
            stringBuilder.append(t);
        }

        return stringBuilder.toString();
    }

    private void findClasses() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = ROOT_PACKAGE.replace('.', '/');
        Enumeration<URL> resources;

        try {
            resources = classLoader.getResources(path);
            List<File> directories = new ArrayList<>();

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                directories.add(new File(resource.getFile()));
            }

            for (File directory : directories) {
                findClassesByFile(directory, ROOT_PACKAGE);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void findClassesByFile(File directory, String packageName) throws ClassNotFoundException {
        if (!directory.exists()) {
            return;
        }

        File[] files = Optional.ofNullable(directory.listFiles()).orElse(new File[]{});

        for (File file : files) {
            if (file.isDirectory()) {
                findClassesByFile(file, packageName + "." + file.getName());
            } else if (file.getName().endsWith(CLASS_FILE_SUFFIX)) {
                Class<?> clazz = Class.forName(
                    packageName + '.' + file.getName().replaceAll("\\.class$", ""));
                getMainFunction(clazz);
            }
        }
    }

    private void getMainFunction(Class<?> clazz) {
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(MAIN_FUNCTION_ANNOTATION_CLASS)) {
                    registerSolution(clazz, method);
                }
            }
        }
    }

    private void registerSolution(Class<?> solution, String methodName) {
        registerSolution(solution, findMethod(solution, methodName));
    }

    private void registerSolution(Class<?> solution, Method method) {
        String solutionName = solution.getSimpleName();

        solutionFactory.computeIfAbsent(solutionName, s -> {
            SolutionMeta solutionMeta;

            solutionMeta = SolutionMeta.builder()
                .solution(solution)
                .solutionMethod(method)
                .build();

            return solutionMeta;
        });
    }

    private Method findMethod(Class<?> solution, String methodName) {
        Method solutionMethod = null;
        Method[] methods = solution.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                solutionMethod = method;
            }
        }

        return solutionMethod;
    }

    public static class SolutionMeta {

        private Class<?> solution;

        private Method solutionMethod;

        public SolutionMeta() {
        }

        public SolutionMeta(Builder builder) {
            this.solution = builder.solution;
            this.solutionMethod = builder.solutionMethod;
        }

        public Class<?> getSolution() {
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

            private Class<?> solution;

            private Method solutionMethod;

            public Builder solution(Class<?> solution) {
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
