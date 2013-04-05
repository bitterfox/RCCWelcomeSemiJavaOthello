
package jp.ac.ritsumei.rcc.bitter_fox.othello.core;

import jp.ac.ritsumei.rcc.bitter_fox.othello.core.impl.*;

public final class OthelloSystems
{
    private OthelloSystems() {throw new UnsupportedOperationException("no instance for you");}

    public static OthelloSystem createOthelloSystem()
    {
        return OthelloSystemImpl.getInstance();
    }
}
