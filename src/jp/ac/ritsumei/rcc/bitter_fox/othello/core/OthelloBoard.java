
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

import jp.ac.ritsumei.rcc.bitter_fox.othello.util.*;

public interface OthelloBoard
{
    int WIDTH = 8, HEIGHT = 8;

    void initialize();

    void putStone(Hand hand);

    Hand getLastHand();

    boolean isPutable(Stone stone, At at);
    boolean isPutable(Stone stone, int x, int y); // TODO: default

    At[] getPutableAts(Stone stone);

    Stone getStone(At at);
    Stone getStone(int x, int y); // TODO: default

    int countStone(Stone stone);

    Line getLine(LineType type, At at);

    Stone[][] toArray();
}
