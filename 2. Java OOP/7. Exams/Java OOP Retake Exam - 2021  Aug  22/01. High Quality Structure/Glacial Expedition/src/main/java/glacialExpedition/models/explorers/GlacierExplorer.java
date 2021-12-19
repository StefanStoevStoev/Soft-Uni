package glacialExpedition.models.explorers;

public class GlacierExplorer extends BaseExplorer{
    public GlacierExplorer(String name) {
        super(name, 40);
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
