package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class AripaJosS extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.



     */

    boolean colision=true;

    private static BufferedImage AripaJosSDirectie(int id)
    {
        BufferedImage a = null;

        switch(id)
        {
            case 0:
                a = Assets.AripaJosStanga;
                break;
            case 1:
                a = Assets.AripaJosStanga_R1;
                break;
            case 2:
                a=Assets.AripaJosStanga_R2;
                break;
            case 3:
                a=Assets.AripaJosStanga_R3;
                break;
        }

        return a;

    }

    public AripaJosS(int id)
    {
        /// Apel al constructorului clasei de baza
        super(AripaJosSDirectie(id), id);
    }
}
