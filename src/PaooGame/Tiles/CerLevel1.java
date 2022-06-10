package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

/*! \class public class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */

public class CerLevel1  extends Tile  {
    public CerLevel1(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.cerL1, id);
    }

}
