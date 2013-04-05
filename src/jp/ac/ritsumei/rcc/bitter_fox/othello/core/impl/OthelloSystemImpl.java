
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
		return new OthelloGameImpl(this.createOthelloBoard(), black, white);
	}

	public OthelloBoard createOthelloBoard()
	{
		OthelloBoard board = new OthelloBoardImpl();

		board.initialize();

		return board;
	}

	public OthelloBoard createOthelloBoard(Stone[][] board)
	{
		return new OthelloBoardImpl(board);
	}

	public Reverser createReverser()
	{
		return ReverserImpl.getInstance();
	}
}
