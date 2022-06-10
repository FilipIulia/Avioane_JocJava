package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Trunchi extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    boolean colision=true;
    public Trunchi(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.trunchi, id);
    }
}
