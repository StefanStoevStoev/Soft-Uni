package E_1_HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);


		String input = scan.nextLine();

		while (!input.equals("HARVEST")){
			Field[] fields = RichSoilLand.class.getDeclaredFields();
			if (input.equals("protected")){

				Arrays.stream(fields)
						.filter(f -> Modifier.isProtected(f.getModifiers()))
						.forEach(f -> System.out.printf("protected %s %s%n", f.getType().getSimpleName(),f.getName()));

			} else if (input.equals("private")){
				Arrays.stream(fields)
						.filter(f -> Modifier.isPrivate(f.getModifiers()))
						.forEach(f -> System.out.printf("private %s %s%n"
								, f.getType().getSimpleName()
								,f.getName()));

			} else if (input.equals("public")){
				Arrays.stream(fields)
						.filter(f -> Modifier.isPublic(f.getModifiers()))
						.forEach(f -> System.out.printf("public %s %s%n"
								, f.getType().getSimpleName()
								,f.getName()));
			} else {

				Arrays.stream(fields)
						.forEach(f -> System.out.printf("%s %s %s%n",
								Modifier.toString(f.getModifiers())
								, f.getType().getSimpleName()
								,f.getName()));
			}
			input = scan.nextLine();
		}
	}
}
