package PentagoGame;

import java.util.ArrayList;

/**
 * This is a Player in Our Game
 * @version 1.0
 * @author Ahmad Foroughi
 */
public class Player
{
    //Player Sign
    private char sign;
    //Player Color Field
    private String playerColor;
    //Discs List
    ArrayList<Disc> discs;

    /**
     * Create a New Player
     * @param playerColor is Player Color (Ex: Black or White)
     * @param sign is Player Sign
     */
    public Player(String playerColor , char sign)
    {
        this.sign = sign;
        this.playerColor = playerColor;
        discs = new ArrayList<>();
    }

    /**
     * Add a new disc
     */
    public void addDisc(int x , int y, int blockNumber , MainBoard mainBoard)
    {
        boolean isExist = false;
        switch (blockNumber)
        {
            case 1:
                if (mainBoard.block1.getHoles()[x][y] != '0')
                {
                    isExist = true;
                }
                break;
            case 2:
                if (mainBoard.block2.getHoles()[x][y] != '0')
                {
                    isExist = true;
                }
                break;
            case 3:
                if (mainBoard.block3.getHoles()[x][y] != '0')
                {
                    isExist = true;
                }
                break;
            case 4:
                if (mainBoard.block4.getHoles()[x][y] != '0')
                {
                    isExist = true;
                }
                break;
        }
        if (!isExist)
        {
            discs.add(new Disc(x,y,blockNumber));
            mainBoard.setDisc(blockNumber,x,y,this.sign);
        }
    }

    /**
     * Rotate clock wise
     */
    public void rotateClock(int blockNumber , MainBoard mainBoard)
    {
        for (Disc disc : discs)
        {
            disc.setX(disc.getY());
            disc.setY(2 - disc.getX());
        }
        mainBoard.rotateClockWise(blockNumber);
    }
    /**
     * Rotate Opposite
     */
    public void rotateOpposite(int blockNumber , MainBoard mainBoard)
    {
        for (Disc disc : discs)
        {
            disc.setX(2- disc.getY());
            disc.setY(disc.getX());
        }
        mainBoard.rotateCounterClockWise(blockNumber);
    }

    /**
     * Set Player Color
     * @param playerColor is player Color field
     */
    public void setPlayerColor(String playerColor)
    {
        this.playerColor = playerColor;
    }
    /**
     * Get Player Color
     * @return playerColor
     */
    public String getPlayerColor()
    {
        return playerColor;
    }

    public char getSign() {
        return sign;
    }
}
