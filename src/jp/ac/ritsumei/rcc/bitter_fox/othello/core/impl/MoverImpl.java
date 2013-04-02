
package jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl;

class MoverImpl implements Mover
{
    int diffNextX, diffNextY;

    public MoverImpl(int diffNextX, int diffNextY)
    {
        this.diffNextX = diffNextX;
        this.diffNextY = diffNextY;
    }

    public int nextX(int x) {return x + diffNextX;}
    public int nextY(int y) {return y + diffNextY;}
    public int backX(int x) {return x - diffNextX;}
    public int backY(int y) {return y - diffNextY;}
}
