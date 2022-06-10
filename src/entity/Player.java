package entity;

import PaooGame.Game;
import PaooGame.KeyboardHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    Game gp;
    KeyboardHandler kh;
    int MiscareNr;
    int MiscareCounter;
    int [][]poz=new int[5][2];




    public void getPlayerImage()  {


            try {
                up1 = ImageIO.read(this.getClass().getResourceAsStream("/textures/boy_up_1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }



            try {
                up2 = ImageIO.read(getClass().getResourceAsStream("/textures/boy_up_2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                down1 = ImageIO.read(getClass().getResourceAsStream("/textures/boy_down_1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                down2 = ImageIO.read(getClass().getResourceAsStream("/textures/boy_down_2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                left1 = ImageIO.read(getClass().getResourceAsStream("/textures/boy_left_1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                left2 = ImageIO.read(getClass().getResourceAsStream("/textures/boy_left_2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                right1 = ImageIO.read(getClass().getResourceAsStream("/textures/boy_right_1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                right2 = ImageIO.read(getClass().getResourceAsStream("/textures/boy_right_2.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public Player (Game gp, KeyboardHandler kh,int x)
    {

        this.gp=gp;
        this.kh=kh;
        setDefaultValues(x);
        getPlayerImage();

    }
    public void setDefaultValues (int op)
    {
        switch(op)
        {
            case 1:
                x=48*4;
                y=48*5;
                break;
            case 2:
                y=96;
                x=48;
                break;
        }
        speed=48;
        direction="down";
        MiscareNr=1;
        MiscareCounter=0;
    }


    boolean MaAfluPeGraficulMeu (int x,int y)
    {
        return (x>=2 && x<=15 && y>=1 && y<=15);

    }

    public boolean MaAfluPeRadar(int x, int y)
    {
        return (x>=2 && x<=15 && y>=16 && y<=29);

    }
    public void update (int[][] coliziuni )
    {

        if(kh.v[0]|| kh.v[1] || kh.v[2] || kh.v[3] || kh.v[4]) {

            if ((kh.v[0] && coliziuni[(y-speed)/48][x/48]==1) || (kh.v[0] && coliziuni[(y-speed)/48][x/48]==0 && MaAfluPeRadar((y-speed)/48,x/48))) {
                    direction = "up";
                    y = y - speed;

            }
            if ((kh.v[1]&& coliziuni[y/48][(x+speed)/48]==1) || (kh.v[1] && coliziuni[(y)/48][(x+speed)/48]==0 && MaAfluPeRadar(y/48,(x+speed)/48))) {
                    direction = "right";
                    x = x + speed;
            }
            if ((kh.v[2] && coliziuni[y/48][(x-speed)/48]==1) || (kh.v[2] && coliziuni[y/48][(x-speed)/48]==0 && MaAfluPeRadar(y/48,(x-speed)/48))) {
                    direction = "down";
                    x = x - speed;
            }
            if ((kh.v[3] && coliziuni[y/48+speed/48][x/48]==1) || (kh.v[3] && coliziuni[(y)/48+speed/48][x/48]==0 && MaAfluPeRadar(y/48+speed/48,x/48))) {
                    direction = "left";
                    y = y + speed;
            }

        }
        MiscareCounter++;
        if (MiscareCounter > 1) {
            if (MiscareNr == 1) {
                MiscareNr = 2;
            } else if (MiscareNr == 2) {
                MiscareNr = 1;
            }
            MiscareCounter = 0;
        }

    }


    public void DrawPlayer (Graphics g)
    {
        BufferedImage image =null;
        switch (direction)
        {
            case "up":
                if(MiscareNr==1) {
                    image = up1;
                }
                else if(MiscareNr==2)
                {
                    image=up2;
                }
                break;
            case"down":
                if(MiscareNr==1) {
                    image = left1;
                }
                else if(MiscareNr==2)
                {
                    image=left2;
                }
                break;
            case"left":
                if(MiscareNr==1) {
                    image = down1;
                }
                else if(MiscareNr==2)
                {
                    image=down2;
                }
                break;
            case"right":
                if(MiscareNr==1) {
                    image = right1;
                }
                else if(MiscareNr==2)
                {
                    image=right2;
                }
                break;
        }
        g.drawImage(image, x, y,48,48,null);
    }

    public int getX ()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

}
