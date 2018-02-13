package com.company;
//import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Blackjack {
    public static void main(String[] args) {
        boolean playgame = true;
        int gamenumber = 0;
        int option;
        int cardTotal = 0;
        int playnum;
        int grandtotal;                 //your first random card  playermumber   1~13
        int playerwin = 0;
        int dealerwin = 0;
        int tietie = 0;
        Scanner input = new Scanner(System.in);
        P1Random rng = new P1Random();
        while (playgame) {
            gamenumber = gamenumber + 1;
            System.out.println("START GAME #" + gamenumber);
            System.out.println("");
            int playermumber = rng.nextInt(13) + 1;   //player first random number
            if (playermumber > 10 && playermumber < 14)
                playnum = 10;
            else                      //other cards keep the face value
                playnum = playermumber;
            if (playermumber == 1)                              // 1~10 card and hand are same, 11~14 card and hand are different
                System.out.println("Your card is a ACE!");
            else if (playermumber == 11)
                System.out.println("Your card is a JACK!");
            else if (playermumber == 12)
                System.out.println("Your card is a QUEEN!");
            else if (playermumber == 13)
                System.out.println("Your card is a KING!");
            else
                System.out.println("Your card is a " + playermumber+"!");
            System.out.println("Your hand is: " + playnum);
            OptionMenu();
            option = input.nextInt();
            grandtotal = cardTotal + playnum;
            while (grandtotal < 22)
                if (option == 1)
                { int Autormumber = rng.nextInt(13) + 1;  ///added 1/31/2018
                    if (Autormumber > 10 && Autormumber < 14) {
                        cardTotal += 10;
                    }
                    else {
                        cardTotal += Autormumber;
                    }
                    System.out.println();
                    if (Autormumber == 1) {
                        System.out.println("Your card is a ACE!");
                    } else if (Autormumber == 11) {
                        System.out.println("Your card is a JACK!");
                    } else if (Autormumber == 12) {
                        System.out.println("Your card is a QUEEN!");
                    } else if (Autormumber == 13) {
                        System.out.println("Your card is a KING!");
                    } else {
                        System.out.println("Your card is a " + Autormumber + "!");
                    }
                    System.out.println("Your hand is: " + (cardTotal + playnum));
                    grandtotal = cardTotal + playnum;
                    if ((grandtotal) > 21) {
                        System.out.println();
                        System.out.println("You exceeded 21! You lose.");
                        dealerwin = dealerwin + 1;
                        cardTotal = 0;   //zero out the cardTotal to avoid the previous total being added to the next game
                        playgame = true;
                        System.out.println();
                    } else if ((grandtotal) == 21) {
                        System.out.println();
                        System.out.println("BLACKJACK! You win!");
                        playerwin = playerwin + 1;
                        System.out.println();
                        cardTotal = 0;    //zero out the cardTotal to avoid the previous total being added to the next game
                        grandtotal = 22;
                        // playnum=0;
                        playgame = true;
                    } else if ((grandtotal) < 21) {
                        OptionMenu();
                        option = input.nextInt();
                    }
                }
                else if(option==2)
                {   System.out.println();
                    int dealerCard = rng.nextInt(11) + 16;
                    System.out.println("Dealer's hand: "+dealerCard);
                    System.out.println("Your hand is: "+grandtotal);
                    System.out.println();
                    if(dealerCard>21)
                    {
                        System.out.println("You win!");
                        playerwin=playerwin+1;
                        grandtotal=dealerCard;                                      //in order to get out of the  while(grandtotal<21), make sure grandtotal is bigger than 21, since dealerCard>21, so just assign dealerCard to grandtotal will do the job -
                        cardTotal=0;
                    }
                    else if(dealerCard==21)
                    {
                        System.out.println("Dealer wins!");
                        //System.out.println();
                        dealerwin = dealerwin + 1;
                        grandtotal=22;                                  //in order to get out of the  while(grandtotal<21), make sure grandtotal is bigger than 20, since dealerCard=21, so just assign dealerCard to grandtotal will do the job
                        cardTotal=0;
                    }
                    else if(dealerCard<21)
                    {
                        if(dealerCard>grandtotal)
                        {
                            System.out.println("Dealer wins!");
                            dealerwin = dealerwin + 1;
                            //System.out.println();
                        }
                        else if(dealerCard==grandtotal)
                        {

                            System.out.println("It's a tie! No one wins!");
                            tietie = tietie + 1;

                        }
                        else
                        {

                            System.out.println("You win!");
                            System.out.println();
                            playerwin=playerwin+1;

                        }
                        playgame=true;
                        grandtotal=23;    //in order to get out of the  while(grandtotal<21), you just assign any number which is greater than 21
                        cardTotal=0;
                    }
                    System.out.println();
                }
                else if (option == 3) {
                    int totalGame=  playerwin+dealerwin+tietie;
                    System.out.println();
                    System.out.println("Number of Player wins: " + playerwin);
                    System.out.println("Number of Dealer wins: " + dealerwin);
                    System.out.println("Number of tie games: " + tietie);
                    System.out.println("Total # of games played is: " + totalGame);
                    System.out.println("Percentage of Player wins: " + ((double) playerwin / (double) totalGame) * 100 + "%");
                    grandtotal = playnum;
                    OptionMenu();
                    option = input.nextInt();
                }
                else if (option != 4 && option != 3 && option != 2 && option != 1) {
                    System.out.println();
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    grandtotal = playnum;
                    OptionMenu();
                    option = input.nextInt();
                }
                else if (option == 4) {
                    System.exit(0);
                }
                else {
                    System.out.println("Invalid number");
                    playgame = false;
                    System.exit(0);
                }
        }
    }
    private static void OptionMenu() {
        System.out.println();
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.println();
        System.out.print("Choose an option: ");
    }
}