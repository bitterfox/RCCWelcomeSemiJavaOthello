
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

public interface OthelloGame
{
    OthelloBoard getOthelloBoard();
    Player getNextPlayer();
    Player[] getPlayers();
    Judger getJudger();
    boolean continueable();
}
