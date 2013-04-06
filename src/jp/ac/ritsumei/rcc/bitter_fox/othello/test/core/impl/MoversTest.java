package jp.ac.ritsumei.rcc.bitter_fox.othello.test.core.impl;

import java.lang.reflect.*;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ac.ritsumei.rcc.bitter_fox.othello.core.*;
import static jp.ac.ritsumei.rcc.bitter_fox.othello.core.LineType.*;

public class MoversTest
{
	@Test
	public void testGetMover() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Class<?> classMovers = Class.forName("jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl.Movers");
		Method Movers$getMover = classMovers.getMethod("getMover", LineType.class);
		Movers$getMover.setAccessible(true);

		Class<?> classMover = Class.forName("jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl.Mover");
		Method Mover$nextX = classMover.getMethod("nextX", int.class);
		Method Mover$nextY = classMover.getMethod("nextY", int.class);
		Mover$nextX.setAccessible(true);
		Mover$nextY.setAccessible(true);

		LineType[][] types =
			{
				{WHITE_UP, UP, BLACK_UP},
				{LEFT, null, RIGHT},
				{BLACK_DOWN, DOWN, WHITE_DOWN}
			};

		for (LineType type : LineType.values())
		{
			Object mover = Movers$getMover.invoke(null, type);

			assertEquals(types[(int)Mover$nextY.invoke(mover, 1)][(int)Mover$nextX.invoke(mover, 1)], type);
		}
		try
		{
			Movers$getMover.invoke(null, new Object[]{null});
			fail("would be NullPointerException");
		}
		catch (InvocationTargetException e)
		{
			if (e.getCause().getClass() != NullPointerException.class)
			{
				fail("wouldn't be Exception but NullPointerException");
			}
		}
		catch (Exception e) {fail("wouldn't be Exception but NullPointerException");}
	}
}
