package L_6_Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String nameDriver = reader.readLine();

        Ferrari ferrari = new Ferrari(nameDriver);

        System.out.println(ferrari.toString());
    }
}
