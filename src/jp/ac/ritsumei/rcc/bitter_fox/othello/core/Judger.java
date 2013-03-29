
public interface Judger
{
    boolean isPutable(OthelloBoard board, Stone stone, At at);
    boolean isPutable(OthelloBoard board, Stone stone, int x, int y); // TODO: default
}
