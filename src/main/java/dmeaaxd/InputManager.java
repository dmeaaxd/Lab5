package dmeaaxd;

import java.util.Scanner;

/**
 * Class for handling CTRL + D
 *
 * @author Maksim Ushakov
 */

public class InputManager {
    private static final Scanner inputScanner = new Scanner(System.in);

    public static String input() {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        if (inputScanner.hasNextLine())
            return inputScanner.nextLine().trim();
        else {
            System.out.println(ANSI_RED + "Команда Ctrl+D завершила программу" + ANSI_RED + ANSI_RESET);
            System.exit(0);
            return "";
        }
    }
}

