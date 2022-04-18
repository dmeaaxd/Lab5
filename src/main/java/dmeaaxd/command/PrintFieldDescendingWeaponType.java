package dmeaaxd.command;

import dmeaaxd.collection.HumanBeing;
import dmeaaxd.command.pattern.Command;
import dmeaaxd.command.pattern.CommandInvoker;
import dmeaaxd.command.pattern.CommandHolder;

import java.util.ArrayList;

/**
 * Command template class
 */

public class PrintFieldDescendingWeaponType implements Command {
    private final CommandHolder commandHolder;
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_RESET = "\u001B[0m";

    /**
     * This method is needed in order to assign the command its functionality
     * @param commandHolder The command receiver
     */

    public PrintFieldDescendingWeaponType(CommandHolder commandHolder) {
        this.commandHolder = commandHolder;
    }

    /**
     * This method runs the command
     * @param commandInvoker The command invoker
     * @param collection The collection
     * @param arg The argument
     * @return Command result or error caused by the presence or absence of an argument
     */

    @Override
    public String execute(CommandInvoker commandInvoker, ArrayList<HumanBeing> collection, String arg) {
        if (arg.isEmpty()) {
            return commandHolder.print_field_descending_weapon_type(collection);
        } else {
            return ANSI_RED + "Эта команда не принимает аргументы" + ANSI_RED + ANSI_RESET;
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
        return ANSI_GREEN+"print_field_descending_weapon_type"+ANSI_GREEN + ANSI_RESET +" - вывести значения поля weaponType всех элементов в порядке убывания"+ANSI_RESET;
    }
}
