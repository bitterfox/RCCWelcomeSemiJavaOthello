
package jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl;

import jp.ac.ritsumei.rcc.bitter_fox.othello.core.*;

public class OthelloSystemImpl implements OthelloSystem
{
	private static final OthelloSystemImpl instance = new OthelloSystemImpl();

	private OthelloSystemImpl()
	{
	}

	public static OthelloSystemImpl getInstance()
	{
		return instance;
	}

	public OthelloGame createOthelloGame(Player black, Player white)
	{
		OthelloGame game = new OthelloGameImpl(this.createOthelloBoard(), black, white);

		game.setOthelloSystem(this);

		return game;
	}

	public OthelloBoard createOthelloBoard()
	{
		OthelloBoard board = new OthelloBoardImpl();

		board.initialize();

		board.setOthelloSystem(this);

		return board;
	}

	public OthelloBoard createOthelloBoard(Stone[][] stones)
	{
		OthelloBoard board = new OthelloBoardImpl(stones);

		board.setOthelloSystem(this);

		return board;
	}

	public Reverser createReverser()
	{
		return ReverserImpl.getInstance();
	}
}
