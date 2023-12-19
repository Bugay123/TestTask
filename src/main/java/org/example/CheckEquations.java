package org.example;

import java.util.Scanner;


public class CheckEquations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the math equation");
        String equation = scanner.nextLine();

        //Check block
        Check check = new Check();

        if (!check.regexCheckedX(equation)) {
            System.out.println("Your equation have another symbols");
            System.exit(0);
        }
        if (!equation.contains("x")) {
            System.out.println("You entered an equation without X");
            System.exit(0);
        }
        if (!check.checkBrackets(equation)) {
            System.out.println("You entered an equation with incorrect brackets");
            System.exit(0); // exit the program
        }
        if (!check.checkOperators(equation)) {
            System.out.println("You have some problems with operators in your equation");
            System.exit(0);
        }
        //And check block
        System.out.println("Your equation is valid");

    }
}

class Check {
    public static boolean checkBrackets(String equation) {
        int openBrackets = 0, closedBrackets = 0;
        for (char c : equation.toCharArray()) {
            if (c == '(') {
                openBrackets++;
            }
            if (c == ')') {
                closedBrackets++;
            }
        }
        return openBrackets == closedBrackets;
    }

    public static boolean checkOperators(String equation) {
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);

            if (c == '*') {
                if (equation.charAt(i + 1) == '-') {
                    return true;
                }
            } else if (c == '+' || c == '-' || c == '/') {
                if (equation.charAt(i + 1) == '+' || equation.charAt(i + 1) == '-' || equation.charAt(i + 1) == '/' || equation.charAt(i + 1) == '*') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean regexCheckedX(String equation) {
        String regex = "^[xхXХ0-9+\\-*/=()\\s.]+$";
        return equation.matches(regex);
    }
}