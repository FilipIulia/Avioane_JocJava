package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class AripaSusP2Dreapta_clasa extends Tile
{

    boolean colision=true;
    private static BufferedImage AripaSusP2Dreapta_clasaDirectie(int id)
    {
        BufferedImage a = null;

        switch(id)
        {
            case 0:
                a = Assets.AripaSusP2Drt;
                break;
            case 1:
                a = Assets.AripaSusP2Drt_R1;
                break;
            case 2:
                a=Assets.AripaSusP2Drt_R2;
                break;
            case 3:
                a=Assets.AripaSusP2Drt_R3;
                break;
        }

        return a;

    }

    public AripaSusP2Dreapta_clasa(int id)
    {
        /// Apel al constructorului clasei de baza
        super(AripaSusP2Dreapta_clasaDirectie(id), id);
    }
}
