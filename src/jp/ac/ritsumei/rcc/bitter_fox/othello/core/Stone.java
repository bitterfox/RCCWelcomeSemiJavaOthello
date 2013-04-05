
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

public enum Stone
{
	BLACK, WHITE;

	public Stone reverse()
	{
		return this == BLACK ? WHITE : BLACK;
	}

	public boolean isWhite()
	{
		return this == WHITE;
	}

	public boolean isBlack()
	{
		return this == BLACK;
	}

	public void requireEquals(Stone target)
	{
		if (!this.equals(target))
		{
			throw new IllegalStateException("Illegal Stone: required " + target);
		}
	}
}
