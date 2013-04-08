
package jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl;

import java.util.*;

import jp.ac.ritsumei.rcc.bitter_fox.othello.core.*;
import jp.ac.ritsumei.rcc.bitter_fox.othello.util.*;

public class OthelloBoardImpl implements OthelloBoard
{
	private final Stone[][] board = new Stone[HEIGHT][WIDTH];
	private OthelloSystem system;

	public OthelloBoardImpl()
	{
	}

	public OthelloBoardImpl(Stone[][] srcBoard)
	{
		this.checkBoard(srcBoard);

		for (int y = 0; y < HEIGHT; y++)
		{
			System.arraycopy(srcBoard[y], 0, this.board[y], 0, WIDTH);
		}
	}

	private void checkBoard(Stone[][] board)
	{
		Objects.requireNonNull(board);

		if (board.length != HEIGHT)
		{
			throw new IllegalArgumentException("Illegal size(board): " + board.length);
		}

		for (int y = 0; y < HEIGHT; y++)
		{
			Objects.requireNonNull(board[y]);
			if (board[y].length != WIDTH)
			{
				throw new IllegalArgumentException("Illegal size(board[" + y + "]): " + board[y].length);
			}
		}
	}

	public void initialize()
	{
		for (int i = 0; i < board.length; i++)
		{
			Arrays.fill(board[i], null);
		}

		board[3][3] = board[4][4] = Stone.WHITE;
		board[3][4] = board[4][3] = Stone.BLACK;
	}

	public void putStone(Hand hand)
	{
		Objects.requireNonNull(hand);

		if (!hand.isPass())
		{
			this.checkPutable(hand.getStone(), hand.getAt());

			Reverser reverser = system.createReverser();
			for (LineType type : LineType.values())
			{
				reverser.reverseWithNext(this.getLine(type, hand.getAt()), hand.getStone());
			}

			board[hand.getAt().getY()][hand.getAt().getX()] = hand.getStone();
		}
	}

	private void checkPutable(Stone stone, At at)
	{
		if (!this.isPutable(stone, at))
		{
			throw new IllegalStateException("Illegal put at" + at.toString());
		}
	}

	public boolean isPutable(Stone stone, At at)
	{
		Objects.requireNonNull(stone);
		this.checkAt(at);

		Reverser reverser = system.createReverser();

		for (LineType type : LineType.values())
		{
			Line line = this.getLine(type, at);
			if (reverser.isReverseableWithNext(line, stone))
			{
				return true;
			}
		}

		return false;
	}

	private void checkAt(At at)
	{
		int x = at.getX(), y = at.getY();

		if (!(0 <= x && x < WIDTH))
		{
			throw new IllegalArgumentException("illegal x: " + x);
		}

		if (!(0 <= y && y < HEIGHT))
		{
			throw new IllegalArgumentException("illegal y: " + y);
		}
	}

	public boolean isPutable(Stone stone, int x, int y)
	{
		return this.isPutable(stone, new At(x, y));
	}

	public At[] getPutableAts(Stone stone)
	{
		Objects.requireNonNull(stone);
		List<At> list = new LinkedList<>();

		for (int y = 0; y < HEIGHT; y++)
		{
			for (int x = 0; x < WIDTH; x++)
			{
				if (board[y][x] == null && this.isPutable(stone, x, y))
				{
					list.add(new At(x, y));
				}
			}
		}

		return list.toArray(new At[0]);
	}

	public Stone getStone(At at)
	{
		Objects.requireNonNull(at);
		this.checkAt(at);

		return board[at.getY()][at.getX()];
	}

	public Stone getStone(int x, int y)
	{
		return this.getStone(new At(x, y));
	}

	public int countStone(Stone stone)
	{
		int sum = 0;

		for (int y = 0; y < HEIGHT; y++)
		{
			for (int x = 0; x < WIDTH; x++)
			{
				if (board[y][x] == stone)
				{
					sum++;
				}
			}
		}

		return sum;
	}

	private class LineImpl implements Line
	{
		private LineType type;
		private int curX, curY;
		private int lastX = -1, lastY = -1;
		private Mover mover;

		private LineImpl(LineType type, At at)
		{
			Objects.requireNonNull(type);
			Objects.requireNonNull(at);

			this.type = type;
			curX = at.getX();
			curY = at.getY();
			this.mover = Movers.getMover(type);
		}

		public LineType getType()
		{
			return type;
		}

		public Stone next()
		{
			Stone stone = board[curY][curX];

			lastX = curX;
			lastY = curY;
			curX = mover.nextX(curX);
			curY = mover.nextY(curY);

			return stone;
		}

		public boolean hasNext()
		{
			return 0 <= curX && curX < WIDTH && 0 <= curY && curY < HEIGHT;
		}

		public void skipNext(int n)
		{
			while (n-- > 0)
			{
				next();
			}
		}

		public Stone back()
		{
			curX = mover.backX(curX);
			curY = mover.backY(curY);
			lastX = curX;
			lastY = curY;

			return board[curY][curX];
		}

		public boolean hasBack()
		{
			int backX = mover.backX(curX), backY = mover.backY(curY);

			return 0 <= backX && backX < WIDTH && 0 <= backY && backY < HEIGHT;
		}

		public void skipBack(int n)
		{
			while (n-- > 0)
			{
				back();
			}
		}

		public Stone getStone()
		{
			return board[curY][curX];
		}

		public void reverse()
		{
			if (lastX == -1 || lastY == -1)
			{
				throw new IllegalStateException();
			}

			if (board[lastY][lastX] != null)
			{
				board[lastY][lastX] = board[lastY][lastX].reverse();
			}
		}

		public At getAt()
		{
			return new At(curX, curY);
		}
	}

	public Line getLine(LineType type, At at)
	{
		return new LineImpl(type, at);
	}

	public void setOthelloSystem(OthelloSystem system)
	{
		Objects.requireNonNull(system);

		this.system = system;
	}

	public Stone[][] toArray()
	{
		Stone[][] dest = new Stone[HEIGHT][WIDTH];

		for (int y = 0; y < HEIGHT; y++)
		{
			System.arraycopy(board[y], 0, dest[y], 0, WIDTH);
		}

		return dest;
	}
}
