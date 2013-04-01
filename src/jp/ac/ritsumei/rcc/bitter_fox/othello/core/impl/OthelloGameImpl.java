
package jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl;

import java.util.*;

import jp.ac.ritsumei.rcc.bitter_fox.othello.core.*;
import jp.ac.ritsumei.rcc.bitter_fox.othello.util.*;

public class OthelloGameImpl implements OthelloGame
{
    private OthelloBoard board;
    private Map<Stone, Player> players = new EnumMap<>(Stone.class);
    private Stone nextStone = Stone.BLACK;
    private Hand lastHand;
    private boolean gameOvered = false;
    private List<GameListener> gameListeners = new LinkedList<>();

    public OthelloGameImpl(OthelloBoard board, Player black, Player white)
    {
        this.board = board;
        players.put(Stone.BLACK, black);
        players.put(Stone.WHITE, white);
    }

    public OthelloBoard getOthelloBoard()
    {
        return board;
    }

    public void setPlayer(Player player)
    {
        Objects.requireNonNull(player);
        Objects.requireNonNull(player.getStone());

        players.put(player.getStone(), player);
    }

    public Stone getNextStone()
    {
        return nextStone;
    }

    public Player getNextPlayer()
    {
        return players.get(nextStone);
    }

    public Player[] getPlayers()
    {
        return players.values().toArray(new Player[0]);
    }

    public boolean next()
    {
        this.checkNotGameOvered(); // ゲームオーバでないことをチェック
        nextStone.requireEquals(this.getNextPlayer().getStone());

        Hand hand = this.getNextPlayer().next(this); // 次の手を作成

        Objects.requireNonNull(hand); // hand != null
        nextStone.requireEquals(hand.getStone());

        this.callBeforeApplyHand();

        this.lastHand = hand;

        if (!hand.isPass())
        {
            this.checkPutable(hand.getStone(), hand.getAt());

            board.putStone(hand);
        }

        nextStone = nextStone.reverse();

        this.callAfterApplyHand();

        // ゲームオーバかを調べる
        if (board.getPutableAts(Stone.WHITE).length == 0 && board.getPutableAts(Stone.BLACK).length == 0)
        {
            gameOvered = true;
            this.callGameOvered();
        }

        return !gameOvered;
    }

    private void checkNotGameOvered()
    {
        if (gameOvered)
        {
            throw new IllegalStateException("Game overed");
        }
    }

    private void checkPutable(Stone stone, At at)
    {
        if (!board.isPutable(stone, at))
        {
            throw new IllegalArgumentException("Illegal hand");
        }
    }

    public Hand getLastHand()
    {
        return lastHand;
    }

    public boolean isGameOvered()
    {
        return gameOvered;
    }

    public Result getResult()
    {
        int black = board.countStone(Stone.BLACK), white = board.countStone(Stone.WHITE);

        if (black == white)
        {
            return Result.DRAW;
        }
        else if (black > white)
        {
            return Result.BLACK;
        }
        else
        {
            return Result.WHITE;
        }
    }

    public void addGameListener(GameListener listener)
    {
        Objects.requireNonNull(listener);

        gameListeners.add(listener);
    }

    public void removeGameListener(GameListener listener)
    {
        gameListeners.remove(listener);
    }

    private void callBeforeApplyHand()
    {
        for (GameListener listener : gameListeners)
        {
            listener.beforeApplyHand(this);
        }
    }

    private void callAfterApplyHand()
    {
        for (GameListener listener : gameListeners)
        {
            listener.afterApplyHand(this);
        }
    }

    private void callGameOvered()
    {
        for (GameListener listener : gameListeners)
        {
            listener.gameOvered(this);
        }
    }
}
