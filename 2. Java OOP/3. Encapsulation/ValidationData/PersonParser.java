package ValidationData;

public class PersonParser {

    public static Person personFrom(String string){
        String[] input = string.split("\\s+");

        String firstName = input[0];
        String lastName = input[1];
        int age = Integer.valueOf(input[2]);
        double salary = Double.valueOf(input[3]);
        return new Person(firstName,lastName,age,salary);
    }

    public static void main(String[] args) {

        try {
            Person p = PersonParser.personFrom("fdfd Ivanov -6 2200");
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
