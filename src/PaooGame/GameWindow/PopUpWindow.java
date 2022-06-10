package PaooGame.GameWindow;

import javax.swing.*;
import java.awt.*;

public class PopUpWindow {
    private JFrame PopUpFrame;
    private int     Width;       /*!< latimea ferestrei in pixeli*/
    private int     Height;

    public PopUpWindow(int width, int height){
        Width    = width;
        Height   = height;
        PopUpFrame    = null;
    }


    public void BuilPopUpWindow()
    {

        if(PopUpFrame != null)
        {
            return;
        }

        PopUpFrame = new JFrame();
        PopUpFrame.setSize(Width, Height);
        PopUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PopUpFrame.setResizable(false);
        PopUpFrame.setLocationRelativeTo(null);
        PopUpFrame.setVisible(true);
        PopUpFrame.pack();
    }


}
