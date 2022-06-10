package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;

    public class AripaSusP2Stanga_clasa extends Tile
    {
        /*! \fn public GrassTile(int id)
            \brief Constructorul de initializare al clasei

            \param id Id-ul dalei util in desenarea hartii.
         */
        boolean colision=true;
        private static BufferedImage AripaSusP2Stanga_clasaDirectie(int id)
        {
            BufferedImage a = null;

            switch(id)
            {
                case 0:
                    a = Assets.AripaSusP2Stg;
                    break;
                case 1:
                    a = Assets.AripaSusP2Stg_R1;
                    break;
                case 2:
                    a=Assets.AripaSusP2Stg_R2;
                    break;
                case 3:
                    a=Assets.AripaSusP2Stg_R3;
                    break;
            }

            return a;

        }


        public AripaSusP2Stanga_clasa(int id)
        {
            /// Apel al constructorului clasei de baza
            super(AripaSusP2Stanga_clasaDirectie(id), id);
        }


}


