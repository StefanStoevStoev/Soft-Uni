package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MissionImpl implements Mission {

    public static void setSize(int size) {
        MissionImpl.size = size;
    }

    private static int size = 0;
    private static List<State> stateList;
    private StateRepository stateRepository;
    private ExplorerRepository explorerRepository;

    public MissionImpl() {

        stateList = new ArrayList<>();
        this.stateRepository = new StateRepository();
        this.explorerRepository = new ExplorerRepository();

    }

    public static int getSize() {
        return size;
    }

    @Override
    public void explore(State state, Collection<Explorer> explorers) {

        ++size;
        stateList.add(state);

        for (Explorer explorer : explorers) {

            if (!explorer.canSearch() || state.getExhibits().isEmpty()) {
                continue;
            }

            List<String> removeExhibits = new ArrayList<>();

            for (String exhibit : state.getExhibits()) {

                explorer.getSuitcase().getExhibits().add(exhibit);
                explorer.search();
                removeExhibits.add(exhibit);
            }
            for (String removeExhibit : removeExhibits) {
                state.getExhibits().remove(removeExhibit);
            }
        }

    }
}
