package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        InputDataReservaion parser = new InputDataReservaion();
        Reservation reservation = parser.parseFromLine(line);

        double price = reservation.calculatePrice();
        Printer printer = new Printer(System.out);

        printer.printDoubleRounder(price);
    }
}
