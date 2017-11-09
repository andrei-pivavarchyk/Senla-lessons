package com.hotelInterface;

import com.hotelInterface.action.roomMenuAction.ActionShowAllRooms;
import com.hotelInterface.controller.MenuController;

public class Main {

    public static void main(String[] args) {
        //  MenuController menuController = new MenuController();
         // menuController.run();






final ActionShowAllRooms a=new ActionShowAllRooms();

        new Thread() {
            public void run() {
                int i = 0;
                    while (i++ < 4) {
                        a.execute();
                        try {
                            sleep(100);
                        } catch (InterruptedException e) {
                            System.err.print(e);
                        }
                    }
                    System.out.println("First done");
            }
        }.start();

        new Thread() {
            public void run() {
                int i = 0;
                while (i++ < 4) {
                    a.execute();
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        System.err.print(e);
                    }
                }
                System.out.println("Second done");
            }
        }.start();








    }
}
