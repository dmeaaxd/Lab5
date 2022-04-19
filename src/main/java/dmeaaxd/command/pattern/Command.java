package dmeaaxd.command.pattern;

import dmeaaxd.collection.HumanBeing;

import java.util.ArrayList;

/**
 * In this interface, we create templates for the further implementation of commands
 */

public interface Command {

    /**
     * The method runs the command
     * @param commandInvoker The invoker
     * @param collection The collection
     * @param arg The command argument
     * @return The result of the command
     */

    String execute(CommandInvoker commandInvoker, ArrayList<HumanBeing> collection, String arg);

    /**
     * Method for getting instruction
     * @return Instructions for the command
     */

    String getHelp();
}
