package dmeaaxd.command.pattern;

import dmeaaxd.collection.HumanBeing;
import dmeaaxd.collection.WeaponType;
import dmeaaxd.command.commandCode.AddCode;
import dmeaaxd.command.commandCode.OutputHumanBeingParameters;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * This class is needed in order to store the implementation of the commands
 */

public class CommandHolder {

    /**
     * Create new Date to get collection initialization date
     */

    private final java.util.Date creationDate;
    public CommandHolder() {
        creationDate = new Date();
    }

    /**
     * Implementation of the exit command
     */

    public String exit() {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + "Сессия завершена" + ANSI_RED + ANSI_RESET);
        System.exit(0);
        return null;
    }

    /**
     * Implementation of the help command
     */

    public String help(CommandInvoker commandInvoker) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Command command : commandInvoker.getCommandMap().values()) {
            stringBuilder.append(command.getHelp()).append("\n");
        }
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        return ANSI_BLUE + "===============" + ANSI_BLUE + "\n" + stringBuilder + ANSI_BLUE + "===============" + ANSI_BLUE + ANSI_RESET;
    }

    /**
     * Implementation of the clear command
     */

    public String clear(ArrayList<HumanBeing> collection) {
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        collection.clear();
        return ANSI_GREEN + "Коллекция успешно очищена" + ANSI_GREEN + ANSI_RESET;
    }

    /**
     * Implementation of the add command
     */

    public String add(ArrayList<HumanBeing> collection) {
        final String ANSI_RESET = "\u001B[0m";
        return AddCode.addElement(collection) + ANSI_RESET;
    }

    /**
     * Implementation of the show command
     */

    public String show(ArrayList<HumanBeing> collection) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        if (collection.isEmpty()) {
            return ANSI_RED + "Коллекция пуста" + ANSI_RED + ANSI_RESET;
        } else {
            StringBuilder outputCollection = new StringBuilder();
            for (HumanBeing humanBeing : collection) {
                outputCollection.append(humanBeing.toString());
            }
            return outputCollection + ANSI_RESET;
        }
    }

    /**
     * Implementation of the info command
     */

    public String info(ArrayList<HumanBeing> collection) {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        return ANSI_BLUE + "===============" + ANSI_BLUE + ANSI_RESET + "\n" + "Тип коллекции: " + collection.getClass() + "\n" + "Дата инициализации: " + creationDate + "\n" + "Количество элементов в коллекции: " + collection.size() + "\n" + ANSI_RESET + ANSI_BLUE + "===============" + ANSI_BLUE + ANSI_RESET;
    }

    /**
     * Implementation of the updateId command
     */

    public String updateId(ArrayList<HumanBeing> collection, String argId) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        Long id;
        try {
            id = Long.parseLong(argId);
        } catch (NumberFormatException e) {
            id = null;
        }
        if (id == null) {
            return ANSI_RED + "id должен быть типа Long" + ANSI_RED + ANSI_RESET;
        }
        String output = ANSI_RED + "В коллекции нет элемента с таким id" + ANSI_RED + ANSI_RESET;
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getId().equals(id)) {
                HumanBeing updateHumanBeing = AddCode.createHumanBeing();
                updateHumanBeing.setId(id);
                collection.remove(humanBeing);
                collection.add(updateHumanBeing);
                output = ANSI_GREEN + "Элемент успешно обновлен" + ANSI_GREEN + ANSI_RESET;
            }
        }
        return output;
    }

    /**
     * Implementation of the remove_by_id command
     */

    public String remove_by_idId(ArrayList<HumanBeing> collection, String argId) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        Long id;
        try {
            id = Long.parseLong(argId);
        } catch (NumberFormatException e) {
            id = null;
        }
        if (id == null) {
            return ANSI_RED + "id должен быть типа Long" + ANSI_RED + ANSI_RESET;
        }
        String output = ANSI_RED + "В коллекции нет элемента с таким id" + ANSI_RED + ANSI_RESET;
        for (HumanBeing humanBeing : collection) {
            if (humanBeing.getId().equals(id)) {
                collection.remove(humanBeing);
                output = ANSI_GREEN + "Элемент успешно удалён" + ANSI_GREEN + ANSI_RESET;
                break;
            }
        }
        return output;
    }

    /**
     * Implementation of the reorder command
     */

    public String reorder(ArrayList<HumanBeing> collection) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        if (collection.isEmpty()) {
            return ANSI_RED + "Коллекция пуста" + ANSI_RED + ANSI_RESET;
        } else {
            for (int i = 0; i < collection.size() / 2; i++) {
                HumanBeing bufferHumanBeing = collection.get(i);
                collection.set(i, collection.get(collection.size() - 1 - i));
                collection.set(collection.size() - 1 - i, bufferHumanBeing);
            }
        }
        return ANSI_GREEN + "Коллекция успешно отсортирована" + ANSI_GREEN + ANSI_RESET;
    }

    /**
     * Implementation of the sort command
     */

    public String sort(ArrayList<HumanBeing> collection) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        if (collection.isEmpty()) {
            return ANSI_RED + "Коллекция пуста" + ANSI_RED + ANSI_RESET;
        } else {
            collection.sort(HumanBeing::compareTo);
        }
        return ANSI_GREEN + "Коллекция успешно отсортирована" + ANSI_GREEN + ANSI_RESET;
    }

    /**
     * Implementation of the remove_lower command
     */

    public String remove_lower(ArrayList<HumanBeing> collection) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_GREEN = "\u001B[32m";

        System.out.println(ANSI_BLUE + "Укажите параметры элемента для сравнения" + ANSI_BLUE + ANSI_RESET);
        HumanBeing compareHumanBeing = AddCode.createHumanBeing();
        collection.removeIf(humanBeing -> compareHumanBeing.compareTo(humanBeing) < 0);
        return ANSI_GREEN + "Все подходящие элементы были удалены" + ANSI_GREEN + ANSI_RESET;
    }

    /**
     * Implementation of the averange_of_impact_speed command
     */

    public String averange_of_impact_speed(ArrayList<HumanBeing> collection) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        long sum = 0;
        int amount = 0;

        if (collection.isEmpty()) {
            return ANSI_RED + "Коллекция пуста" + ANSI_RED + ANSI_RESET;
        } else {
            for (HumanBeing humanBeing : collection) {
                sum += humanBeing.getImpactSpeed();
                amount += 1;
            }
        }
        return ANSI_GREEN + "Среднее значение поля impactSpeed = " + (sum / amount) + ANSI_GREEN + ANSI_RESET;
    }

    /**
     * Implementation of the print_field_descending_weapon_type command
     */

    public String print_field_descending_weapon_type(ArrayList<HumanBeing> collection) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        List<WeaponType> weaponTypeList = new ArrayList<>();

        if (collection.isEmpty()) {
            return ANSI_RED + "Коллекция пуста" + ANSI_RED + ANSI_RESET;
        } else {
            for (HumanBeing humanBeing : collection) {
                weaponTypeList.add(humanBeing.getWeaponType());
            }
            weaponTypeList.sort(WeaponType::compareTo);
            StringBuilder output = new StringBuilder();
            for (int i = weaponTypeList.size() - 1; i >= 0; i--) {
                output.append(weaponTypeList.get(i)).append("\n");
            }
            return ANSI_GREEN + "Значения полей WeaponType по убыванию" + "\n" + ANSI_GREEN + ANSI_RESET + output + ANSI_RESET;
        }
    }

    /**
     * Implementation of the group_counting_by_impact_speed command
     */

    public String group_counting_by_impact_speed(ArrayList<HumanBeing> collection) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";

        long weakImpactSpeed = 0;
        long averangeImpactSpeed = 0;
        long strongImpactSpeed = 0;

        if (collection.isEmpty()) {
            return ANSI_RED + "Коллекция пуста" + ANSI_RED + ANSI_RESET;
        } else {
            for (HumanBeing humanBeing : collection) {
                if (humanBeing.getImpactSpeed() <= 100) {
                    weakImpactSpeed += 1;
                } else if (humanBeing.getImpactSpeed() <= 601 && humanBeing.getImpactSpeed() > 100) {
                    averangeImpactSpeed += 1;
                } else {
                    strongImpactSpeed += 1;
                }
            }
            return ANSI_GREEN + "Количество элементов:" + ANSI_GREEN + ANSI_RESET + "\nсо слабой скоростью удара = " + weakImpactSpeed + "\nсо средней скоростью удара = " + averangeImpactSpeed + "\nс сильной скоростью удара = " + strongImpactSpeed + ANSI_RESET;
        }
    }

    /**
     * Implementation of the save command
     */

    public String save(ArrayList<HumanBeing> collection) {
        OutputHumanBeingParameters saver = new OutputHumanBeingParameters();
        return saver.writeXML(collection);
    }

    /**
     * Implementation of the execute_script command
     * @return
     */

    public String execute_script(CommandInvoker commandInvoker, ArrayList<HumanBeing> collection, File file) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), StandardCharsets.UTF_8))){

            String[] commands;

            while (true) {
                commands = br.readLine().trim().split(" ");
                if (commands[0].isEmpty()){
                    continue;
                }
                try {
                    if (commands.length == 1){
                        System.out.println(commandInvoker.execute(commandInvoker, commands[0], collection, ""));
                        System.out.println(" ");
                    }else if (commands.length == 2){
                        System.out.println(commandInvoker.execute(commandInvoker, commands[0], collection, commands[1]));
                        System.out.println(" ");
                    }else {
                        throw new NullPointerException();
                    }
                }
                catch (NullPointerException e){
                    System.out.println(ANSI_RED+"Такой команды не существует"+ANSI_RED+ANSI_RESET);
                    System.out.println(" ");
                }
            }
        } catch (FileNotFoundException e) {
            return "FileNotFoundException";
        } catch (IOException e) {
            return "IOException";
        } catch (NullPointerException e) {
            return "NullPointerException";
        }
    }
}
