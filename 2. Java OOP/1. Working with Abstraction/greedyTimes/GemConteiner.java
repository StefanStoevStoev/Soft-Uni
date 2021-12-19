package greedyTimes;

import java.util.LinkedHashMap;
import java.util.Map;

public class GemConteiner {
    private Map<String,Long> gems;

    public GemConteiner(){
        this.gems = new LinkedHashMap<>();
    }
    public Long getSize() {
        return this.gems
                .values()
                .stream()
                .mapToLong(e->e)
                .sum();
    }
}
