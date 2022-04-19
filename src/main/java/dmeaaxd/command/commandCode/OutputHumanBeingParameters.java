package dmeaaxd.command.commandCode;

import dmeaaxd.InputManager;
import dmeaaxd.Main;
import dmeaaxd.collection.HumanBeing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class for writing a collection to a file
 */

public class OutputHumanBeingParameters {

    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";

    /**
     * Method for writing collection to xml file
     * @param collection The collection
     * @return output
     */

    public String writeXML(ArrayList<HumanBeing> collection) {

        String text;

        String path_to_file = Main.path_to_file;

        File file = new File(path_to_file);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            StringBuilder textBuilder = new StringBuilder(new StringBuilder("<?xml version = \"1.0\" encoding = \"UTF-8\" ?><root>"));
            for (HumanBeing humanBeing : collection){
                String name = "<name>"+humanBeing.getName()+"</name>";
                String x = "<x>" + humanBeing.getCoordinates().getX() + "</x>";
                String y = "<y>" + humanBeing.getCoordinates().getY() + "</y>";
                String coordinates = "<coordinates>"+x+y+"</coordinates>";
                String creationDate = "<creationDate>"+humanBeing.getCreationDate().getTime()+"</creationDate>";
                String realHero = "<realHero>"+humanBeing.getRealHero()+"</realHero>";
                String hasToothpick = "<hasToothpick>"+humanBeing.getHasToothpick()+"</hasToothpick>";
                String impactSpeed = "<impactSpeed>"+humanBeing.getImpactSpeed()+"</impactSpeed>";
                String weaponType = "<weaponType>"+humanBeing.getWeaponType()+"</weaponType>";
                String mood = "<mood>"+humanBeing.getMood()+"</mood>";
                String car = "<car>"+humanBeing.getCar().isCool()+"</car>";
                String HumanBeing = "<HumanBeing id=\""+humanBeing.getId()+"\">" + name + coordinates + creationDate
                        + realHero + hasToothpick + impactSpeed + weaponType + mood + car +"</HumanBeing>";
                textBuilder.append(HumanBeing);
            }
            text = textBuilder.toString();
            text +="</root>";

            byte[] buffer = text.getBytes();
            fos.write(buffer);

            return ANSI_GREEN + "Коллекция успешно сохранена" + ANSI_GREEN + ANSI_RESET;
        } catch (IOException e) {
            return ANSI_RED + "Ошибка чтения файла" + ANSI_RED + ANSI_RESET;
        }
    }
}
