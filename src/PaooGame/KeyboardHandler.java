package PaooGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {

    public boolean[] v = new boolean [12];
    int op=1;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int codTasta = e.getKeyCode();
        if (codTasta==KeyEvent.VK_UP || codTasta==KeyEvent.VK_W ) v[0]=true;
        if (codTasta==KeyEvent.VK_RIGHT || codTasta==KeyEvent.VK_D ) v[1]=true;
        if (codTasta==KeyEvent.VK_LEFT || codTasta==KeyEvent.VK_A ) v[2]=true;
        if (codTasta==KeyEvent.VK_DOWN || codTasta==KeyEvent.VK_S ) v[3]=true;
        if (codTasta==KeyEvent.VK_V)   {v[4]=true; op=0;}
        if (codTasta==KeyEvent.VK_B) v[5]=true;
        if (codTasta==KeyEvent.VK_N) v[6]=true;
        if (codTasta==KeyEvent.VK_M) v[7]=true;
        if (codTasta==KeyEvent.VK_SPACE) v[8]=true;
        if (codTasta==KeyEvent.VK_P) v[9]=true;
        if (codTasta==KeyEvent.VK_ENTER) v[10]=true;


    }

    @Override
    public void keyReleased(KeyEvent e) {

        int codTasta = e.getKeyCode();
        if (codTasta==KeyEvent.VK_UP || codTasta==KeyEvent.VK_W) v[0]=false;
        if (codTasta==KeyEvent.VK_RIGHT || codTasta==KeyEvent.VK_D ) v[1]=false;
        if (codTasta==KeyEvent.VK_LEFT || codTasta==KeyEvent.VK_A ) v[2]=false;
        if (codTasta==KeyEvent.VK_DOWN || codTasta==KeyEvent.VK_S ) v[3]=false;
        if (codTasta==KeyEvent.VK_V)  {v[4]=false; op=1;}
        if (codTasta==KeyEvent.VK_B) v[5]=false;
        if (codTasta==KeyEvent.VK_N) v[6]=false;
        if (codTasta==KeyEvent.VK_M) v[7]=false;
        if (codTasta==KeyEvent.VK_SPACE) v[8]=false;
        if (codTasta==KeyEvent.VK_P) v[9]=false;
        if (codTasta==KeyEvent.VK_ENTER) v[10]=false;

    }
}
