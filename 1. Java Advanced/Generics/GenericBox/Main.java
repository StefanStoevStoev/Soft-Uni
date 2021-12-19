import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int h = 0; h < n; h++) {
            String token = scan.nextLine();
            Box box = new Box(token);

            System.out.println(box.toString());
        }
    }
}
