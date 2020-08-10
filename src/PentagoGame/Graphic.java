package PentagoGame;

import java.util.Scanner;

/**
 * This is a Class For Graphic Stuffs
 * @author Ahmad Foroughi
 * @version 1.0
 */
public class Graphic
{
    // colors unicode
    public static final String ANSI_BG_RED    = "\u001B[41m";
    public static final String ANSI_BG_GREEN  = "\u001B[42m";
    public static final String ANSI_BG_YELLOW = "\u001B[43m";
    public static final String ANSI_BG_BLUE   = "\u001B[44m";
    public static final String ANSI_BG_PURPLE = "\u001B[45m";
    public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_BRIGHT_BLACK  = "\u001B[90m";
    //BackGrounds array
    public static final String[] BACKGROUNDS = {ANSI_BG_RED,ANSI_BG_GREEN,ANSI_BG_BLUE,ANSI_BG_PURPLE};


    /**
     * Print Board
     * @param b1 take Block
     * @param b2 take Block
     * @param b3 take Block
     * @param b4 take Block
     */
    public static void printBoard(Block b1 , Block b2 , Block b3 , Block b4)
    {
        int plus = 0;
        System.out.print("====|1|============|2|======\n");
        loopForPrint(b1,b2,plus);
        System.out.print("====|3|============|4|======\n");
        plus +=2;
        loopForPrint(b3,b4,plus);
        System.out.print("============================\n");
    }

    public static void loopForPrint(Block left , Block right, int plus)
    {
        char[][] motherNumbers = new char[3][3];

            int num = 1;
            for (int i=0 ; i<3 ; i++)
            {
                for (int j=0 ; j<3 ; j++)
                {
                    motherNumbers[i][j] = String.valueOf(num).charAt(0);
                    num++;
                }
            }

        System.out.print(ANSI_BRIGHT_BLACK);
        for (int i =0 ; i<3 ; i++)
        {
            System.out.print(BACKGROUNDS[plus]+ANSI_BRIGHT_BLACK);
            for (int j=0 ; j<3 ; j++)
            {
                if (left.getHoles()[i][j] != '0')
                {
                    System.out.print(" "+left.getHoles()[i][j] + "  ");
                }
                else
                {
                    System.out.print(" "+ motherNumbers[i][j] + "  ");
                }

            }
            System.out.print(ANSI_RESET+ANSI_BRIGHT_BLACK);
            System.out.print(" | ");
            System.out.print(BACKGROUNDS[plus+1]+ANSI_BRIGHT_BLACK);
            for (int j=0 ; j<3 ; j++)
            {
                if (right.getHoles()[i][j] != '0')
                {
                    System.out.print(" "+right.getHoles()[i][j] + "  ");
                }
                else
                {
                    System.out.print(" "+ motherNumbers[i][j] + "  ");
                }
            }
            System.out.print(ANSI_RESET);
            System.out.print("\n");
        }
        System.out.print(ANSI_RESET+ANSI_BRIGHT_BLACK);
    }

    public static int mainMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To this Game...");
        System.out.println("1) Start a New Game");
        System.out.println("2) Exit");
        System.out.print("Please select your Option: ");
        int option = scanner.nextInt();
        return option;
    }

}
