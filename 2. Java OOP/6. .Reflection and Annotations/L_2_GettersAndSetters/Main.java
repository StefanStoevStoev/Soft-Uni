package L_2_GettersAndSetters;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

    public static class MethodComparator implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        Class<?> aClass = Class.forName("L_2_GettersAndSetters.Reflection");

        Method[] methods = aClass.getDeclaredMethods();

        Set<Method> geters = new TreeSet<>(new MethodComparator());
        Set<Method> seters = new TreeSet<>(new MethodComparator());

        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                geters.add(method);
            } else if (method.getName().startsWith("set")) {
                seters.add(method);
            }
        }
        System.out.println(geters.stream()
                .map(g -> String.format("%s will return class %s",
                        g.getName(), g.getReturnType().getName().replace("class", "")))
                .collect(Collectors.joining(System.lineSeparator()))
        );
        System.out.println(seters.stream()
                .map(s -> String.format("%s and will set field of class %s",
                        s.getName(), s.getParameterTypes()[0]
                                .getName().replace("class", "")))
                .collect(Collectors.joining(System.lineSeparator()))
        );
    }
}
