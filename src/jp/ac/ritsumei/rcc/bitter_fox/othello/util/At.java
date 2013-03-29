
package jp.ac.ritsumei.rcc.bitter_fox.othello.util;

public class At implements Cloneable
{
    private int x, y;

    public At(At at)
    {
        this.x = at.x;
        this.y = at.y;
    }

    public At(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public At clone()
    {
        At clone = null;

        try
        {
            clone = (At)super.clone();
        }
        catch (CloneNotSupportedException e) {}

        return clone;
    }
}
