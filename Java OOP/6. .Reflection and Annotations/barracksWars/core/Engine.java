package barracksWars.core;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
        String result;

//        switch (commandName) {
//            case "add":
//                result = new AddUnitCommand(data, this.unitFactory, this.repository).execute();
//                break;
//            case "report":
//                result = new ReportCommand(data, this.unitFactory, this.repository).execute();
//                break;
//            case "fight":
//                result = new FightCommand(data, this.unitFactory, this.repository).execute();
//                break;
//            default:
//                throw new RuntimeException("No such units in repository.");
//        }
//        return result;
        Executable executable = null;

        try {
            Class<?> command = Class.forName(getCorrectClassName("barracksWars.core.commands."
                    , commandName));
            Constructor<?> ctor = command.getDeclaredConstructor(String[].class, UnitFactory.class, Repository.class);
            executable = (Executable) ctor.newInstance(data, this.unitFactory, this.repository);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return executable != null ? executable.execute() : null;
    }

    private String getCorrectClassName(String path, String commandName) {

        String substring = commandName.substring(1);

        String className = Character.toUpperCase(commandName.charAt(0)) + substring;
        return path + className + "Command";
    }
}
