
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

public interface GameListener
{
	void beforeApplyHand(OthelloGame game);
	void afterApplyHand(OthelloGame game);

	void gameOvered(OthelloGame game);
}
