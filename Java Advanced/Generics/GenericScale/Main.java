package GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("a","c");
        System.out.println(stringScale.getHeavier());

        Scale<Integer> intScale = new Scale<>(1,2);
        System.out.println(intScale.getHeavier());

        Scale<Integer> ntScale = new Scale<>(1,1);
        System.out.println(ntScale.getHeavier());
    }
}
