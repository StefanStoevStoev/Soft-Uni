package HotelReservation;

public class InputDataReservaion {
    public Reservation parseFromLine(String line){
        String[] split = line.split("\\s+");
        double pricePerDay = Double.valueOf(split[0]);
        int numberOfDays = Integer.valueOf(split[1]);
        Seasons seasons = Seasons.valueOf(split[2].toUpperCase());
        DiscountType discountType = DiscountType.valueOf(split[3].toUpperCase());
        return new Reservation(pricePerDay,numberOfDays,seasons,discountType);
    }
}
