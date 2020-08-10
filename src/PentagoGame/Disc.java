package PentagoGame;

/**
 * This is a Disc in Our Game
 * @author Ahmad Foroughi
 * @version 1.0
 */
public class Disc
{
    //Position X:
    private int x;
    //Position Y:
    private int y;
    //Block Field (1 , 2 , 3 , 4)
    private int block;

    /**
     * Create a New Disc
     * @param x  is x field
     * @param y is y field
     * @param block is block field
     */
    public Disc(int x , int y , int block)
    {
        this.x = x;
        this.y = y;
        this.block = block;
    }

    /**
     * Get X
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Set X
     * @param x is x Field
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get Y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Set y
     * @param y is y field
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get Block
     * @return block
     */
    public int getBlock() {
        return block;
    }

    /**
     * Set Block
     * @param block is block field
     */
    public void setBlock(int block) {
        this.block = block;
    }
}
