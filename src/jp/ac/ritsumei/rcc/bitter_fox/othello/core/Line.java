
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

public interface Line
{
	public LineType getType();

	public void next();
	public boolean hasNext();
	public void skipNext(int n); // TODO: default impl
	public void back();
	public boolean hasBack();
	public void skipBack(int n); // TODO: default impl

	public Stone getStone();
	public void reverse();
}
