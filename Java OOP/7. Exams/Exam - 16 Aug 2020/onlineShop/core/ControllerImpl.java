package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computers;
    private Map<Integer, Component> componentMap;
    private Map<Integer, Peripheral> peripheralMap;

    protected ControllerImpl() {
        this.computers = new HashMap<>();
        this.componentMap = new HashMap<>();
        this.peripheralMap = new HashMap<>();
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model,
                               double price, double overallPerformance, int generation) {
        checkComputerId(computerId);

        if (componentMap.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        Component component;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        componentMap.put(component.getId(), component);
        computers.get(computerId).addComponent(component);

        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    private void checkComputerId(int id) {
        if (!this.computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {

        if (this.computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }

        Computer computer;

        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }

        computers.put(computer.getId(), computer);

        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer,
                                String model, double price, double overallPerformance, String connectionType) {
        checkComputerId(computerId);

        if (peripheralMap.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }

        Peripheral peripheral;

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id,manufacturer,model,price,overallPerformance,connectionType);

                break;
            case "Monitor":
                peripheral = new Monitor(id,manufacturer,model,price,overallPerformance,connectionType);

                break;
            case "Mouse":
                peripheral = new Mouse(id,manufacturer,model,price,overallPerformance,connectionType);

                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }
        computers.get(computerId).addPeripheral(peripheral);
        this.peripheralMap.putIfAbsent(peripheral.getId(), peripheral);

        return String.format(ADDED_PERIPHERAL, peripheralType, id,computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        checkComputerId(computerId);
        checkComputerId(computerId);

        Peripheral removePer = computers.get(computerId).removePeripheral(peripheralType);

        componentMap.remove(removePer.getId());
        return String.format(REMOVED_PERIPHERAL, peripheralType, removePer.getId());
    }


    @Override
    public String removeComponent(String componentType, int computerId) {

        checkComputerId(computerId);

        Component removeComp = computers.get(computerId).removeComponent(componentType);

        componentMap.remove(removeComp.getId());
        return String.format(REMOVED_COMPONENT, componentType, removeComp.getId());
    }

    @Override
    public String buyComputer(int id) {
        checkComputerId(id);
        Computer computer = computers.remove(id);
        return computer.toString();
    }


    @Override
    public String BuyBestComputer(double budget) {
        List<Computer> filteredComputer = computers.values().stream()
                .filter(c->c.getPrice() <=budget)
                .sorted(Comparator.comparing(Computer::getOverallPerformance).reversed())
                .collect(Collectors.toList());

        if (filteredComputer.isEmpty()) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER,budget));

        }
        Computer computer = filteredComputer.get(0);

        computers.remove(computer.getId());

        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        checkComputerId(id);

        return computers.get(id).toString();
    }
}
