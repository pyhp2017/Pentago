package PentagoGame;

import java.util.Scanner;

/**
 * This Class is for Running the game
 */
public class Run
{

    /**
     * Start The game
     */
    public static void start()
    {
        switch (Graphic.mainMenu())
        {
            case 1:
                //Start a new game
                MainBoard mainBoard = new MainBoard();
                Player player1 =  new Player("black",'●');
                Player player2 = new Player("white" , '○');
                Scanner scanner = new Scanner(System.in);
                boolean player1Turn = true;

                while (true)
                {
                    mainBoard.printBoard();
                    if (mainBoard.checkWin(player1) || mainBoard.checkWin(player2) || mainBoard.isFull())
                    {
                        if (mainBoard.checkWin(player1) && mainBoard.checkWin(player2))
                        {
                            System.out.print("You Both Won");
                        }
                        else if (mainBoard.checkWin(player1))
                        {
                            System.out.print("Player 1 Won");
                        }
                        else if (mainBoard.checkWin(player2))
                        {
                            System.out.print("Player 2 Won");
                        }
                        else
                        {
                            System.out.print("Nobody Won");
                        }

                        System.exit(0);
                    }
                    if (player1Turn)
                    {
                        turn(player1,mainBoard);
                        player1Turn = false;
                    }
                    else
                    {
                        turn(player2,mainBoard);
                        player1Turn = true;
                    }
                }

            case 2:
                //Exit
                System.exit(0);
                break;
            default:
                System.out.println("Wrong Option");
                System.exit(0);
                break;
        }

    }

    /**
     * Get coordinate and other things from player
     * @param player1 is a player (Player that is his/her turn)
     * @param mainBoard is Our mainBoard that we play on
     */
    public static void turn(Player player1 , MainBoard mainBoard)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(player1.getPlayerColor() +" Choose a Block & Choose a Coordinate (Ex: 1 5 --> left Up Center) : " );
        int blockNumber = Integer.parseInt(scanner.next());
        int coordinate = Integer.parseInt(scanner.next());
        int moveX=0;
        int moveY=0;
        switch (coordinate)
        {
            case 1:
                player1.addDisc(0+moveX,0+moveY,blockNumber,mainBoard);
                break;
            case 2:
                player1.addDisc(0+moveX,1+moveY,blockNumber,mainBoard);
                break;
            case 3:
                player1.addDisc(0+moveX,2+moveY,blockNumber,mainBoard);
                break;
            case 4:
                player1.addDisc(1+moveX,0+moveY,blockNumber,mainBoard);
                break;
            case 5:
                player1.addDisc(1+moveX,1+moveY,blockNumber,mainBoard);
                break;
            case 6:
                player1.addDisc(1+moveX,2+moveY,blockNumber,mainBoard);
                break;
            case 7:
                player1.addDisc(2+moveX,0+moveY,blockNumber,mainBoard);
                break;
            case 8:
                player1.addDisc(2+moveX,1+moveY,blockNumber,mainBoard);
                break;
            case 9:
                player1.addDisc(2+moveX,2+moveY,blockNumber,mainBoard);
                break;
        }
        Boolean win = mainBoard.checkWin(player1);
        if (!win)
        {
            System.out.print("\n1) Rotate Clock wise -- 2) Rotate counter Clock wise & your prefer block : ");
            int rotate = Integer.parseInt(scanner.next());
            int cBlock = Integer.parseInt(scanner.next());
            if (rotate == 1)
            {
                player1.rotateClock(cBlock,mainBoard);
            }
            else if (rotate == 2)
            {
                player1.rotateOpposite(cBlock,mainBoard);
            }
            else
            {
                System.out.println("Wrong Input");
            }
        }
        else
        {
            System.out.println("Player " + player1.getPlayerColor() + " Won");
            System.exit(0);
        }

    }
}
