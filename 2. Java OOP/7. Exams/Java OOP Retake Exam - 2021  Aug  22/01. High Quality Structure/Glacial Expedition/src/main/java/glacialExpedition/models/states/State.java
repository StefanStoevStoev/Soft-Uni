package glacialExpedition.models.states;

import java.util.Collection;

public interface State {
    Collection<String> getExhibits();
    void setExhibits(Collection<String> exhibits);
    String getName();
}
