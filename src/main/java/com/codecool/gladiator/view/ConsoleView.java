package com.codecool.gladiator.view;

import java.util.Random;
import java.util.Scanner;

/**
 * Basic console view implementation
 */
public class ConsoleView implements Viewable {

    @Override
    public void display(String text) {
        System.out.println(text);
    }

    @Override
    public int getNumberBetween(int min, int max) {
        Scanner numScanner = new Scanner(System.in);
        String numInput = numScanner.nextLine();
        System.out.println(numInput);
        int num = Integer.parseInt(numInput);
        if (num >= min && num <= max) {
            return num;
        } else {
            System.out.println("Invalid input, please try again");
            return getNumberBetween(min, max);
        }
    }

}
