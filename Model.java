import java.util.Observable;
public class Model extends Observable
{
    int state[];
    public Model()
    {
        state = new int[9];
    }
    public int[] getState()
    {
        return state;
    }
    public void updateState(int position, int value)
    {
        state[position] = value;
        setChanged();
        notifyObservers();
    }
}