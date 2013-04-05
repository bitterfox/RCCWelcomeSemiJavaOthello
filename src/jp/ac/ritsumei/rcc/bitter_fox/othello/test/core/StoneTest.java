package jp.ac.ritsumei.rcc.bitter_fox.othello.test.core;

import static org.junit.Assert.*;

import jp.ac.ritsumei.rcc.bitter_fox.othello.core.Stone;

import org.junit.Test;

import static jp.ac.ritsumei.rcc.bitter_fox.othello.core.Stone.WHITE;
import static jp.ac.ritsumei.rcc.bitter_fox.othello.core.Stone.BLACK;

public class StoneTest
{
	@Test
	public void testReverse()
	{
		assertEquals(WHITE.reverse(), BLACK);
		assertEquals(BLACK.reverse(), WHITE);

		assertEquals(WHITE.reverse().reverse(), WHITE);
		assertEquals(BLACK.reverse().reverse(), BLACK);

		assertSame(WHITE.reverse(), BLACK);
		assertSame(BLACK.reverse(), WHITE);

		assertSame(WHITE.reverse().reverse(), WHITE);
		assertSame(BLACK.reverse().reverse(), BLACK);
	}

	@Test
	public void testIsWhite()
	{
		assertTrue(WHITE.isWhite());
		assertFalse(BLACK.isWhite());
	}

	@Test
	public void testIsBlack()
	{
		assertTrue(BLACK.isBlack());
		assertFalse(WHITE.isBlack());
	}

	@Test
	public void testRequireEquals()
	{
		try
		{
			WHITE.requireEquals(WHITE);
		}
		catch (Exception e)
		{
			fail("wouldn't be an exception");
		}
		try
		{
			BLACK.requireEquals(BLACK);
		}
		catch (Exception e)
		{
			fail("wouldn't be an exception");
		}

		try
		{
			BLACK.requireEquals(WHITE);
			fail("would be an exception");
		}
		catch (Exception e) {}
		try
		{
			WHITE.requireEquals(BLACK);
			fail("would be an exception");
		}
		catch (Exception e) {}
	}
}
