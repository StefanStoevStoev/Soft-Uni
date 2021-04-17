package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SportsCar extends BaseCar {////////////////
    private static double CUBIC_CENTIMETERS = 3000;

    public SportsCar(String model, int horsePower) {/////////////////
        super(model, valid(horsePower), CUBIC_CENTIMETERS);
    }
    private static int valid(int horsePower){/////////////////
        if(horsePower < 250 || horsePower > 450){
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER,horsePower));
        }
        return horsePower;
    }
}
