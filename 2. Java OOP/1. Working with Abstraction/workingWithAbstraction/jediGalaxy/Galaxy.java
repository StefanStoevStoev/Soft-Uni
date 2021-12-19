package workingWithAbstraction.jediGalaxy;

public class Galaxy {
    private Filed filed;
    private Movement jedi;
    private Movement sith;

    public Galaxy(Filed filed, Movement jedi, Movement sith){

        this.filed = filed;
        this.jedi = jedi;
        this.sith = sith;
    }

    public void moveSith(int rowSith, int colSith) {
        this.sith.move(rowSith,colSith,this.filed);
    }

    public int moveJedi(int rowJedi, int colJedi) {
        return this.jedi.move(rowJedi,colJedi, this.filed);
    }

}
