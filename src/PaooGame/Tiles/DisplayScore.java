package PaooGame.Tiles;

import PaooGame.IObservable;
import PaooGame.IObserver;
import PaooGame.Scor;

public class DisplayScore extends  IObserver {
    public DisplayScore(Scor subject) {
        this.scor=subject;
        this.scor.add(this);
    }

    @Override
    public void update() {
    }
    public void DisplayScore(Scor scor)
    {
        this.scor=scor;
        this.scor.add(this);
    }
}
