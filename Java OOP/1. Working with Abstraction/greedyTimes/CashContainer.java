package greedyTimes;

import java.util.LinkedHashMap;
import java.util.Map;

public class CashContainer {
    private Map<String,Long> cash;

    public CashContainer(){
        this.cash = new LinkedHashMap<>();
    }

    public Long getSize() {
        return this.cash
                .values()
                .stream()
                .mapToLong(e->e)
                .sum();
    }
}
