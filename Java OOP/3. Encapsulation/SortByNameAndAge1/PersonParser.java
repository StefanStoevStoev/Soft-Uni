package SortByNameAndAge1;

public class PersonParser {

    public static Person personFrom(String string){
        String[] input = string.split("\\s+");

        String firstName = input[0];
        String lastName = input[1];
        int age = Integer.valueOf(input[2]);
        return new Person(firstName,lastName,age);
    }

    public static void main(String[] args) {

        Person p = PersonParser.personFrom("Asen Ivanov 65");
        System.out.println(p);
    }
}
