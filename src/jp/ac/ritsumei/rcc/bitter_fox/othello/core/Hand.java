
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

import jp.ac.ritsumei.rcc.bitter_fox.othello.util.*;

public class Hand
{
    private Stone stone;
    private boolean pass;
    private At at;

    public Hand(Stone stone, At at)
    {
        this.stone = stone;
        this.pass = false;
        this.at = at;
    }

    private Hand(Stone stone)
    {
        this.stone = stone;
        this.pass = true;
    }

    public static Hand createPassHand(Stone stone)
    {
        return new Hand(stone);
    }

    public Stone getStone()
    {
        return stone;
    }

    public boolean isPass()
    {
        return pass;
    }

    public At getAt()
    {
        return at;
    }
}
