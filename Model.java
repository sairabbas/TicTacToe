import java.util.Observable;
public class Model extends Observable
{
    int state[], previousState[], update = 0, previousUpdate = 0;
    public Model()
    {
        state = new int[9];
        previousState = new int[9];
    }
    public int[] getState()
    {
        return state;
    }
    public void updateState(int position, int value)
    {
        state[position] = value;
        update++;
        if (previousUpdate == update - 1)
        {
            previousState = state;
            previousUpdate++;
        }
        setChanged();
        notifyObservers();
    }
    public void undoState()
    {
        state = previousState;
        setChanged();
        notifyObservers();
    }
}