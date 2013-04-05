
package jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl;

interface Mover
{
	int nextX(int x);
	int nextY(int y);
	int backX(int x);
	int backY(int y);
}
