
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

public interface Player
{
    Stone getStone();
    Hand next(OthelloGame game);
}
