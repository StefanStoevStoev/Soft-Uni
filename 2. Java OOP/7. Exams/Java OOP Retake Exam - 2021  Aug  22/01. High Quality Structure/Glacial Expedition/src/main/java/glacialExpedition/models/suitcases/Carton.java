package glacialExpedition.models.suitcases;

import java.util.ArrayList;
import java.util.Collection;

public class Carton implements Suitcase {

    private Collection<String> exhibits;

    public Carton() {
        this.exhibits = new ArrayList<>();
    }

    public void addExhibits(String exhibits) {
        this.exhibits.add(exhibits);
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

}
