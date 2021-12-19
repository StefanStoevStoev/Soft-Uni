package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer{
    public AnimalExplorer(String name) {
        super(name, 100);
    }
    @Override
    public void search() {
        if (getEnergy() < 0){
            setEnergy(0);
            canSearch();
        }
        setEnergy(getEnergy() - 15);
    }
}
