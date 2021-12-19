package glacialExpedition.core;

import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.*;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ExplorerRepository explorerRepository;

    private StateRepository stateRepository;
    private Map<String, List<String>> stateExhibits;

    public ControllerImpl() {
        this.stateRepository = new StateRepository();
        this.explorerRepository = new ExplorerRepository();
        this.stateExhibits = new LinkedHashMap<>();

    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;

        switch (type) {
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(EXPLORER_INVALID_TYPE);
        }

        explorerRepository.add(explorer);

        return String.format(EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {

        List<String> list = new ArrayList<>(Arrays.asList(exhibits));


        if (list.isEmpty()) {
            list = null;
        }
        State state = new StateImpl(stateName);

        state.setExhibits(list);
        stateRepository.add(state);
        stateExhibits.putIfAbsent(stateName, list);
        return String.format(STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {

        if (explorerRepository.byName(explorerName) == null) {
            throw new IllegalArgumentException(String.format(EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        explorerRepository.remove(explorerRepository.byName(explorerName));
        return String.format(EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {

        List<Explorer> collect = explorerRepository
                .getCollection().stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();

        State state = stateRepository.byName(stateName);

        mission.explore(state, collect);

        long count = collect.stream().filter(e -> e.getEnergy() == 0).count();

        return String.format(STATE_EXPLORER, stateName, count);
    }

    @Override
    public String finalResult() {

        StringBuilder sb = new StringBuilder();

        int size1 = MissionImpl.getSize();

        sb.append(String.format("%d states were explored.\n" +
                "Information for the explorers:", size1));

        for (Explorer explorer : explorerRepository.getCollection()) {
            sb.append(String.format("\nName: %s\n" +
                            "Energy: %.0f\n" +
                            "Suitcase exhibits: ",
                    explorer.getName(),
                    explorer.getEnergy()));
            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                sb.append("None");
            } else {

                sb.append(String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits()));

            }

        }
        return sb.toString();
    }
}
