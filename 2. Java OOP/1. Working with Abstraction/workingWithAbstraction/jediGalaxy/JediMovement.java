package workingWithAbstraction.jediGalaxy;

public class JediMovement implements Movement {
    @Override
    public int move(int rowJedi, int colJedi, Filed filed) {
        int collectedPower = 0;
        while (rowJedi >= 0 && colJedi < filed.getColLenght(1)) {//////////////
            if (filed.isInBounds(rowJedi,colJedi)) {
                collectedPower += filed.getValue(rowJedi,colJedi);
            }

            colJedi++;
            rowJedi--;
        }
        return collectedPower;
    }
}
