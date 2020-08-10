package PentagoGame;

/**
 * This is Logic Class
 * Alli Stuffs about how game works is here
 */
public class Logic
{

    //Blocks Fields
    protected Block block1;
    protected Block block2;
    protected Block block3;
    protected Block block4;

    /**
     * @param block is Main Block
     * @param corner is Corner Block
     * @param sign is Player Sign
     * @param flag is Flag for check some important things
     * @return true or false
     */
    public boolean checkHoriz(Block block , Block corner, char sign , boolean flag)
    {
        int count = 0;
        for (int i =0 ; i< 3 ; i++)
        {
            for (int j = 0 ; j< 3 ; j++)
            {
                if (block.getHoles()[i][j] == sign)
                {
                    count++;
                }
                else
                {
                    count = 0;
                }
            }
            if (count == 3)
            {
                if (flag)
                {
                    for (int j = 0; j<3 ; j++)
                    {
                        if (corner.getHoles()[i][j] == sign)
                        {
                            count++;
                        }
                        else
                        {
                            count = 0;
                        }
                        if (count == 5)
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    for (int j = 2; j>=0 ; j--)
                    {
                        if (corner.getHoles()[i][j] == sign)
                        {
                            count++;
                        }
                        else
                        {
                            count = 0;
                        }
                        if (count == 5)
                        {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    /**
     * @param block is Main Block
     * @param corner is Corner Block
     * @param sign is Player Sign
     * @param flag is Flag for check some important things
     * @return true or false
     */
    public boolean checkVertical(Block block, Block corner , char sign , boolean flag)
    {
        int count = 0;
        for (int j = 0; j < 3; j++)
        {
            for (int i =0 ; i<3 ; i++)
            {
                if (block.getHoles()[i][j] == sign)
                {
                    count++;
                }
                else
                {
                    count = 0;
                }
            }

            if (count == 3)
            {
                if (flag)
                {
                    for (int i =0 ; i<3 ; i++)
                    {
                        if (corner.getHoles()[i][j] == sign)
                        {
                            count++;
                        }
                        else
                        {
                            count = 0;
                        }
                        if (count == 5)
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    for (int i =2 ; i>=0 ; i--)
                    {
                        if (corner.getHoles()[i][j] == sign)
                        {
                            count++;
                        }
                        else
                        {
                            count = 0;
                        }
                        if (count == 5)
                        {
                            return true;
                        }
                    }
                }

            }

        }
        return false;
    }

    /**
     * @param block is Main Block
     * @param corner is Corner Block
     * @param sign is Player Sign
     * @param flag is Flag for check some important things
     * @return true or false
     */
    public boolean checkOrib1(Block block, Block corner , char sign , boolean flag)
    {
        int count = 0;
        if (block.getHoles()[0][0] == sign && block.getHoles()[1][1] == sign &&block.getHoles()[2][2] == sign)
        {
            count = 3;
        }
        if (count == 3)
        {
            if (flag)
            {
                if (corner.getHoles()[0][0] == sign && corner.getHoles()[1][1] == sign)
                {
                    count = 5;
                    if (count == 5)
                    {
                        return true;
                    }
                }
            }
            else
            {
                if (corner.getHoles()[2][2] == sign && corner.getHoles()[1][1] == sign)
                {
                    count = 5;
                    if (count == 5)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param block is Main Block
     * @param corner is Corner Block
     * @param sign is Player Sign
     * @param flag is Flag for check some important things
     * @return true or false
     */
    public boolean checkOrib2(Block block, Block corner , char sign , boolean flag)
    {
        int count = 0;
        if (block.getHoles()[0][2] == sign && block.getHoles()[1][1] == sign &&block.getHoles()[2][0] == sign)
        {
            count = 3;
        }
        if (count == 3)
        {
            if (flag)
            {
                if (corner.getHoles()[0][2] == sign && corner.getHoles()[1][1] == sign)
                {
                    count = 5;
                    if (count == 5)
                    {
                        return true;
                    }
                }
            }
            else
            {
                if (corner.getHoles()[2][0] == sign && corner.getHoles()[1][1] == sign)
                {
                    count = 5;
                    if (count == 5)
                    {
                        return true;
                    }
                }

            }
        }
        return false;

    }

    /**
     * Check if Player won or not
     * @param player is a Player
     * @return true or false
     */
    public boolean checkWin(Player player)
    {
        if ((checkHoriz(this.block1,this.block2,player.getSign() , true) || checkHoriz(this.block2,this.block1,player.getSign() , false)) || (checkHoriz(this.block3,this.block4,player.getSign() , true) || checkHoriz(this.block4,this.block3,player.getSign() , false)))
        {
            return true;
        }
        if (checkVertical(this.block1,this.block3,player.getSign() , true) || checkVertical(this.block2,this.block4,player.getSign() , true) || checkVertical(this.block4,this.block2,player.getSign() , false) || checkVertical(this.block3,this.block1,player.getSign() , false)  )
        {
            return true;
        }
        if (checkOrib1(this.block1,this.block4,player.getSign() , true) || checkOrib1(this.block4,this.block1,player.getSign() , false))
        {
            return true;
        }
        if (checkOrib2(this.block2,this.block3,player.getSign() , true) || checkOrib2(this.block3,this.block2,player.getSign() , false)  )
        {
            return true;
        }

        return false;
    }

    /**
     * Check if blocks are full
     * @return true or false
     */
    public boolean isFull()
    {
        if (block1.isFullInBlock() && block2.isFullInBlock() && block3.isFullInBlock() && block4.isFullInBlock())
        {
            return true;
        }
        return false;
    }
}
