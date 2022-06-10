package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
public class miniAvion extends Tile {
    boolean colision=false;
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public miniAvion(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.miniavion, id);
    }
}
