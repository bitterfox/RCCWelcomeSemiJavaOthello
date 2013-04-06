package jp.ac.ritsumei.rcc.bitter_fox.othello.test.util;

import static org.junit.Assert.*;
import jp.ac.ritsumei.rcc.bitter_fox.othello.util.At;

import org.junit.Test;

public class AtTest
{
	private static final int BASE_X = 1;
	private static final int BASE_Y = 3;
	private static final At BASE = new At(BASE_X, BASE_Y);

	@Test
	public void testHashCode()
	{
		// TODO: needed?
		// see Javadoc of Object#hashCode

		assertEquals(BASE.hashCode(), BASE.hashCode());
		assertEquals(new At(BASE).hashCode(), BASE.hashCode());
	}

	@Test
	public void testAtAt()
	{
		At at = new At(BASE);

		assertEquals(BASE, at);

		try
		{
			new At(null);
			fail("would be NullPointerException");
		}
		catch (NullPointerException e) {}
		catch (Exception e) {fail("wouldn't be Exception but NullPointerException");}
	}

	@Test
	public void testAtIntInt()
	{
		// TODO: needed?
	}

	@Test
	public void testGetX()
	{
		assertSame(BASE.getX(), BASE_X);
	}

	@Test
	public void testGetY()
	{
		assertSame(BASE.getY(), BASE_Y);
	}

	@Test
	public void testClone()
	{
		// TODO: needed?(というかそもそもObject#cloneの三条件は必須じゃない)
		// see Javadoc of Object#clone

		At cloned = BASE.clone();

		assertNotSame(cloned, BASE);
		assertSame(cloned.getClass(), BASE.getClass());
		assertEquals(cloned, BASE);
	}

	@Test
	public void testEqualsObject() {
		assertFalse(BASE.equals(null));
		assertFalse(BASE.equals(""));
		assertEquals(BASE, BASE);
		assertEquals(BASE, new At(BASE_X, BASE_Y));
	}

	@Test
	public void testToString()
	{
		// TODO: needed?
	}

}
