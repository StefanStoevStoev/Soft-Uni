package FirstAndReserveTeam;

public class PersonParser {

    public static FirstAndReserveTeam.Person personFrom(String string){
        String[] input = string.split("\\s+");

        String firstName = input[0];
        String lastName = input[1];
        int age = Integer.valueOf(input[2]);
        double salary = Double.valueOf(input[3]);
        return new Person(firstName,lastName,age,salary);
    }
}
