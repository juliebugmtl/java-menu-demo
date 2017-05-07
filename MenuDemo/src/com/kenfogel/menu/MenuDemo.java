package com.kenfogel.menu;

import java.util.Scanner;

/**
 * A demo of writing a menu
 *
 * @author Ken Fogel
 * @date 2017-04-25
 * @version 0.1
 */
public class MenuDemo {

    private Scanner sc;

    public MenuDemo() {
        sc = new Scanner(System.in);
    }

    private double inputNumber(String prompt, double min, double max) {

        double number = -1.0;

        do {
            System.out.println(prompt);

            if (sc.hasNextDouble()) {
                number = sc.nextDouble();
            } else {
                number = -1.0;
            }
            if (number < min || number > max) {
                number = -1.0;
                System.out.println("Invalid number");
            }
            sc.nextLine();
        } while (number < 0.0);

        return number;

    }

    private void showMenu() {
        System.out.println("Simple Menu");
        System.out.println("");
        System.out.println("A) Choice A");
        System.out.println("B) Choice B");
        System.out.println("C) Exit");
        System.out.println("");
    }

    private char doMenuChoice() {
        char choice = '@';
        do {
            System.out.print("Please enter your choice: ");
            if (sc.hasNext("[a-cA-C]")) {
                choice = sc.next().toUpperCase().charAt(0);
            }
            if (choice == '@') {
                System.out.println("Invalid input.");
            }
            sc.nextLine();
        } while (choice == '@');

        return choice;
    }

    private void doChoiceA() {
        System.out.println("This is choice A");
        double number = inputNumber("Enter your shoe size: ", 2.0, 21.0);
        System.out.println("Your show size is " + number);

    }

    private void doChoiceB() {
        System.out.println("This is choice B");
    }

    public void perform() {
        char ch;

        do {
            showMenu();
            ch = doMenuChoice();
            System.out.println("You chose " + ch);

            switch (ch) {
                case 'A':
                    doChoiceA();
                    break;
                case 'B':
                    doChoiceB();
                    break;
            }
        } while (ch != 'C');
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuDemo md = new MenuDemo();
        md.perform();
        System.exit(0);
    }

}
