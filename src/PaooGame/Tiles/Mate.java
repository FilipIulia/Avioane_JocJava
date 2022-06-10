package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Mate extends Tile
{

    boolean colision=false;
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public Mate(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.mate, id);
    }
}
