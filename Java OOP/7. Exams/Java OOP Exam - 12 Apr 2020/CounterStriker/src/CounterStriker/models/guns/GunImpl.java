package CounterStriker.models.guns;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class GunImpl implements Gun {
    private String name;
    private int bulletsCount;

    protected GunImpl(String name, int bulletsCount) {

        this.setBulletsCount(bulletsCount);
        this.setName(name);
    }

    protected void decreaseBullets(int amount) {/////////
        this.bulletsCount -= amount;
    }

    private void setBulletsCount(int bulletsCount) {///////////
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    private void setName(String name) {///////////
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(INVALID_GUN_NAME);
        }
        this.name = name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }/////////////

    @Override
    public String getName() {
        return this.name;
    }//////////

    @Override
    public String toString() {
        return " ";
    }
}
