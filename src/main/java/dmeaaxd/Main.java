package dmeaaxd;

import dmeaaxd.ParserXML.MyParser;
import dmeaaxd.collection.HumanBeing;
import dmeaaxd.command.pattern.CommandInvoker;
import dmeaaxd.command.pattern.CommandHolder;

import java.io.File;
import java.util.ArrayList;

import static dmeaaxd.command.commandCode.CommandObjects.commandObjects;

/**
 * The class where the program is run
 *
 * @author Maksim Ushakov "dmeaaxd@gmail.com"
 */
public class Main {

    public static String path_to_file = System.getenv("PATH_TO_FILE");

    public static void main(String[] args) {
        CommandInvoker commandInvoker = new CommandInvoker();
        ArrayList<HumanBeing> collection = new ArrayList<>();
        CommandHolder commandHolder = new CommandHolder();
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        MyParser parser = new MyParser();

        if (path_to_file == null){
            System.out.println(ANSI_RED + "Переменная окружения не обнаружена. Укажите новый путь: " + ANSI_RED + ANSI_RESET);
            path_to_file = InputManager.input();
        }

        while (true){
            File file = new File(path_to_file);
            if (file.length() == 0){
                break;
            }
            if (file.isDirectory()){
                System.out.print(ANSI_RED + "Программа не может работать с директорией. Введите exit, чтобы выйти или укажите путь на новый файл: " + ANSI_RED + ANSI_RESET);
                path_to_file = InputManager.input();
                if (path_to_file.equals("exit")){
                    System.out.println(ANSI_RED + "Сессия завершена" + ANSI_RED + ANSI_RESET);
                    System.exit(0);
                }
            }
            if (file.canRead() && file.canWrite()){
                try {
                    collection = parser.parse(path_to_file);
                    break;
                } catch (Exception e) {
                    System.out.print(ANSI_RED + "Файл некорректен. Введите exit, чтобы выйти или укажите путь на новый файл: " + ANSI_RED + ANSI_RESET);
                    path_to_file = InputManager.input();
                    if (path_to_file.equals("exit")){
                        System.out.println(ANSI_RED + "Сессия завершена" + ANSI_RED + ANSI_RESET);
                        System.exit(0);
                    }
                }
            } else {
                System.out.print(ANSI_RED + "Нехватка прав доступа. Введите exit, чтобы выйти или укажите путь на новый файл: " + ANSI_RED + ANSI_RESET);
                path_to_file = InputManager.input();
                if (path_to_file.equals("exit")){
                    System.exit(0);
                }
            }
        }
        


        commandObjects(commandInvoker, commandHolder);

        String sysOut;
        while (true){
            String[] arrayOfCommandParts = InputManager.input().trim().split(" ");
            String command = arrayOfCommandParts[0];
            if (command.isEmpty()){
                continue;
            }
            try {
                if (arrayOfCommandParts.length == 1){
                    sysOut = commandInvoker.execute(commandInvoker, command, collection, "");
                    System.out.println(sysOut);
                    System.out.println(" ");
                }else if (arrayOfCommandParts.length == 2){
                    sysOut = commandInvoker.execute(commandInvoker, command, collection, arrayOfCommandParts[1]);
                    System.out.println(sysOut);
                    System.out.println(" ");
                }else {
                    throw new NullPointerException();
                }
            }
            catch (NullPointerException e){
                System.out.println(ANSI_RED+"Такой команды не существует. Введите help и попробуйте снова"+ANSI_RED+ANSI_RESET);
                System.out.println(" ");
            }
        }
    }
}
