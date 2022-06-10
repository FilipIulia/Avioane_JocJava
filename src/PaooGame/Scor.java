package PaooGame;

import java.util.ArrayList;

public class Scor{
    int Score;
    ArrayList<IObserver> observers= new ArrayList<>();

    public int GetScor()
    {
        return Score;
    }

    public void setScore (int x)
    {
        this.Score=this.Score+x;
        Notify();
    }

    public void add(IObserver o) {
        observers.add(o);
    }

    public void remove (IObserver o) {
        observers.remove(o);
    }

    public void Notify() {
        this.Score=Score;
        for (IObserver o : observers)
        {
            o.update();
        }
    }

}
