
package jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl;

import jp.ac.ritsumei.rcc.bitter_fox.othello.core.*;

public class ReverserImpl implements Reverser
{
	private static final Reverser instance = new ReverserImpl();

	private ReverserImpl()
	{
	}

	public static Reverser getInstance()
	{
		return instance;
	}

	public void reverseWithNext(Line line, Stone side)
	{
		if (this.isReverseableWithNext(line, side))
		{
			int i = 0;

			line.next();i++;
			while (line.hasNext())
			{
				Stone stone = line.next();
				if (stone == side)
				{
					break;
				}
				line.reverse();
			}

			line.skipBack(i);
		}
	}

	public boolean isReverseableWithNext(Line line, Stone side)
	{
		int i = 0;

		if (!line.hasNext())
		{
			return false;
		}
		line.next(); i++;

		if (!line.hasNext())
		{
			line.skipBack(i);
			return false;
		}
		Stone stone = line.next();i++;

		if (stone != side.reverse())
		{
			line.skipBack(i);
			return false;
		}

		while (line.hasNext())
		{
			stone = line.next(); i++;
			if (stone == side)
			{
				line.skipBack(i);
				return true;
			}
			else if (stone == null)
			{
				line.skipBack(i);
				return false;
			}
		}

		line.skipBack(i);
		return false;
	}
}
