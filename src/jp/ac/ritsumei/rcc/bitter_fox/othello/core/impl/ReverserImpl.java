
package jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl;

import jp.ac.ritsumei.rcc.bitter_fox.othello.core.*;

public class ReverserImpl implements Reverser
{
    private static final Reverser instance = new ReverserImpl();

    private ReverserImpl()
    {
    }

    public static Reverser getInstance()
    {
        return instance;
    }

    public void reverseWithNext(Line line, Stone stone)
    {
        if (isReverseableWithNext(line, stone))
        {
            int i = 0;
            while (line.hasNext())
            {
                line.next();i++;
                if (line.getStone() == stone)
                {
                    break;
                }
                line.reverse();
            }

            while (i-- > 0)
            {
                line.back();
            }
        }
    }

    public boolean isReverseableWithNext(Line line, Stone stone)
    {
        int i = 0;

        if (!line.hasNext())
        {
            return false;
        }

        line.next(); i++;
        if (line.getStone() != stone.reverse())
        {
            while (i-- > 0)
            {
                line.back();
            }
            return false;
        }

        while (line.hasNext())
        {
            line.next(); i++;
            if (line.getStone() == stone)
            {
                while (i-- > 0)
                {
                    line.back();
                }
                return true;
            }
            else if (line.getStone() == null)
            {
                while (i-- > 0)
                {
                    line.back();
                }
                return false;
            }
        }

        while(i-- > 0)
        {
            line.back();
        }
        return false;
    }
}
