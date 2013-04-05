
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

public interface Reverser
{
	void reverseWithNext(Line line, Stone stone);
	boolean isReverseableWithNext(Line line, Stone stone);
}
