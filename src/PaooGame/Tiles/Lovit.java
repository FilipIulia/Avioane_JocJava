package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Lovit extends Tile{

    public boolean colision=true;

    public Lovit(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.lovit, id);
    }

}
