package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Cap extends Tile
{
    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */

    boolean colision=true;
    private static BufferedImage CapDirectie(int id)
    {
        BufferedImage a = null;

        switch(id)
        {
            case 0:
                a = Assets.cap;
                break;
            case 1:
                a = Assets.cap_R1;
                break;
            case 2:
                a=Assets.cap_R2;
                break;
            case 3:
                a=Assets.cap_R3;
                break;
        }

        return a;

    }



    public Cap(int id)
    {
        /// Apel al constructorului clasei de baza
        super(CapDirectie(id), id);
    }

}
