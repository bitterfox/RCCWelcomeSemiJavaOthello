
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

public interface OthelloSystem
{
    OthelloGame createOthelloGame(Player black, Player white);

    OthelloBoard createOthelloBoard();
    OthelloBoard createOthelloBoard(Stone[][] board);

    Reverser createReverser();
}
