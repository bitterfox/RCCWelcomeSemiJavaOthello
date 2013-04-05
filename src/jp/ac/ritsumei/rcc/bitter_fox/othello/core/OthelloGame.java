
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

public interface OthelloGame extends Othelloable
{
    OthelloBoard getOthelloBoard();
    void setPlayer(Player player);
    Stone getNextStone();
    Player getNextPlayer();
    Player[] getPlayers();
    boolean next();
    Hand getLastHand();
    boolean isGameOvered();
    Result getResult();

    void addGameListener(GameListener listener);
    void removeGameListener(GameListener listener);
}
