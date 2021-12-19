package HotelReservation;

public class Reservation {
    private double pricePerDays;
    private int numberOfDays;
    private Seasons seasons;
    private DiscountType discountType;
    public Reservation(
            double pricePerDays,
            int numberOfDays,
            Seasons seasons,
            DiscountType discountType
    ){
        this.pricePerDays = pricePerDays;
        this.numberOfDays = numberOfDays;
        this.seasons = seasons;
        this.discountType = discountType;
    }
    public double calculatePrice(){
        double bestPrice = pricePerDays * numberOfDays;
        bestPrice = seasons.multipliedPrice(bestPrice);
        bestPrice = discountType.discountFor(bestPrice);
        return bestPrice;
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "pricePerDays=" + pricePerDays +
                ", numberOfDays=" + numberOfDays +
                ", seasons=" + seasons +
                ", discountType=" + discountType +
                '}';
    }
}
