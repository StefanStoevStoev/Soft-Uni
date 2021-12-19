package greedyTimes;

public class Bag {
    private Gold gold;
    private CashContainer cashContainer;
    private GemConteiner gemConteiner;

    private long capacity;
    public Bag(long capacity){
        this.gold = new Gold();
        this.cashContainer = new CashContainer();
        this.gemConteiner = new GemConteiner();
        this.capacity = capacity;
    }

    public boolean hasRoomFor(Long value) {
        return value + getCurrentSize() <= capacity;
    }

    private Long getCurrentSize() {
        long size = this.gold.getValue();
        size += this.cashContainer.getSize();
        size += this.gemConteiner.getSize();
        return size;
    }
    public void addGold(long value){
        this.gold.addValue(value);
    }
    public void addCash(long value){
        if(this.gold.getValue()>=this.cashContainer.getSize() + value);
    }
}
