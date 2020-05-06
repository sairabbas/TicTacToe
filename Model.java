import java.util.Observable;
public class Model extends Observable
{
    int state[][];
    public Model()
    {
        state = new int[3][3];
    }
    public int[][] getState()
    {
        return state;
    }
    public void updateState(int row, int col, int value)
    {
        state[row][col] = value;
        setChanged();
        notifyObservers();
    }
}