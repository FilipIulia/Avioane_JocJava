package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class AripaSusP1Drt_clasa extends Tile
{

    boolean colision=true;;
    private static BufferedImage AripaSusP1Drt_clasaDirectie(int id)
    {
        BufferedImage a = null;

        switch(id)
        {
            case 0:
                a = Assets.AripaSusP1Drt;
                break;
            case 1:
                a = Assets.AripaSusP1Drt_R1;
                break;
            case 2:
                a=Assets.AripaSusP1Drt_R2;
                break;
            case 3:
                a=Assets.AripaSusP1Drt_R3;
                break;
        }

        return a;

    }


    public AripaSusP1Drt_clasa(int id)
    {
        /// Apel al constructorului clasei de baza
        super(AripaSusP1Drt_clasaDirectie(id), id);
    }
}
