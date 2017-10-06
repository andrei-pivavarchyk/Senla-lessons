package ui.Service;


import java.util.Scanner;

import static java.lang.System.in;

public class ConsoleService {

    public static int getNumber(int maxNumber) {


        Scanner scanner = new Scanner(System.in);
        Boolean NumberIsNotGiven = true;
        int input = 0;


        while (NumberIsNotGiven) {
            try {

                input = scanner.nextInt();
                if (input == 0||input>maxNumber) {
                    System.out.println("Bad number");
                    scanner.next();
                } else {
                    NumberIsNotGiven = false;
                }
            } catch (Exception e) {
                System.out.println("Try again");
                scanner.next();
            }
        }
        return input;
    }

}




