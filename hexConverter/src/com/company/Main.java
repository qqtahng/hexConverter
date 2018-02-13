package com.company;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //read input
            System.out.print("Enter a hexadecimal number: ");
            Scanner input = new Scanner(System.in);
            String hex = input.nextLine();
            System.out.println("Your number is " + hexToDecimal(hex) + " in decimal");// call method hexToDecimal();
            System.out.println("");

        }

    private static final long hexToDecimal(String hex) {
    //convert string to uppercase
        String upperHex = hex.toUpperCase();
    //convert the hex number to a decimal value regardless of whether it is preceded by ‘0x.’
        String finalhex = upperHex.replaceAll("0X", "");
        long myhex = finalhex.length() - 1; //int doesnt fit so use long
        long mydecimal = 0; //int doesnt fit so use long

        int n = 0;
        for (int i = 0; i < finalhex.length(); i++) {
            char ch = finalhex.charAt(i);
            boolean flag = false; //take care invalid input
            switch (ch) {
                case '0':
                    n = 0;
                    break;
                case '1':
                    n = 1;
                    break;
                case '2':
                    n = 2;
                    break;
                case '3':
                    n = 3;
                    break;
                case '4':
                    n = 4;
                    break;
                case '5':
                    n = 5;
                    break;
                case '6':
                    n = 6;
                    break;
                case '7':
                    n = 7;
                    break;
                case '8':
                    n = 8;
                    break;
                case '9':
                    n = 9;
                    break;
                case 'A':
                    n = 10;
                    break;
                case 'B':
                    n = 11;
                    break;
                case 'C':
                    n = 12;
                    break;
                case 'D':
                    n = 13;
                    break;
                case 'E':
                    n = 14;
                    break;
                case 'F':
                    n = 15;
                    break;
                default:
                    flag = true;
            }
            if (flag) {
                System.out.println("Invalid Entry");
                break;
            }
            mydecimal = (long) (n * (Math.pow(16, myhex))) + mydecimal; //return a long
            myhex--;
        }
        return mydecimal;
    }
}

//this is a change
