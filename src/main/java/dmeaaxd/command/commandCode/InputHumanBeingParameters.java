package dmeaaxd.command.commandCode;

import dmeaaxd.InputManager;
import dmeaaxd.collection.Car;
import dmeaaxd.collection.Coordinates;
import dmeaaxd.collection.Mood;
import dmeaaxd.collection.WeaponType;

/**
 * Destination class of HumanBeing parameter
 */

public class InputHumanBeingParameters {

    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_RESET = "\u001B[0m";

    /**
     * Method for assigning element name
     * @return name
     */

    public String setName(){
        String name = "";
        while (name.isEmpty()){
            System.out.print(ANSI_BLUE + "Укажите имя: " + ANSI_BLUE+ANSI_RESET);
            name = InputManager.input();

            if (name.isEmpty()) {
                System.out.println(ANSI_RED + "Строка не может быть пустой. Повторите попытку" + ANSI_RED+ANSI_RESET);
                System.out.println(" ");
            }
        }
        return name;
    }

    /**
     * Method for assigning element coordinates
     * @return coordinates
     */

    public Coordinates setCoordinates(){
        Integer x;
        Double y;

        do {
            System.out.print(ANSI_BLUE + "Укажите координату типа int x = " + ANSI_BLUE+ANSI_RESET);
            String stringX = InputManager.input();
            try {
                x = Integer.parseInt(stringX);
            }catch (NumberFormatException e){
                System.out.println(ANSI_RED + "Введенные данные должны быть типа int. Повторите попытку" + ANSI_RED+ANSI_RESET);
                System.out.println(" ");
                x = null;
            }
        } while (x == null);

        do {
            System.out.print(ANSI_BLUE + "Укажите координату типа double y = " + ANSI_BLUE+ANSI_RESET);
            String stringY = InputManager.input();
            try {
                y = Double.parseDouble(stringY);
                if (y > 422) {
                    throw new NumberFormatException();
                }
            }catch (NumberFormatException e){
                System.out.println(ANSI_RED + "Введенные данные должны быть типа double и должны быть не больше 422. Повторите попытку" + ANSI_RED+ANSI_RESET);
                System.out.println(" ");
                y = null;
            }
        } while (y == null);

        return new Coordinates(x, y);
    }

    /**
     * Method for assigning element realHero
     * @return realHero
     */

    public Boolean setRealHero() {
        boolean flag = true;
        Integer intRealHero;
        do {
            System.out.print(ANSI_BLUE + "Персонаж - герой? " + ANSI_BLUE+ANSI_RESET);
            System.out.println(ANSI_RED + "(1 - Да, 2 - Нет)" + ANSI_RED+ANSI_RESET);
            String stringRealHero = InputManager.input();

            try {
                intRealHero = Integer.parseInt(stringRealHero);
                if (intRealHero != 1 && intRealHero != 2){
                    throw new NumberFormatException();
                }
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Можно ввести только 1 или 2. Повторите попытку" + ANSI_RED+ANSI_RESET);
                System.out.println(" ");
                intRealHero = null;
            }
        } while (flag);

        Boolean realHero = null;
        switch (intRealHero){
            case 1:
                realHero = true;
                break;
            case 2:
                realHero = false;
                break;
        }

        return realHero;
    }

    /**
     * Method for assigning element hasToothpick
     * @return hasToothpick
     */

    public Boolean setHasToothPick() {
        Integer intHasToothpick;
        do {
            System.out.print(ANSI_BLUE + "У персонажа есть зубочистка? " + ANSI_BLUE+ANSI_RESET);
            System.out.println(ANSI_RED + "(1 - Да, 2 - Нет)" + ANSI_RED+ANSI_RESET);
            String stringHasToothpick = InputManager.input();

            try {
                intHasToothpick = Integer.parseInt(stringHasToothpick);
                if (intHasToothpick != 1 && intHasToothpick != 2){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Можно ввести только 1 или 2. Повторите попытку" + ANSI_RED+ANSI_RESET);
                System.out.println(" ");
                intHasToothpick = null;
            }
        } while (intHasToothpick == null);

        Boolean hasToothpick = null;
        switch (intHasToothpick){
            case 1:
                hasToothpick = true;
                break;
            case 2:
                hasToothpick = false;
                break;
        }

        return hasToothpick;
    }

    /**
     * Method for assigning element impactSpeed
     * @return impactSpeed
     */

    public Long setImpactSpeed(){
        Long impactSpeed;
        do {
            System.out.print(ANSI_BLUE + "Укажите скорость удара = " + ANSI_BLUE+ANSI_RESET);
            String stringImpactSpeed = InputManager.input();
            try{
                impactSpeed = Long.parseLong(stringImpactSpeed);
                if (impactSpeed > 782){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e){
                System.out.println(ANSI_RED + "Введенные данные должны быть типа long и должны быть не больше 782. Повторите попытку" + ANSI_RED+ANSI_RESET);
                System.out.println(" ");
                impactSpeed = null;
            }
        } while (impactSpeed == null);
        return impactSpeed;
    }

    /**
     * Method for assigning element weaponType
     * @return weaponType
     */
    
    public WeaponType setWeaponType() {
        Integer intWeaponType;
        do {
            System.out.println(ANSI_BLUE + "Укажите тип оружия" + ANSI_BLUE+ANSI_RESET);
            for (int i = 0; i < WeaponType.values().length; i++) {
                System.out.println(ANSI_RED + WeaponType.values()[i] + " - " + (i + 1) + ANSI_RED+ANSI_RESET);
            }
            String stringWeaponType = InputManager.input();
            try {
                intWeaponType = Integer.parseInt(stringWeaponType);
                if (intWeaponType < 1 || intWeaponType > WeaponType.values().length){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e){
                System.out.println(ANSI_RED + "Можно вводить только данные из перечня. Повторите попытку" + ANSI_RED+ANSI_RESET);
                System.out.println(" ");
                intWeaponType = null;
            }
        } while (intWeaponType == null);

        return WeaponType.values()[intWeaponType - 1];
    }

    /**
     * Method for assigning element mood
     * @return mood
     */

    public Mood setMood() {
        Integer intMood;
        do {
            System.out.println(ANSI_BLUE + "Укажите тип настроения" + ANSI_BLUE+ANSI_RESET);
            for (int i = 0; i < Mood.values().length; i++) {
                System.out.println(ANSI_RED + Mood.values()[i] + " - " + (i + 1) + ANSI_RED+ANSI_RESET);
            }
            String stringMood = InputManager.input();
            try {
                intMood = Integer.parseInt(stringMood);
                if (intMood < 1 || intMood > Mood.values().length){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e){
                System.out.println(ANSI_RED + "Можно вводить только данные из перечня. Повторите попытку" + ANSI_RED+ANSI_RESET);
                System.out.println(" ");
                intMood = null;
            }
        } while (intMood == null);

        return Mood.values()[intMood - 1];
    }

    /**
     * Method for assigning element car
     * @return car
     */

    public Car setCar() {
        Integer intCar;
        do {
            System.out.print(ANSI_BLUE + "У персонажа крутая машина? " + ANSI_BLUE+ANSI_RESET);
            System.out.println(ANSI_RED + "(1 - Да, 2 - Нет)" + ANSI_RED+ANSI_RESET);
            String stringCar = InputManager.input();
            try {
                intCar = Integer.parseInt(stringCar);
                if (intCar != 1 && intCar != 2){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Можно ввести только 1 или 2. Повторите попытку" + ANSI_RED+ANSI_RESET);
                System.out.println(" ");
                intCar = null;
            }
        } while (intCar == null);

        Boolean car = null;
        switch (intCar){
            case 1:
                car = true;
                break;
            case 2:
                car = false;
                break;
        }

        return new Car(car);
    }
}
