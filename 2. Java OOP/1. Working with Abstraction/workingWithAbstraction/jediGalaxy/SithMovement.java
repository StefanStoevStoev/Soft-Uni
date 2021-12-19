package workingWithAbstraction.jediGalaxy;

public class SithMovement implements Movement {
    @Override
    public int move(int rowSith, int colSith, Filed filed) {
        while (rowSith >= 0 && colSith >= 0) {
            if (filed.isInBounds(rowSith, colSith)) {
                filed.setValue(rowSith,colSith, 0);
            }
            rowSith--;
            colSith--;
        }
        return 0;
    }
}
