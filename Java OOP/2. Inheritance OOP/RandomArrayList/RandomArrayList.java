package RandomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList<String> {

    private Random random;

    public RandomArrayList(Random random){
        this.random = random;
    }

    public String getRandomElement() {
        int rnd = random.nextInt(super.size());
        return super.get(rnd);
    }
}
