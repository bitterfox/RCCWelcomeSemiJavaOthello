
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

import jp.ac.ritsumei.rcc.bitter_fox.othello.util.At;

public interface Line
{
	public LineType getType();

	public Stone next();
	public boolean hasNext();
	public void skipNext(int n); // TODO: default impl
	public Stone back();
	public boolean hasBack();
	public void skipBack(int n); // TODO: default impl

	public void reverse();

	public At getAt();
}
