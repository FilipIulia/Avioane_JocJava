package PaooGame.Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage mate;
    public static BufferedImage cap;
    public static BufferedImage trunchi;
    public static BufferedImage AripaJosStanga;
    public static BufferedImage AripaJosDreapta;
    public static BufferedImage AripaSusP1Stg;
    public static BufferedImage AripaSusP1Drt;
    public static BufferedImage AripaSusP2Stg;
    public static BufferedImage AripaSusP2Drt;

    public static BufferedImage cap_R1;
    public static BufferedImage AripaJosStanga_R1;
    public static BufferedImage AripaJosDreapta_R1;
    public static BufferedImage AripaSusP1Stg_R1;
    public static BufferedImage AripaSusP1Drt_R1;
    public static BufferedImage AripaSusP2Stg_R1;
    public static BufferedImage AripaSusP2Drt_R1;


    public static BufferedImage cap_R2;
    public static BufferedImage AripaJosStanga_R2;
    public static BufferedImage AripaJosDreapta_R2;
    public static BufferedImage AripaSusP1Stg_R2;
    public static BufferedImage AripaSusP1Drt_R2;
    public static BufferedImage AripaSusP2Stg_R2;
    public static BufferedImage AripaSusP2Drt_R2;


    public static BufferedImage cap_R3;
    public static BufferedImage AripaJosStanga_R3;
    public static BufferedImage AripaJosDreapta_R3;
    public static BufferedImage AripaSusP1Stg_R3;
    public static BufferedImage AripaSusP1Drt_R3;
    public static BufferedImage AripaSusP2Stg_R3;
    public static BufferedImage AripaSusP2Drt_R3;
    public static BufferedImage miniavion;
    public static BufferedImage cer;
    public static BufferedImage cerL1;
    public static BufferedImage aer;
    public static BufferedImage lovit;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/spritesheet.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.


        cer=sheet.crop(0,5);
        //SUS
       mate = sheet.crop(0, 0);
       cap = sheet.crop(1, 0);
       trunchi= sheet.crop(0, 1);
       AripaJosStanga= sheet.crop(2, 4);
       AripaJosDreapta = sheet.crop(5, 1);
       AripaSusP1Stg = sheet.crop(1, 1);
       AripaSusP1Drt = sheet.crop(4, 2);
       AripaSusP2Stg = sheet.crop(0, 2);
       AripaSusP2Drt = sheet.crop(3, 3);


        cap_R1 = sheet.crop(2, 0);
        AripaJosStanga_R1= sheet.crop(3, 4);
        AripaJosDreapta_R1 = sheet.crop(5, 2);
        AripaSusP1Stg_R1 = sheet.crop(2, 1);
        AripaSusP1Drt_R1 = sheet.crop(0, 3);
        AripaSusP2Stg_R1 = sheet.crop(1, 2);
        AripaSusP2Drt_R1 = sheet.crop(4, 3);

        cap_R2 = sheet.crop(3, 0);
        AripaJosStanga_R2= sheet.crop(4, 4);
        AripaJosDreapta_R2 = sheet.crop(5, 3);
        AripaSusP1Stg_R2 = sheet.crop(1, 3);
        AripaSusP1Drt_R2 = sheet.crop(3, 1);
        AripaSusP2Stg_R2 = sheet.crop(0, 4);
        AripaSusP2Drt_R2 = sheet.crop(2, 2);

        cap_R3 = sheet.crop(4, 0);
        AripaJosStanga_R3= sheet.crop(5, 4);
        AripaJosDreapta_R3 = sheet.crop(5, 0);
        AripaSusP1Stg_R3 = sheet.crop(4, 1);
        AripaSusP1Drt_R3 = sheet.crop(2, 3);
        AripaSusP2Stg_R3 = sheet.crop(3, 2);
        AripaSusP2Drt_R3 = sheet.crop(1, 4);

        aer= sheet.crop(1,5);
        lovit=sheet.crop(2,5);
        cerL1=sheet.crop(3,5);
        try {
            miniavion=ImageIO.read(Assets.class.getResourceAsStream("/textures/miniAvion.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
