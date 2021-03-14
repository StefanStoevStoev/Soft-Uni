package E_5_Telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] callStr = reader.readLine().split("\\s+");
        String[] broseStr = reader.readLine().split("\\s+");
        List<String> callable = Arrays.asList(callStr.clone());
        List<String> browsable = Arrays.asList(broseStr.clone());

        Smartphone smartphone = new Smartphone(callable,browsable);
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
