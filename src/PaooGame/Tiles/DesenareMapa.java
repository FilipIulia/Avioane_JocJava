package PaooGame.Tiles;
import PaooGame.*;
import PaooGame.Database.DatabaseSingleton;

import java.awt.*;
import java.sql.SQLException;
import java.util.Random;

import entity.Player.*;



public class DesenareMapa {

    static int[][] coliziuni2= {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},   //facut
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  //facut
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  //facut
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}   //facut   //17
            //f                             f                             f f
    };

    static int[][] coliziuni1= {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},   //facut
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  //facut
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},  //facut
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}   //facut   //17
            //f                             f                             f f
    };




    public static int VerifCapJos(int X, int Y, int[][] coliziuni) {
        if (X - 1 < 0 || X - 2 < 0 || X - 3 < 0 || Y + 1 < 0 || Y - 1 < 0 || Y - 2 < 0 || Y + 2 < 0) {
                try {
                    UI.showMessage("index cu minus", 300, 300);
                    throw new IndexMinus();
                } catch (Exception e) {
                }
        }
        else         return coliziuni[X][Y] * coliziuni[X - 1][Y] * coliziuni[X - 2][Y] * coliziuni[X - 3][Y] * coliziuni[X - 3][Y + 1] * coliziuni[X - 3][Y - 1] * coliziuni[X - 1][Y + 1] * coliziuni[X - 1][Y + 2] * coliziuni[X - 1][Y - 2] * coliziuni[X - 1][Y - 1];
        return -1;
    }


    public static int VerifCapSus(int X, int Y, int[][] coliziuni) {
        if (X + 1 < 0 || X + 2 < 0 || X + 3 < 0 || Y - 1 < 0 || Y + 1 < 0 || Y - 2 < 0 || Y + 2 < 0) {
            try {
                UI.showMessage("index cu minus", 300, 300);
                throw new IndexMinus();
            } catch (Exception e) {
            }
        }
        else
        return coliziuni[X][Y] * coliziuni[X + 1][Y] * coliziuni[X + 2][Y] * coliziuni[X + 3][Y] * coliziuni[X + 3][Y - 1] * coliziuni[X + 3][Y + 1] * coliziuni[X + 1][Y + 1] * coliziuni[X + 1][Y - 1] * coliziuni[X + 1][Y - 2] * coliziuni[X + 1][Y + 2];
        return -1;
    }

    public static int VerifCapStanga(int X, int Y, int[][] coliziuni) {
        return coliziuni[X][Y] * coliziuni[X][Y - 1] * coliziuni[X][Y - 2] * coliziuni[X][Y - 3] * coliziuni[X - 1][Y - 3] * coliziuni[X + 1][Y - 3] * coliziuni[X + 1][Y - 1] * coliziuni[X - 1][Y - 1] * coliziuni[X - 2][Y - 1] * coliziuni[X + 2][Y - 1];
    }


    public static int VerifCapDreapta(int X, int Y, int[][] coliziuni) {
        if (Y + 1 < 0 || Y + 2 < 0 || Y + 3 < 0 || X - 1 < 0 ||X + 1 < 0 || X - 2 < 0 || X + 2 < 0) {
            try {
                UI.showMessage("index cu minus", 300, 300);
                throw new IndexMinus();
            } catch (Exception e) {
            }
        }
        else
        return coliziuni[X][Y] * coliziuni[X][Y + 1] * coliziuni[X][Y + 2] * coliziuni[X][Y + 3] * coliziuni[X - 1][Y + 3] * coliziuni[X + 1][Y + 3] * coliziuni[X + 1][Y + 1] * coliziuni[X - 1][Y + 1] * coliziuni[X - 2][Y + 1] * coliziuni[X + 2][Y + 1];
        return -1;
    }

    public static void CapJos(Graphics g, int X, int Y, int[][] coliziuni) {

            Tile.cap_R2.Draw(g, Y * Tile.TILE_WIDTH, X * Tile.TILE_HEIGHT);
            coliziuni[X][Y] = 0;
            Tile.trunchi.Draw(g, Y * Tile.TILE_WIDTH, (X - 1) * Tile.TILE_HEIGHT);
            coliziuni[X - 1][Y] = 0;
            Tile.trunchi.Draw(g, Y * Tile.TILE_WIDTH, (X - 2) * Tile.TILE_HEIGHT);
            coliziuni[X - 2][Y] = 0;
            Tile.trunchi.Draw(g, Y * Tile.TILE_WIDTH, (X - 3) * Tile.TILE_HEIGHT);
            coliziuni[X - 3][Y] = 0;
            Tile.AripaJosStanga_R2.Draw(g, (Y + 1) * Tile.TILE_WIDTH, (X - 3) * Tile.TILE_HEIGHT);
            coliziuni[X - 3][Y + 1] = 0;
            Tile.AripaJosDreapta_R2.Draw(g, (Y - 1) * Tile.TILE_WIDTH, (X - 3) * Tile.TILE_HEIGHT);
            coliziuni[X - 3][Y - 1] = 0;
            Tile.AripaSusP1Drt_R2.Draw(g, (Y + 1) * Tile.TILE_WIDTH, (X - 1) * Tile.TILE_HEIGHT);
            coliziuni[X - 1][Y + 1] = 0;
            Tile.AripaSusP1Stg_R2.Draw(g, (Y - 1) * Tile.TILE_WIDTH, (X - 1) * Tile.TILE_HEIGHT);
            coliziuni[X - 1][Y - 1] = 0;
            Tile.AripaSusP2Stg_R2.Draw(g, (Y - 2) * Tile.TILE_WIDTH, (X - 1) * Tile.TILE_HEIGHT);
            coliziuni[X - 1][Y - 2] = 0;
            Tile.AripaSusP2Drt_R2.Draw(g, (Y + 2) * Tile.TILE_WIDTH, (X - 1) * Tile.TILE_HEIGHT);
            coliziuni[X - 1][Y + 2] = 0;
    }


    public static void CapDreapta(Graphics g, int X, int Y, int[][] coliziuni) {
            Tile.cap_R3.Draw(g, Y * Tile.TILE_WIDTH, X * Tile.TILE_HEIGHT);
            coliziuni[X][Y] = 0;
            Tile.trunchi.Draw(g, (Y + 1) * Tile.TILE_WIDTH, X * Tile.TILE_HEIGHT);
            coliziuni[X][Y + 1] = 0;
            Tile.trunchi.Draw(g, (Y + 2) * Tile.TILE_WIDTH, X * Tile.TILE_HEIGHT);
            coliziuni[X][Y + 2] = 0;
            Tile.trunchi.Draw(g, (Y + 3) * Tile.TILE_WIDTH, X * Tile.TILE_HEIGHT);
            coliziuni[X][Y + 3] = 0;
            Tile.AripaJosStanga_R3.Draw(g, (Y + 3) * Tile.TILE_WIDTH, (X - 1) * Tile.TILE_HEIGHT);
            coliziuni[X - 1][Y + 3] = 0;
            Tile.AripaJosDreapta_R3.Draw(g, (Y + 3) * Tile.TILE_WIDTH, (X + 1) * Tile.TILE_HEIGHT);
            coliziuni[X + 1][Y + 3] = 0;
            Tile.AripaSusP1Drt_R3.Draw(g, (Y + 1) * Tile.TILE_WIDTH, (X - 1) * Tile.TILE_HEIGHT);
            coliziuni[X - 1][Y + 1] = 0;
            Tile.AripaSusP1Stg_R3.Draw(g, (Y + 1) * Tile.TILE_WIDTH, (X + 1) * Tile.TILE_HEIGHT);
            coliziuni[X + 1][Y + 1] = 0;
            Tile.AripaSusP2Stg_R3.Draw(g, (Y + 1) * Tile.TILE_WIDTH, (X + 2) * Tile.TILE_HEIGHT);
            coliziuni[X + 2][Y + 1] = 0;
            Tile.AripaSusP2Drt_R3.Draw(g, (Y + 1) * Tile.TILE_WIDTH, (X - 2) * Tile.TILE_HEIGHT);
            coliziuni[X - 2][Y + 1] = 0;
    }

    public static void CapStanga(Graphics g, int X, int Y, int[][] coliziuni) {
            Tile.cap_R1.Draw(g, Y * Tile.TILE_WIDTH, X * Tile.TILE_HEIGHT);
            coliziuni[X][Y] = 0;
            Tile.trunchi.Draw(g, (Y - 1) * Tile.TILE_WIDTH, X * Tile.TILE_HEIGHT);
            coliziuni[X][Y - 1] = 0;
            Tile.trunchi.Draw(g, (Y - 2) * Tile.TILE_WIDTH, X * Tile.TILE_HEIGHT);
            coliziuni[X][Y - 2] = 0;
            Tile.trunchi.Draw(g, (Y - 3) * Tile.TILE_WIDTH, X * Tile.TILE_HEIGHT);
            coliziuni[X][Y - 3] = 0;
            Tile.AripaJosStanga_R1.Draw(g, (Y - 3) * Tile.TILE_WIDTH, (X - 1) * Tile.TILE_HEIGHT);
            coliziuni[X - 1][Y - 3] = 0;
            Tile.AripaJosDreapta_R1.Draw(g, (Y - 3) * Tile.TILE_WIDTH, (X + 1) * Tile.TILE_HEIGHT);
            coliziuni[X + 1][Y - 3] = 0;
            Tile.AripaSusP1Drt_R1.Draw(g, (Y - 1) * Tile.TILE_WIDTH, (X + 1) * Tile.TILE_HEIGHT);
            coliziuni[X + 1][Y - 1] = 0;
            Tile.AripaSusP1Stg_R1.Draw(g, (Y - 1) * Tile.TILE_WIDTH, (X - 1) * Tile.TILE_HEIGHT);
            coliziuni[X - 1][Y - 1] = 0;
            Tile.AripaSusP2Stg_R1.Draw(g, (Y - 1) * Tile.TILE_WIDTH, (X - 2) * Tile.TILE_HEIGHT);
            coliziuni[X - 2][Y - 1] = 0;
            Tile.AripaSusP2Drt_R1.Draw(g, (Y - 1) * Tile.TILE_WIDTH, (X + 2) * Tile.TILE_HEIGHT);
            coliziuni[X + 2][Y - 1] = 0;
    }

    public static void CapSus(Graphics g, int X, int Y, int[][] coliziuni) {
        Tile.cap.Draw(g, Y * Tile.TILE_WIDTH, X * Tile.TILE_HEIGHT);
        coliziuni[X][Y] = 0;
        Tile.trunchi.Draw(g, Y * Tile.TILE_WIDTH, (X + 1) * Tile.TILE_HEIGHT);
        coliziuni[X + 1][Y] = 0;
        Tile.trunchi.Draw(g, Y * Tile.TILE_WIDTH, (X + 2) * Tile.TILE_HEIGHT);
        coliziuni[X + 2][Y] = 0;
        Tile.trunchi.Draw(g, Y * Tile.TILE_WIDTH, (X + 3) * Tile.TILE_HEIGHT);
        coliziuni[X + 3][Y] = 0;
        Tile.AripaJosStanga.Draw(g, (Y - 1) * Tile.TILE_WIDTH, (X + 3) * Tile.TILE_HEIGHT);
        coliziuni[X + 3][Y - 1] = 0;
        Tile.AripaJosDreapta.Draw(g, (Y + 1) * Tile.TILE_WIDTH, (X + 3) * Tile.TILE_HEIGHT);
        coliziuni[X + 3][Y + 1] = 0;
        Tile.AripaSusP1Drt.Draw(g, (Y + 1) * Tile.TILE_WIDTH, (X + 1) * Tile.TILE_HEIGHT);
        coliziuni[X + 1][Y + 1] = 0;
        Tile.AripaSusP1Stg.Draw(g, (Y - 1) * Tile.TILE_WIDTH, (X + 1) * Tile.TILE_HEIGHT);
        coliziuni[X + 1][Y - 1] = 0;
        Tile.AripaSusP2Stg.Draw(g, (Y - 2) * Tile.TILE_WIDTH, (X + 1) * Tile.TILE_HEIGHT);
        coliziuni[X + 1][Y - 2] = 0;
        Tile.AripaSusP2Drt.Draw(g, (Y + 2) * Tile.TILE_WIDTH, (X + 1) * Tile.TILE_HEIGHT);
        coliziuni[X + 1][Y + 2] = 0;
    }

    public static int[][] GetColiziuni1 ()
    {
        return coliziuni1;
    }

    public static int[][] GetColiziuni2 ()
    {
        return coliziuni2;
    }

    public static void DenesareCer2(Graphics g) {
        for (int i = 0; i < 32; i++) {
            Tile.cer.Draw(g, i * Tile.TILE_WIDTH, 0 * Tile.TILE_HEIGHT);
            Tile.cer.Draw(g, i * Tile.TILE_WIDTH, 1 * Tile.TILE_HEIGHT);
            Tile.cer.Draw(g, i * Tile.TILE_WIDTH, 16 * Tile.TILE_HEIGHT);
            Tile.cer.Draw(g, i * Tile.TILE_WIDTH, 17 * Tile.TILE_HEIGHT);
        }

        for (int i = 0; i < 17; i++) {
            Tile.cer.Draw(g, 0 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cer.Draw(g, 15 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cer.Draw(g, 30 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cer.Draw(g, 31 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
        }
    }


    public static void DesenezMine2(Graphics g) {
        for (int i = 1; i < 15; i++)
            for (int j = 2; j < 16; j++)
                Tile.mate.Draw(g, i * Tile.TILE_WIDTH, j * Tile.TILE_HEIGHT);

    }

    public static void DesenezMine1(Graphics g) {
        for (int i = 4; i < 11; i++)
            for (int j = 5; j <12; j++)
                Tile.mate.Draw(g, i * Tile.TILE_WIDTH, j * Tile.TILE_HEIGHT);

    }

    public static void DenesareCer1(Graphics g) {
        for (int i = 0; i < 32; i++) {
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 0 * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 1 * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 2 * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 3 * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 4 * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 12 * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 13 * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 14 * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 15 * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 16 * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, i * Tile.TILE_WIDTH, 17 * Tile.TILE_HEIGHT);
        }

        for (int i = 0; i < 17; i++) {
            Tile.cerL1.Draw(g, 0 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 1 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 2 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 3 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 11 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 12 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 13 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 14 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 15 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 16 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 17 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 18 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 19 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 27 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 28 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 29 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 30 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
            Tile.cerL1.Draw(g, 31 * Tile.TILE_WIDTH, i * Tile.TILE_HEIGHT);
        }

    }

    public static void DesenezRadar2(Graphics g) {
        for (int i = 16; i < 30; i++)
            for (int j = 2; j < 16; j++)
                Tile.mate.Draw(g, i * Tile.TILE_WIDTH, j * Tile.TILE_HEIGHT);
    }
    public static void DesenezRadar1(Graphics g) {
        for (int i = 20; i < 27; i++)
            for (int j = 5; j < 12; j++)
                Tile.mate.Draw(g, i * Tile.TILE_WIDTH, j * Tile.TILE_HEIGHT);

    }


    public static int PozitieRandom()
    {
        return (int)Math.floor(Math.random()*(7-4)+4);
    }

    public static int PozitieRandomPunct(int maxim, int minim)
    {
        return (int)Math.floor(Math.random()*(maxim-minim)+minim);
    }

    public static void DesenezAvionRadar1 (Graphics g, int[][]coliziuni, int contor, int[] AfisareAvioane, DatabaseSingleton database)
    {
        int X,Y,poz;

        String s="";
        poz=PozitieRandom();

            switch(poz)
            {
                case 4:
                    //SUS
                    do{
                        X = PozitieRandomPunct(5, 10);
                        Y = PozitieRandomPunct(22, 24);
                    }while(VerifCapSus(X,Y,coliziuni)<=0);
                    contor++;

                    if (VerifCapSus(X,Y,coliziuni)>0) {

                        database.InsertNewAvion(X, Y, contor, poz);

                        coliziuni[X][Y] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X + 1][Y] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X + 2][Y] = 0;
                        s=s+String.valueOf(X+2)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X + 3][Y] = 0;
                        s=s+String.valueOf(X+3)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X + 3][Y - 1] = 0;
                        s=s+String.valueOf(X+3)+" "+String.valueOf(Y-1)+"\n";

                        coliziuni[X + 3][Y + 1] = 0;
                        s=s+String.valueOf(X+3)+" "+String.valueOf(Y+1)+"\n";

                        coliziuni[X + 1][Y + 1] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y+1)+"\n";
                        coliziuni[X + 1][Y - 1] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y-1)+"\n";
                        coliziuni[X + 1][Y - 2] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y-2)+"\n";
                        coliziuni[X + 1][Y + 2] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y+2)+"\n";

                    }

                    AfisareAvioane[contor]=4;
                    break;
                case 5:
                    //DREAPTA
                    do{
                        X = PozitieRandomPunct(7, 9);
                        Y = PozitieRandomPunct(20, 23);
                    }while(VerifCapDreapta(X,Y,coliziuni)<=0);
                    contor++;

                    if (VerifCapDreapta(X,Y,coliziuni)>0) {

                        database.InsertNewAvion(X, Y, contor, poz);

                        coliziuni[X][Y] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X][Y + 1] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y+1)+"\n";

                        coliziuni[X][Y + 2] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y+2)+"\n";

                        coliziuni[X][Y + 3] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y+3)+"\n";

                        coliziuni[X - 1][Y + 3] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y+3)+"\n";

                        coliziuni[X + 1][Y + 3] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y+3)+"\n";

                        coliziuni[X - 1][Y + 1] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y+1)+"\n";

                        coliziuni[X + 1][Y + 1] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y+1)+"\n";

                        coliziuni[X + 2][Y + 1] = 0;
                        s=s+String.valueOf(X+2)+" "+String.valueOf(Y+1)+"\n";

                        coliziuni[X - 2][Y + 1] = 0;
                        s=s+String.valueOf(X-2)+" "+String.valueOf(Y+1)+"\n";
                    }

                    AfisareAvioane[contor]=5;
                    break;
                case 6:
                    //JOS
                    do{
                        X = PozitieRandomPunct(8, 11);
                        Y = PozitieRandomPunct(11, 24);
                    }while(VerifCapJos(X,Y,coliziuni)<=0);
                    contor++;

                    if (VerifCapJos(X,Y,coliziuni)>0) {

                        database.InsertNewAvion(X, Y, contor, poz);

                        coliziuni[X][Y] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X - 1][Y] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X - 2][Y] = 0;
                        s=s+String.valueOf(X-2)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X - 3][Y] = 0;
                        s=s+String.valueOf(X-3)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X - 3][Y + 1] = 0;
                        s=s+String.valueOf(X-3)+" "+String.valueOf(Y+1)+"\n";

                        coliziuni[X - 3][Y - 1] = 0;
                        s=s+String.valueOf(X-3)+" "+String.valueOf(Y-1)+"\n";

                        coliziuni[X - 1][Y + 1] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y+1)+"\n";

                        coliziuni[X - 1][Y - 1] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y-1)+"\n";

                        coliziuni[X - 1][Y - 2] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y-2)+"\n";

                        coliziuni[X - 1][Y + 2] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y+2)+"\n";
                    }

                    AfisareAvioane[contor]=6;
                    break;
                case 7:
                    //STANGA
                    do{
                        X = PozitieRandomPunct(7, 9);
                        Y = PozitieRandomPunct(23, 11);
                    }while(VerifCapStanga(X,Y,coliziuni)<=0);
                    contor++;

                    if (VerifCapStanga(X,Y,coliziuni)>0) {

                        database.InsertNewAvion(X, Y, contor, poz);

                        coliziuni[X][Y] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X][Y - 1] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y-1)+"\n";

                        coliziuni[X][Y - 2] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y-2)+"\n";

                        coliziuni[X][Y - 3] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y-3)+"\n";

                        coliziuni[X - 1][Y - 3] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y-3)+"\n";

                        coliziuni[X + 1][Y - 3] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y-3)+"\n";

                        coliziuni[X + 1][Y - 1] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y-1)+"\n";

                        coliziuni[X - 1][Y - 1] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y-1)+"\n";

                        coliziuni[X - 2][Y - 1] = 0;
                        s=s+String.valueOf(X-2)+" "+String.valueOf(Y-1)+"\n";

                        coliziuni[X + 2][Y - 1] = 0;
                        s=s+String.valueOf(X+2)+" "+String.valueOf(Y-1)+"\n";
                    }

                    AfisareAvioane[contor]=7;
                    break;
                default:
                    break;
            }

        Coord.Create(s,"CoordonateleAvioanelorAtacate");
        Coord.CloseCoord();

    }

    public static void DesenezAvionRadar2 (Graphics g, int[][]coliziuni, int contor, int[] AfisareAvioane, DatabaseSingleton database)
    {
        int X,Y,poz;

        String s="";
        for(int i=0;i<3;i++)
        {
            poz=PozitieRandom();

            switch(poz)
            {
                case 4:
                    //SUS
                    do{
                        X = PozitieRandomPunct(2, 14);
                        Y = PozitieRandomPunct(18, 27);
                    }while(VerifCapSus(X,Y,coliziuni)<=0);
                    contor++;

                    if (VerifCapSus(X,Y,coliziuni)>0) {

                        database.InsertNewAvion(X, Y, contor, poz);

                       coliziuni[X][Y] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X + 1][Y] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y)+"\n";

                        coliziuni[X + 2][Y] = 0;
                        s=s+String.valueOf(X+2)+" "+String.valueOf(Y)+"\n";

                      coliziuni[X + 3][Y] = 0;
                        s=s+String.valueOf(X+3)+" "+String.valueOf(Y)+"\n";

                      coliziuni[X + 3][Y - 1] = 0;
                        s=s+String.valueOf(X+3)+" "+String.valueOf(Y-1)+"\n";

                       coliziuni[X + 3][Y + 1] = 0;
                        s=s+String.valueOf(X+3)+" "+String.valueOf(Y+1)+"\n";

                       coliziuni[X + 1][Y + 1] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y+1)+"\n";
                       coliziuni[X + 1][Y - 1] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y-1)+"\n";
                        coliziuni[X + 1][Y - 2] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y-2)+"\n";
                        coliziuni[X + 1][Y + 2] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y+2)+"\n";

                    }

                    AfisareAvioane[contor]=4;
                    break;
                case 5:
                    //DREAPTA
                    do{
                        X = PozitieRandomPunct(4, 13);
                        Y = PozitieRandomPunct(16, 26);
                    }while(VerifCapDreapta(X,Y,coliziuni)<=0);
                    contor++;

                    if (VerifCapDreapta(X,Y,coliziuni)>0) {

                        database.InsertNewAvion(X, Y, contor, poz);

                        coliziuni[X][Y] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y)+"\n";

                     coliziuni[X][Y + 1] = 0;
                       s=s+String.valueOf(X)+" "+String.valueOf(Y+1)+"\n";

                        coliziuni[X][Y + 2] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y+2)+"\n";

                       coliziuni[X][Y + 3] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y+3)+"\n";

                      coliziuni[X - 1][Y + 3] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y+3)+"\n";

                       coliziuni[X + 1][Y + 3] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y+3)+"\n";

                       coliziuni[X - 1][Y + 1] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y+1)+"\n";

                      coliziuni[X + 1][Y + 1] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y+1)+"\n";

                       coliziuni[X + 2][Y + 1] = 0;
                        s=s+String.valueOf(X+2)+" "+String.valueOf(Y+1)+"\n";

                       coliziuni[X - 2][Y + 1] = 0;
                        s=s+String.valueOf(X-2)+" "+String.valueOf(Y+1)+"\n";
                    }

                    AfisareAvioane[contor]=5;
                    break;
                case 6:
                    //JOS
                    do{
                        X = PozitieRandomPunct(5, 15);
                        Y = PozitieRandomPunct(17, 27);
                    }while(VerifCapJos(X,Y,coliziuni)<=0);
                    contor++;

                    if (VerifCapJos(X,Y,coliziuni)>0) {

                        database.InsertNewAvion(X, Y, contor, poz);

                      coliziuni[X][Y] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y)+"\n";

                       coliziuni[X - 1][Y] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y)+"\n";

                     coliziuni[X - 2][Y] = 0;
                        s=s+String.valueOf(X-2)+" "+String.valueOf(Y)+"\n";

                      coliziuni[X - 3][Y] = 0;
                        s=s+String.valueOf(X-3)+" "+String.valueOf(Y)+"\n";

                      coliziuni[X - 3][Y + 1] = 0;
                        s=s+String.valueOf(X-3)+" "+String.valueOf(Y+1)+"\n";

                      coliziuni[X - 3][Y - 1] = 0;
                        s=s+String.valueOf(X-3)+" "+String.valueOf(Y-1)+"\n";

                      coliziuni[X - 1][Y + 1] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y+1)+"\n";

                      coliziuni[X - 1][Y - 1] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y-1)+"\n";

                       coliziuni[X - 1][Y - 2] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y-2)+"\n";

                      coliziuni[X - 1][Y + 2] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y+2)+"\n";
                    }

                    AfisareAvioane[contor]=6;
                    break;
                case 7:
                    //STANGA
                    do{
                        X = PozitieRandomPunct(4, 13);
                        Y = PozitieRandomPunct(19, 29);
                    }while(VerifCapStanga(X,Y,coliziuni)<=0);
                    contor++;

                    if (VerifCapStanga(X,Y,coliziuni)>0) {

                        database.InsertNewAvion(X, Y, contor, poz);

                        coliziuni[X][Y] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y)+"\n";

                       coliziuni[X][Y - 1] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y-1)+"\n";

                       coliziuni[X][Y - 2] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y-2)+"\n";

                       coliziuni[X][Y - 3] = 0;
                        s=s+String.valueOf(X)+" "+String.valueOf(Y-3)+"\n";

                      coliziuni[X - 1][Y - 3] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y-3)+"\n";

                      coliziuni[X + 1][Y - 3] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y-3)+"\n";

                       coliziuni[X + 1][Y - 1] = 0;
                        s=s+String.valueOf(X+1)+" "+String.valueOf(Y-1)+"\n";

                      coliziuni[X - 1][Y - 1] = 0;
                        s=s+String.valueOf(X-1)+" "+String.valueOf(Y-1)+"\n";

                       coliziuni[X - 2][Y - 1] = 0;
                        s=s+String.valueOf(X-2)+" "+String.valueOf(Y-1)+"\n";

                       coliziuni[X + 2][Y - 1] = 0;
                        s=s+String.valueOf(X+2)+" "+String.valueOf(Y-1)+"\n";
                    }

                    AfisareAvioane[contor]=7;
                    break;
                default:
                    break;
            }

        }
        Coord.Create(s,"CoordonateleAvioanelorAtacate");
        Coord.CloseCoord();

    }

    public static int PCAtaca1(int[][] coliziuni, int contor, DatabaseSingleton database) throws Exception {

        int X, Y, poz;
        X = PozitieRandomPunct(5, 11);
        Y = PozitieRandomPunct(4, 10);


        System.out.println(X + " " + Y);
        if (!database.Find("loviri", X, Y))
        {
            if (database.Find("avioane", X, Y)) {
                poz = database.GetPoz("avioane", X, Y);
                switch (poz) {
                    case 4:
                        if (!database.Find("loviri", X, Y) || coliziuni[X][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y) || coliziuni[X+1][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X + 2, Y)|| coliziuni[X+2][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X + 2, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X + 3, Y)|| coliziuni[X+3][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X + 3, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X + 3, Y - 1)  || coliziuni[X+3][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 3, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X + 3, Y + 1)|| coliziuni[X+3][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 3, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y + 1)|| coliziuni[X+1][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y + 1, contor, 1);
                        }

                        if (!database.Find("loviri", X + 1, Y - 1)|| coliziuni[X+1][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y - 2)|| coliziuni[X+1][Y-2]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y - 2, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y + 2)|| coliziuni[X+1][Y+2]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y + 2, contor, 1);
                        }
                        break;

                    case 5:
                        if (!database.Find("loviri", X, Y) || coliziuni[X][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y + 1)|| coliziuni[X][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y + 2) || coliziuni[X][Y+2]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y + 2, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y + 3) || coliziuni[X][Y+3]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y + 3, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y + 1) || coliziuni[X-1][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y + 3) || coliziuni[X-1][Y+3]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y + 3, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y + 3) || coliziuni[X+1][Y+3]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y + 3, contor, 1);
                        }

                        if (!database.Find("loviri", X + 1, Y + 1) || coliziuni[X+1][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X + 2, Y + 1) || coliziuni[X+2][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 2, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 2, Y + 1) || coliziuni[X-2][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 2, Y + 1, contor, 1);
                        }

                        break;
                    case 6:
                        if (!database.Find("loviri", X, Y) || coliziuni[X][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y) || coliziuni[X-1][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X - 2, Y)|| coliziuni[X-2][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X - 2, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X - 3, Y)|| coliziuni[X-3][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X - 3, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X - 3, Y + 1) || coliziuni[X-3][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 3, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 3, Y - 1)|| coliziuni[X-3][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 3, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y + 1)|| coliziuni[X-1][Y+1]==0)  {
                            contor++;
                            database.InsertNewLovire(X - 1, Y + 1, contor, 1);
                        }

                        if (!database.Find("loviri", X - 1, Y - 1) || coliziuni[X-1][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y - 2) || coliziuni[X-1][Y-2]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y - 2, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y + 2) || coliziuni[X-1][Y+2]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y + 2, contor, 1);
                        }

                        break;
                    case 7:
                        if (!database.Find("loviri", X, Y) || coliziuni[X][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y - 1) || coliziuni[X][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y - 2)|| coliziuni[X][Y-2]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y - 2, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y - 3)|| coliziuni[X][Y-3]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y - 3, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y - 3)|| coliziuni[X-1][Y-3]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y - 3, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y + 3)|| coliziuni[X+1][Y+3]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y + 3, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y - 1) || coliziuni[X+1][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y - 1, contor, 1);
                        }

                        if (!database.Find("loviri", X - 1, Y - 1) || coliziuni[X-1][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 2, Y - 1) || coliziuni[X-2][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 2, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X + 2, Y - 1)|| coliziuni[X+2][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 2, Y - 1, contor, 1);
                        }

                        break;

                    default:
                        break;
                }
            }

            if ((Coord.Find(String.valueOf(X) + " " + String.valueOf(Y), "CoordonateleAvioanelorAtacate")||coliziuni[X][Y]==0)) {
                contor++;
                database.InsertNewLovire(contor, X, Y, 1);
            }
            else {
                System.out.println(Coord.Find(String.valueOf(X) + " " + String.valueOf(Y), "CoordonateAvioane"));
                contor++;
                if (!database.Find("loviri", X, Y))
                    database.InsertNewLovire(contor, X, Y, 0);
            }
        }
        return contor;
    }

    public static int PCAtaca2(int[][] coliziuni, int contor, DatabaseSingleton database) throws Exception {

        int X, Y, poz;
        X = PozitieRandomPunct(2, 15);
        Y = PozitieRandomPunct(1, 14);


        System.out.println(X + " " + Y);
        if (!database.Find("loviri", X, Y))
        {
            if (database.Find("avioane", X, Y)) {
                poz = database.GetPoz("avioane", X, Y);
                switch (poz) {
                    case 4:
                        if (!database.Find("loviri", X, Y) || coliziuni[X][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y) || coliziuni[X+1][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X + 2, Y)|| coliziuni[X+2][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X + 2, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X + 3, Y)|| coliziuni[X+3][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X + 3, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X + 3, Y - 1)  || coliziuni[X+3][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 3, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X + 3, Y + 1)|| coliziuni[X+3][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 3, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y + 1)|| coliziuni[X+1][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y + 1, contor, 1);
                        }

                        if (!database.Find("loviri", X + 1, Y - 1)|| coliziuni[X+1][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y - 2)|| coliziuni[X+1][Y-2]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y - 2, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y + 2)|| coliziuni[X+1][Y+2]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y + 2, contor, 1);
                        }
                        break;

                    case 5:
                        if (!database.Find("loviri", X, Y) || coliziuni[X][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y + 1)|| coliziuni[X][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y + 2) || coliziuni[X][Y+2]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y + 2, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y + 3) || coliziuni[X][Y+3]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y + 3, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y + 1) || coliziuni[X-1][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y + 3) || coliziuni[X-1][Y+3]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y + 3, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y + 3) || coliziuni[X+1][Y+3]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y + 3, contor, 1);
                        }

                        if (!database.Find("loviri", X + 1, Y + 1) || coliziuni[X+1][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X + 2, Y + 1) || coliziuni[X+2][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 2, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 2, Y + 1) || coliziuni[X-2][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 2, Y + 1, contor, 1);
                        }

                        break;
                    case 6:
                        if (!database.Find("loviri", X, Y) || coliziuni[X][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y) || coliziuni[X-1][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X - 2, Y)|| coliziuni[X-2][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X - 2, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X - 3, Y)|| coliziuni[X-3][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X - 3, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X - 3, Y + 1) || coliziuni[X-3][Y+1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 3, Y + 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 3, Y - 1)|| coliziuni[X-3][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 3, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y + 1)|| coliziuni[X-1][Y+1]==0)  {
                            contor++;
                            database.InsertNewLovire(X - 1, Y + 1, contor, 1);
                        }

                        if (!database.Find("loviri", X - 1, Y - 1) || coliziuni[X-1][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y - 2) || coliziuni[X-1][Y-2]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y - 2, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y + 2) || coliziuni[X-1][Y+2]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y + 2, contor, 1);
                        }

                        break;
                    case 7:
                        if (!database.Find("loviri", X, Y) || coliziuni[X][Y]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y - 1) || coliziuni[X][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y - 2)|| coliziuni[X][Y-2]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y - 2, contor, 1);
                        }
                        if (!database.Find("loviri", X, Y - 3)|| coliziuni[X][Y-3]==0) {
                            contor++;
                            database.InsertNewLovire(X, Y - 3, contor, 1);
                        }
                        if (!database.Find("loviri", X - 1, Y - 3)|| coliziuni[X-1][Y-3]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y - 3, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y + 3)|| coliziuni[X+1][Y+3]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y + 3, contor, 1);
                        }
                        if (!database.Find("loviri", X + 1, Y - 1) || coliziuni[X+1][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 1, Y - 1, contor, 1);
                        }

                        if (!database.Find("loviri", X - 1, Y - 1) || coliziuni[X-1][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 1, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X - 2, Y - 1) || coliziuni[X-2][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X - 2, Y - 1, contor, 1);
                        }
                        if (!database.Find("loviri", X + 2, Y - 1)|| coliziuni[X+2][Y-1]==0) {
                            contor++;
                            database.InsertNewLovire(X + 2, Y - 1, contor, 1);
                        }

                        break;

                    default:
                        break;
                }
            }

        if ((Coord.Find(String.valueOf(X) + " " + String.valueOf(Y), "CoordonateleAvioanelorAtacate")||coliziuni[X][Y]==0)) {
            contor++;
            database.InsertNewLovire(contor, X, Y, 1);
        }
       else {
            System.out.println(Coord.Find(String.valueOf(X) + " " + String.valueOf(Y), "CoordonateAvioane"));
            contor++;
            if (!database.Find("loviri", X, Y))
            database.InsertNewLovire(contor, X, Y, 0);
        }
    }
        return contor;
}
    public static void DesenareAvioaneFull(int[] AfisareAvioane, DatabaseSingleton database, int[][] coliziuni, Graphics g,int n) throws SQLException, CoordDepasescZona {
        for (int i = 0; i <=n ; i++) {
            switch (AfisareAvioane[i]) {
                case 4:
                        DesenareMapa.CapSus(g, database.GetX("avioane",i), database.GetY("avioane",i), coliziuni);
                    break;
                case 5:
                    DesenareMapa.CapDreapta(g, database.GetX("avioane",i), database.GetY("avioane",i), coliziuni);
                    break;
                case 6:
                    DesenareMapa.CapJos(g, database.GetX("avioane",i), database.GetY("avioane",i), coliziuni);
                    break;
                case 7:
                    DesenareMapa.CapStanga(g, database.GetX("avioane",i), database.GetY("avioane",i), coliziuni);
                    break;
                default:
                    break;
            }

        }
    }

    public static void DesenareLoviri(DatabaseSingleton database,int n, Graphics g) throws Exception {
        int i;

        for(i=0;i<=n;i++)
        {
            if (database.FindReusit(i)==1 )
            {
                Tile.lovit.Draw(g, (database.GetY("loviri",i)) * Tile.TILE_WIDTH, (database.GetX("loviri",i)) * Tile.TILE_HEIGHT);
            }
            else if (database.FindReusit(i)==0)
            {
                Tile.aer.Draw(g, (database.GetY("loviri",i)) * Tile.TILE_WIDTH, (database.GetX("loviri",i)) * Tile.TILE_HEIGHT);
            }
        }
    }

}
