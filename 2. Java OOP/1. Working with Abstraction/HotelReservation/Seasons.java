package HotelReservation;

public enum Seasons {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int priceMultiplier;

    Seasons(int priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public double multipliedPrice(double price) {
        return price * this.priceMultiplier;
    }

    public int getPriceMultiplier() {
        return this.priceMultiplier;
    }
}
