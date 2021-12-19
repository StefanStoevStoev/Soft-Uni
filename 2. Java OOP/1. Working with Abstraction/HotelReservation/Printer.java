package HotelReservation;

import java.io.PrintStream;

public class Printer {
    private PrintStream out;

    public Printer(PrintStream out){

        this.out = out;
    }

    public void printLine(String line){
        out.println(line);
    }
    public void printDoubleRounder(double dbl){
        String rounderDouble = String.format("%.2f",dbl);
        out.println(rounderDouble);
    }
}
