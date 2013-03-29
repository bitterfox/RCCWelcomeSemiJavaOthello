
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

public interface Line
{
    public LineType getType();

    public void next();
    public boolean hasNext();
    public void back();
    public boolean hasBack();

    public Stone getStone();
    public void reverse();
}
