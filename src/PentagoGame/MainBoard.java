package PentagoGame;

/**
 * This is Our Main Board in This Game
 * @version 1.0
 * @author Ahmad Foroughi
 */
public class MainBoard extends  Logic
{

    /**
     * Create a new MainBoard (You Can Only Create One Main Board in a Same Time)
     */
    public MainBoard()
    {
        block1 = new Block(1);
        block2 = new Block(2);
        block3 = new Block(3);
        block4 = new Block(4);
    }

    /**
     * Print Board
     */
    public void printBoard()
    {
        Graphic.printBoard(block1,block2,block3,block4);
    }

    /**
     * Set Disc Main Board
     */
    public void setDisc(int blockNumber , int x, int y, char playerSign)
    {
        switch (blockNumber)
        {
            case 1:
                //Block 1
                block1.addDisc(x,y,playerSign);
                break;
            case 2:
                //Block 2
                block2.addDisc(x,y,playerSign);
                break;
            case 3:
                //Block 3
                block3.addDisc(x,y,playerSign);
                break;
            case 4:
                //Block 4
                block4.addDisc(x,y,playerSign);
                break;

        }
    }

    /**
     * Rotate Clockwise
     */
    public void rotateClockWise(int blockNumber)
    {
        switch (blockNumber)
        {
            case 1:
                block1.rotateClock();
                break;
            case 2:
                block2.rotateClock();
                break;
            case 3:
                block3.rotateClock();
                break;
            case 4:
                block4.rotateClock();
                break;
        }
    }

    /**
     * Rotate counterClockWise
     */
    public void rotateCounterClockWise(int blockNumber)
    {
        switch (blockNumber)
        {
            case 1:
                block1.oppositeRotate();
                break;
            case 2:
                block2.oppositeRotate();
                break;
            case 3:
                block3.oppositeRotate();
                break;
            case 4:
                block4.oppositeRotate();
                break;
        }
    }



}
