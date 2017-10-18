package ui.service;


import java.util.Scanner;

public class ConsoleService {

    private static ConsoleService consoleService;

    private ConsoleService() {

    }

    public static synchronized ConsoleService getConsoleService() {
        if (consoleService == null) {
            consoleService = new ConsoleService();
        }
        return consoleService;
    }

    public int getNumberForMenu(int maxNumber) {


        Scanner scanner = new Scanner(System.in);
        Boolean NumberIsNotGiven = true;
        int input = 0;

        while (NumberIsNotGiven) {
            try {

                input = scanner.nextInt();

                if (input == 666) {
                    NumberIsNotGiven = false;
                } else if (input <= 0 || input > maxNumber) {
                    System.out.println("Bad number");

                } else {
                    NumberIsNotGiven = false;
                }
            } catch (Exception e) {

                System.out.println("Try again");

            }
        }
        return input;
    }

    public String getString() {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        return string;
    }

    public int getNumber() {
        int input = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();

        } catch (Exception e) {

            System.out.println("Try again");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();

        }
        return input;

    }

}