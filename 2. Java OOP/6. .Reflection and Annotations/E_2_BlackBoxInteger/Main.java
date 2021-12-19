package E_2_BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        BlackBoxInt blackBoxInt;

        Constructor<?> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        blackBoxInt = (BlackBoxInt)constructor.newInstance();;

        Map<String, Method> methodMap = Arrays.stream(blackBoxInt.getClass().getDeclaredMethods())
                .peek(m -> m.setAccessible(true))
                .collect(Collectors.toMap(Method::getName, m -> m));

        while (!input.equals("END")){

            String[] tokens = input.split("_");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            Method method = methodMap.get(command);

            method.invoke(blackBoxInt, number);

            Field innerValue = BlackBoxInt.class.getDeclaredField("innerValue");

            innerValue.setAccessible(true);

            int value = (int) innerValue.get(blackBoxInt);

            System.out.println(value);

            input = scan.nextLine();
        }
    }
}
