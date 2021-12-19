package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;


import java.util.Collection;

public interface Mission {

    static int getSize() {
        return 0;
    }

    void explore(State state, Collection<Explorer> explorers);

}
