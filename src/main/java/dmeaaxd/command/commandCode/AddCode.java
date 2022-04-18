package dmeaaxd.command.commandCode;

import dmeaaxd.collection.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class is needed to implement the add command
 */

public class AddCode {

    /**
     * In the method, a new HumanBeing object is created and filled with parameters from InputHumanBeingParameters
     * @return HumanBeing object
     */

    public static HumanBeing createHumanBeing() {
        InputHumanBeingParameters inputHumanBeingParameters = new InputHumanBeingParameters();

        long id = (long) (Math.random() * 987987 +1);

        String name = inputHumanBeingParameters.setName();

        Coordinates coordinates = inputHumanBeingParameters.setCoordinates();

        java.util.Date creationDate = new Date();

        Boolean realHero = inputHumanBeingParameters.setRealHero();

        Boolean hasToothpick = inputHumanBeingParameters.setHasToothPick();

        long impactSpeed = inputHumanBeingParameters.setImpactSpeed();

        WeaponType weaponType = inputHumanBeingParameters.setWeaponType();

        Mood mood = inputHumanBeingParameters.setMood();

        Car car = inputHumanBeingParameters.setCar();

        return new HumanBeing(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, weaponType, mood, car);
    }

    /**
     * In the method, the previously created HumanBeing object is added to the collection
     * @param collection The collection
     */

    public static String addElement(ArrayList<HumanBeing> collection){
        HumanBeing element = createHumanBeing();
        collection.add(element);
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_RESET = "\u001B[0m";
        return ANSI_GREEN + "Элемент коллекции добавлен" + ANSI_GREEN + "\n" + ANSI_RESET;
    }
}
