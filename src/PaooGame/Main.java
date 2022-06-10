package PaooGame;

import PaooGame.GameWindow.GameWindow;

import java.awt.*;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException {
        Game paooGame = new Game("titlu joc", 1490, 800);
        paooGame.StartGame();
    }
}
