package L_3_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static class FieldComparator implements Comparator<Field> {

        @Override
        public int compare(Field field, Field s) {
            return field.getName().compareTo(s.getName());
        }
    }
    public static class MethodComparator implements Comparator<Method> {

        @Override
        public int compare(Method f, Method s) {
            return f.getName().compareTo(s.getName());
        }
    }

    public static void main(String[] args) {


        Field[] fields = Reflection.class.getDeclaredFields();
        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted((Comparator.comparing(Field::getName)))
                .forEach(f -> System.out.printf("%s must be private!%n",f.getName()));

        Method[] geters = Reflection.class.getDeclaredMethods();
        Arrays.stream(geters)
                .filter(g -> !Modifier.isPublic(g.getModifiers()))
                .filter(g -> g.getName().startsWith("get"))
                .sorted((Comparator.comparing(Method::getName)))
                .forEach(gg -> System.out.printf("%s have to be public!%n",gg.getName()));

        Method[] seters = Reflection.class.getDeclaredMethods();
        Arrays.stream(seters)
                .filter(g -> Modifier.isPublic(g.getModifiers()))
                .filter(g -> g.getName().startsWith("set"))
                .sorted((Comparator.comparing(Method::getName)))
                .forEach(gg -> System.out.printf("%s have to be private!%n",gg.getName()));
    }
}
