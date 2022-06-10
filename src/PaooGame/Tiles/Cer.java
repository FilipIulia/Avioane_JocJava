package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Cer extends Tile {

    public boolean colision=true;

    public Cer(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.cer, id);
    }

}

