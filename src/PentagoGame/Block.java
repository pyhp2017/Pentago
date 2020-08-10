package PentagoGame;

/**
 * This is a Block in Our Game
 */
public class Block {
    //Block Number Field
    private int blockNumber;
    //Block Array
    private char[][] holes;

    /**
     * Create a new Block
     * @param blockNumber is Block Specific Number
     */
    public Block(int blockNumber)
    {
        this.holes = new char[3][3];
        this.blockNumber = blockNumber;
        putNormal();
    }

    /**
     * Get Block Specific Number
     * @return blockNumber
     */
    public int getBlockNumber() {
        return blockNumber;
    }

    /**
     * Get Holes Array
     * @return holes
     */
    public char[][] getHoles() {
        return holes;
    }

    /**
     * Set Holes array
     * @param holes is an array
     */
    public void setHoles(char[][] holes) {
        this.holes = holes;
    }

    /**
     * Set Every Holes to 0
     */
    public void putNormal()
    {



//        int num = 1;
        for (int i=0 ; i<3 ; i++)
        {
            for (int j=0 ; j<3 ; j++)
            {
//                this.holes[i][j] = String.valueOf(num).charAt(0);
                this.holes[i][j] = '0';
//                num++;
            }
        }
    }


    /**
     * Add Disc
     */
    public void addDisc(int x , int y , char sign)
    {
            holes[x][y] = sign;
    }

    public void rotateClock()
    {
        char[][] temp = new char[3][3];
        for (int i =0 ; i< temp.length ; i++)
        {
            for(int j =0 ; j< temp.length; j++)
            {
                    temp[j][2-i] = holes[i][j];
            }
        }
        holes = temp;
    }

    public void oppositeRotate()
    {
        char[][] temp = new char[3][3];
        for (int i =0 ; i< temp.length ; i++)
        {
            for(int j =0 ; j< temp.length; j++)
            {
                    temp[2-j][i] = holes[i][j];
            }
        }
        holes = temp;
    }

    public boolean isFullInBlock()
    {
        for (int i =0 ;i<3 ; i++)
        {
            for (int j =0 ;j<3 ; j++)
            {
                if (this.holes[i][j] == '0')
                {
                    return false;
                }
            }
        }
        return true;
    }


}
