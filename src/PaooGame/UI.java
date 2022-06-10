package PaooGame;
import java.awt.* ;
import javax.swing.* ;
import javax.swing.plaf.ColorUIResource;

import PaooGame.Tiles.Tile;
import PaooGame.Tiles.miniAvion;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import static PaooGame.Tiles.Tile.miniAvion;

public class UI {
    Game gp;
    Font arial_40 ;
    Graphics g2;
    BufferedImage pozaAvion;
    int messageCounter =0;
    int x;
    int y;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    public static boolean messageOn =false;
    public static String messange="";
    public int Scor;
    Font pixelFont;
    public UI (Game gp)
    {
        this.gp=gp;
        this.Scor=0;
        try
        {
            pixelFont= Font.createFont(Font.TRUETYPE_FONT,new File("Minecraft.ttf")).deriveFont(28f);
            GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Minecraft.ttf")));

        }catch(IOException | FontFormatException e)
        {

        }
    }

    public static void showMessage(String text, int x, int y)
    {
        messange=text;
        messageOn=true;

    }

    public void DrawSubWindow (int x, int y, int width,int height,Graphics g2)
    {
        Color c =new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);
        c=new Color(250,253,015);
        g2.setColor(c);
        Font f= pixelFont.deriveFont(55f);
        g2.setFont(f);
        g2.drawString(" VICTORIE! ",x+230,y+150);

   }

    public void DrawSubWindow1 (int x, int y, int width,int height,Graphics g2)
    {
        Color c =new Color(0,0,0,210);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);
        c=new Color(250,253,015);
        g2.setColor(c);
        Font f= pixelFont.deriveFont(55f);
        g2.setFont(f);
        g2.drawString(" PAUZA ",x+230,y+150);
        //g2.setFont(pixelFont);
        //g2.drawString(" Pentru a relua jocul apasati tasta ENTER ",x+230,y+190);

    }


    public void Draw1 (Graphics g2, int AvioaneMoarte, Scor sub)
    {



        g2.setFont(pixelFont);
        g2.setColor(Color.WHITE);
        Tile.miniAvion.Draw(g2, 20, 30);
        g2.drawString(" x " + AvioaneMoarte,70,65);

        if(messageOn)
        {
            Color c = new Color(0,70,193);
            g2.setColor(c);
            g2.drawString(messange,1100,50);
            messageCounter++;
            if(messageCounter > 20)
            {
                messageCounter=0;
                messageOn=false;
            }

        }
        Color c =new Color(58,15,68);
        g2.setColor(c);
       // g2.setFont("Arial",);
        Font f= pixelFont.deriveFont(55f);
        g2.setFont(f);
        g2.drawString(" Nivelul 1 ",600,150);
        pixelFont.deriveFont(28f);
        g2.setFont(pixelFont);
        g2.drawString("a    b    c    d    e    f    g",195,230);
        g2.drawString("a    b    c    d    e    f    g",960,230);
        g2.drawString("1",163,278);
        g2.drawString("2",163,326);
        g2.drawString("3",163,374);
        g2.drawString("4",163,422);
        g2.drawString("5",163,470);
        g2.drawString("6",163,518);
        g2.drawString("7",163,566);

        g2.drawString("1",163+765,278);
        g2.drawString("2",163+765,326);
        g2.drawString("3",163+765,374);
        g2.drawString("4",163+765,422);
        g2.drawString("5",163+765,470);
        g2.drawString("6",163+765,518);
        g2.drawString("7",163+765,566);

        c =new Color(255,255,255);
        g2.setColor(c);
        this.playTime += 0.016666666666666666;
        String var6 = "Time:" + this.dFormat.format(this.playTime);
        g2.drawString(var6,1200,700);
        g2.drawString("Scor: "+sub.GetScor() +"",1000,700);


    }

    public void Draw2 (Graphics g2, int AvioaneMoarte, Scor sub)
    {



        g2.setFont(pixelFont);
        g2.setColor(Color.WHITE);
        Tile.miniAvion.Draw(g2, 20, 30);
        g2.drawString(" x " + AvioaneMoarte,70,65);

        if(messageOn)
        {
            Color c = new Color(0,70,139);
            g2.setColor(c);
            g2.drawString(messange,50,795);
            messageCounter++;
            if(messageCounter > 20)
            {
                messageCounter=0;
                messageOn=false;
            }

        }
        Color c =new Color(58,15,68);
        g2.setColor(c);
        g2.setFont(pixelFont);
        c =new Color(255,255,255);
        g2.setColor(c);
        this.playTime += 0.016666666666666666;

        Font f= pixelFont.deriveFont(28.5f);
        g2.setFont(f);
        g2.drawString("a    b    c    d    e    f    g    h    i    j    k    l    m",56,93);
        g2.drawString("a    b    c    d    e    f    g    h    i    j    k    l    m",75+144+560,93);
        g2.drawString("1",26,130);
        g2.drawString("2",26,178);
        g2.drawString("3",26,226);
        g2.drawString("4",26,274);
        g2.drawString("5",26,322);
        g2.drawString("6",26,370);
        g2.drawString("7",26,418);
        g2.drawString("8",26,474);
        g2.drawString("9",26,522);
        g2.drawString("10",18,570);
        g2.drawString("11",18,618);
        g2.drawString("12",18,666);
        g2.drawString("13",18,714);
        g2.drawString("14",18,762);

        g2.drawString("1",26+672+672+96,130);
        g2.drawString("2",26+672+672+96,178);
        g2.drawString("3",26+672+672+96,226);
        g2.drawString("4",26+672+672+96,274);
        g2.drawString("5",26+672+672+96,322);
        g2.drawString("6",26+672+672+96,370);
        g2.drawString("7",26+672+672+96,418);
        g2.drawString("8",26+672+672+96,474);
        g2.drawString("9",26+672+672+96,522);
        g2.drawString("10",16+672+672+96,570);
        g2.drawString("11",16+672+672+96,618);
        g2.drawString("12",16+672+672+96,666);
        g2.drawString("13",16+672+672+96,714);
        g2.drawString("14",16+672+672+96,762);
        f= pixelFont.deriveFont(55f);
        c=new Color(0,0,139);
        g2.setFont(f);
        g2.setColor(c);
        g2.drawString(" Nivelul 2 ",600,55);
        pixelFont.deriveFont(28f);
        g2.setFont(pixelFont);
        c=new Color(18,143,200);
        g2.setColor(c);
        String var6 = "Time:  " + this.dFormat.format(this.playTime);
        g2.drawString(var6,1300,795);
        g2.drawString("Scor: "+sub.GetScor() +"",1100,795);


    }
}
