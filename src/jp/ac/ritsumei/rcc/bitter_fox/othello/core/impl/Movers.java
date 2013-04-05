
package jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl;

import java.util.*;

import jp.ac.ritsumei.rcc.bitter_fox.othello.core.*;

class Movers
{
	private static final Map<LineType, Mover> movers = new EnumMap<>(LineType.class);

	static
	{
		movers.put(LineType.UP,         new MoverImpl(0,  -1));
		movers.put(LineType.DOWN,       new MoverImpl(0,  1));
		movers.put(LineType.LEFT,       new MoverImpl(-1, 0));
		movers.put(LineType.RIGHT,      new MoverImpl(1,  0));
		movers.put(LineType.BLACK_UP,   new MoverImpl(1,  -1));
		movers.put(LineType.BLACK_DOWN, new MoverImpl(-1, 1));
		movers.put(LineType.WHITE_UP,   new MoverImpl(-1, -1));
		movers.put(LineType.WHITE_DOWN, new MoverImpl(1,  1));
	}

	public static Mover getMover(LineType type)
	{
		Objects.requireNonNull(type);
		return movers.get(type);
	}
}
