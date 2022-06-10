package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    public boolean colision =false;

    private static final int NO_TILES   = 35;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie
    public static Tile mate        = new Mate(0);
    public static Tile aer        = new Aer(0);/*!< Dala de tip iarba*/
    public static Tile lovit = new Lovit(0);
    public static Tile cap     = new Cap(0);
    public static Tile  trunchi  = new Trunchi(0);
    public static Tile AripaJosDreapta       = new AripaJosD(0);
    public static Tile AripaJosStanga       = new AripaJosS(0);
    public static Tile AripaSusP1Drt       = new AripaSusP1Drt_clasa(0);
    public static Tile AripaSusP1Stg       = new AripaSusP1Stg_clasa(0);
    public static Tile AripaSusP2Drt       = new AripaSusP2Dreapta_clasa(0);
    public static Tile AripaSusP2Stg      = new AripaSusP2Stanga_clasa(0);

    public static Tile cap_R1     = new Cap(1);
    public static Tile AripaJosDreapta_R1       = new AripaJosD(1);
    public static Tile AripaJosStanga_R1       = new AripaJosS(1);
    public static Tile AripaSusP1Drt_R1       = new AripaSusP1Drt_clasa(1);
    public static Tile AripaSusP1Stg_R1       = new AripaSusP1Stg_clasa(1);
    public static Tile AripaSusP2Drt_R1       = new AripaSusP2Dreapta_clasa(1);
    public static Tile AripaSusP2Stg_R1      = new AripaSusP2Stanga_clasa(1);

    public static Tile cap_R2     = new Cap(2);
    public static Tile AripaJosDreapta_R2       = new AripaJosD(2);
    public static Tile AripaJosStanga_R2       = new AripaJosS(2);
    public static Tile AripaSusP1Drt_R2       = new AripaSusP1Drt_clasa(2);
    public static Tile AripaSusP1Stg_R2       = new AripaSusP1Stg_clasa(2);
    public static Tile AripaSusP2Drt_R2       = new AripaSusP2Dreapta_clasa(2);
    public static Tile AripaSusP2Stg_R2      = new AripaSusP2Stanga_clasa(2);

    public static Tile cerL1      = new CerLevel1(2);

    public static Tile cap_R3     = new Cap(3);
    public static Tile AripaJosDreapta_R3       = new AripaJosD(3);
    public static Tile AripaJosStanga_R3       = new AripaJosS(3);
    public static Tile AripaSusP1Drt_R3       = new AripaSusP1Drt_clasa(3);
    public static Tile AripaSusP1Stg_R3       = new AripaSusP1Stg_clasa(3);
    public static Tile AripaSusP2Drt_R3       = new AripaSusP2Dreapta_clasa(3);
    public static Tile AripaSusP2Stg_R3      = new AripaSusP2Stanga_clasa(3);

    public static Tile miniAvion    = new miniAvion(3);
    public static Tile cer =new Cer(0);
    public static final int TILE_WIDTH  = 48;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 48;                       /*!< Inaltimea unei dale.*/
    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;
        tiles[id] = this;
    }

    public void Update(Graphics g)
    {

        Tile.AripaJosDreapta.Draw(g,17*Tile.TILE_WIDTH,10*Tile.TILE_HEIGHT);
    }
    public void Draw(Graphics g, int x, int y)
    {
            /// Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public int GetId()
    {
        return id;
    }
}
