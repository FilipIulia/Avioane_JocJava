package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
public class Aer extends Tile {
    boolean colision=false;
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Aer(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.aer, id);
    }
}
