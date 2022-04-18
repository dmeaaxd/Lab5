package dmeaaxd.command;

import dmeaaxd.collection.HumanBeing;
import dmeaaxd.command.pattern.Command;
import dmeaaxd.command.pattern.CommandInvoker;
import dmeaaxd.command.pattern.CommandHolder;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Command template class
 */

public class ExecuteScript implements Command {
    private final CommandHolder commandHolder;
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_GREEN = "\u001B[32m";

    /**
     * This method is needed in order to assign the command its functionality
     * @param commandHolder The command receiver
     */

    public ExecuteScript(CommandHolder commandHolder) {
        this.commandHolder = commandHolder;
    }

    private static final Set<File> executedSripts = new HashSet<>();

    /**
     * This method runs the command
     * @param commandInvoker The command invoker
     * @param collection The collection
     * @param arg The argument
     * @return Command result or error caused by the presence or absence of an argument, or error caused by recursion
     */

    @Override
    public String execute(CommandInvoker commandInvoker, ArrayList<HumanBeing> collection, String arg) {

        if (!arg.isEmpty()) {
            File file = new File(arg);
            String responseReturn;
            if (!executedSripts.contains(file)) {
                executedSripts.add(file);
                String response = commandHolder.execute_script(commandInvoker, collection, file);
                if (response.equals("FileNotFoundException")){
                    responseReturn = ANSI_RED + "Файл не найден" + ANSI_RED + ANSI_RESET;
                } else{
                    responseReturn = ANSI_GREEN + "Скрипт успешно выполнен" + ANSI_GREEN + ANSI_RESET;
                }
                executedSripts.remove(file);
                return responseReturn;
            } else {
                return ANSI_RED + "Этот скрипт уже выполняется" + ANSI_RED + ANSI_RESET;
            }
        } else {
            return ANSI_RED + "Этой команде требуется аргумент" + ANSI_RED+ANSI_RESET;
        }
    }

    /**
     * Method for getting instructions for a command
     * @return Instructions for the command
     */

    @Override
    public String getHelp() {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        return ANSI_GREEN+"execute_script file_name"+ANSI_GREEN + ANSI_RESET +" - считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме"+ANSI_RESET;
    }
}
