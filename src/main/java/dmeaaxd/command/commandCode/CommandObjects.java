package dmeaaxd.command.commandCode;

import dmeaaxd.command.*;
import dmeaaxd.command.pattern.Command;
import dmeaaxd.command.pattern.CommandInvoker;
import dmeaaxd.command.pattern.CommandHolder;

/**
 * This class is needed in order to get command objects
 */

public class CommandObjects {

    /**
     * In this method, we will get the command objects and assign them a string to call the command
     * @param commandInvoker The command invoker
     * @param commandHolder The command receiver
     */

    public static void commandObjects(CommandInvoker commandInvoker, CommandHolder commandHolder) {

        Command exit = new Exit(commandHolder);
        commandInvoker.register("exit", exit);

        Command help = new Help(commandHolder);
        commandInvoker.register("help", help);

        Command clear = new Clear(commandHolder);
        commandInvoker.register("clear", clear);

        Command add = new Add(commandHolder);
        commandInvoker.register("add", add);

        Command show = new Show(commandHolder);
        commandInvoker.register("show", show);

        Command info = new Info(commandHolder);
        commandInvoker.register("info", info);

        Command update = new UpdateId(commandHolder);
        commandInvoker.register("update", update);

        Command remove_by_id = new RemoveById(commandHolder);
        commandInvoker.register("remove_by_id", remove_by_id);

        Command reorder = new Reorder(commandHolder);
        commandInvoker.register("reorder", reorder);

        Command sort = new Sort(commandHolder);
        commandInvoker.register("sort", sort);

        Command remove_lower = new Remove_lower(commandHolder);
        commandInvoker.register("remove_lower", remove_lower);

        Command avarange_of_impact_speed = new AverangeOfImpactSpeed(commandHolder);
        commandInvoker.register("averange_of_impact_speed", avarange_of_impact_speed);

        Command print_field_descending_weapon_type = new PrintFieldDescendingWeaponType(commandHolder);
        commandInvoker.register("print_field_descending_weapon_type", print_field_descending_weapon_type);

        Command group_counting_by_impact_speed = new GroupCountingByImpactSpeed(commandHolder);
        commandInvoker.register("group_counting_by_impact_speed", group_counting_by_impact_speed);

        Command save = new Save(commandHolder);
        commandInvoker.register("save", save);

        Command execute_script = new ExecuteScript(commandHolder);
        commandInvoker.register("execute_script", execute_script);
    }
}
