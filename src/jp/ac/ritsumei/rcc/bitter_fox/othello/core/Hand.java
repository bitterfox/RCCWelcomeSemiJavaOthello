
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

import java.util.*;

import jp.ac.ritsumei.rcc.bitter_fox.othello.util.*;

public class Hand
{
    private Stone stone;
    private boolean pass;
    private At at;

    public Hand(Stone stone, At at)
    {
        Objects.requireNonNull(stone);
        Objects.requireNonNull(at);

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

    public String toString()
    {
        return pass ? "PASS" : stone.toString() + at.toString();
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        Hand hand = null;

        if (obj == null || !(obj instanceof Hand))
        {
            return false;
        }

        hand = (Hand)obj;
        if (pass == hand.pass && stone == hand.stone)
        {
            return true;
        }

        return stone == hand.stone && at.equals(hand.at);
    }

    public int hashCode()
    {
        return pass ? Objects.hash(pass, stone) : Objects.hash(pass, stone, at);
    }
}
