package dmeaaxd.command.pattern;

import dmeaaxd.collection.HumanBeing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Command launcher
 */

public class CommandInvoker {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    /**
     * Method for registering commands
     * @param commandName
     * @param command
     */

    public void register(String commandName, Command command){
        commandMap.put(commandName, command);
    }

    /**
     * Method to run the program
     * @param commandInvoker
     * @param commandName
     * @param collection
     * @param arg
     * @return The result of the command
     */

    public String execute(CommandInvoker commandInvoker, String commandName, ArrayList<HumanBeing> collection, String arg){
        Command command = commandMap.get(commandName);
        return command.execute(commandInvoker, collection, arg);
    }

    public HashMap<String, Command> getCommandMap() {
        return this.commandMap;
    }
}
