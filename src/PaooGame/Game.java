package PaooGame;
import PaooGame.Database.DatabaseSingleton;
import PaooGame.GameWindow.*;
import PaooGame.Graphics.Assets;
import PaooGame.Tiles.DesenareMapa;
import PaooGame.Tiles.DisplayScore;
import PaooGame.Tiles.Tile;
import entity.Player;
import PaooGame.Scor;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.DataBuffer;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Game implements Runnable {
    boolean val = true;
    boolean atac = false;
    boolean GameState1=true;
    Scor subject = new Scor();
    DisplayScore ds = new DisplayScore(subject);

    int Scor = 0;
    int AvioaneMoarte = 0;
    private GameWindow wnd;
    private boolean runState;
    private Thread gameThread;
    private int LevelCounter=0;
    private BufferStrategy bs;
    KeyboardHandler kh = new KeyboardHandler();
    public Graphics g;
    private Tile tile;
    int contor = -1;
    Waiter w = new Waiter();
    int contorLoviri = -1;
    int GameState = 1;
    int[] AfisareAvioane = {0, 0, 0, 0, 0, 0};
    int x, y;
    boolean ok = true;
    boolean ok2=true;
    public UI ui = new UI(this);
    public static DatabaseSingleton database = DatabaseSingleton.getInstance();
    String coordonateAvioaneleMele = "";
    Player player=new Player(this,kh,1);
    int[][] coliziuni;

    public Game(String title, int width, int height) {
        wnd = new GameWindow(title, width, height);
        runState = false;
    }

    private void InitGame() {
        wnd = new GameWindow("Avione", 1490, 800);
        wnd.BuildGameWindow();
        Assets.Init();
    }

    public void run() {
        InitGame();
        double drawInterval = 1000000000 / 10;


        double nextDrawTime = System.nanoTime() + drawInterval;

        while (runState) {
            Update();
            try {
                Draw();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void StartGame() {
        if (runState == false) {
            runState = true;
            gameThread = new Thread(this);
            gameThread.start();
        } else {
            return;
        }
    }


    public synchronized void StopGame() {
        if (runState) {
            runState = false;
            try {
                gameThread.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } else {
            return;
        }
    }


    private void Update() {
        wnd.GetCanvas().addKeyListener(kh);
        player.update(coliziuni);

    }

    private void Draw() throws Exception {
        bs = wnd.GetCanvas().getBufferStrategy();
        if (bs == null) {
            try {
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());

        if(GameState==1) {

            DesenareMapa.DenesareCer1(g);
            DesenareMapa.DesenezMine1(g);
            DesenareMapa.DesenezRadar1(g);
            coliziuni = DesenareMapa.GetColiziuni1();

        if(ok)
        {
            database.Delete(0);
            database.Delete(1);
            database.Delete(2);
           database.Delete(3);
           database.Delete(4);
           database.Delete(5);
           for(int k=0;k<200;k++)  //14*14=196 cazul cel mai defavorabil in care atac fiecare casuta de pe radar
               if(database.FindId("loviri",k)) {
                   database.DeleteRadar(k);
               }

            ok=false;
        }

            //cu V plasez avionul cu capul in sus

            if (kh.v[4]) {
                y = player.getX() / 48;
                x = player.getY() / 48;
                if (!database.Find("avioane", x, y) ){

                        if (DesenareMapa.VerifCapSus(x, y, coliziuni) > 0) {
                            contor++;
                            database.InsertNewAvion(x, y, contor, 4);
                            AfisareAvioane[contor] = 4;
                        }
                        else
                        {
                            try {
                                UI.showMessage("Avionul plasat gresit.",300,300);
                                throw new CoordDepasescZona();
                            }

                            catch(Exception e) { }
                        }
                }
            }

//cu B plasez avionul cu capul la dreapta
            if (kh.v[5]) {
                y = player.getX() / 48;
                x = player.getY() / 48;
                if (!database.Find("avioane", x, y)) {


                    if (DesenareMapa.VerifCapDreapta(x, y, coliziuni) > 0) {
                        contor++;
                        database.InsertNewAvion(x, y, contor, 5);
                        AfisareAvioane[contor] = 5;
                    }
                    else
                    {
                        try {
                            UI.showMessage("Avionul plasat gresit.",300,300);
                            throw new CoordDepasescZona();
                        }

                        catch(Exception e) { }
                    }

                }

            }
//cu N plasez avionul cu capul in jos
            if (kh.v[6]) {
                y = player.getX() / 48;
                x = player.getY() / 48;
                if (!database.Find("avioane", x, y)) {

                    if (DesenareMapa.VerifCapJos(x, y, coliziuni) >0) {
                        database.InsertNewAvion(x, y, contor, 6);
                        contor++;
                        AfisareAvioane[contor] = 6;
                    }
                    else
                    {
                        try {
                            UI.showMessage("Avionul plasat gresit.",50,90);
                            throw new CoordDepasescZona();
                        }

                        catch(Exception e) { }
                    }

                }

            }
//cu M  plasez avionul cu capul la stanga
            if (kh.v[7]) {
                y = player.getX() / 48;
                x = player.getY() / 48;
                if (!database.Find("avioane", x, y)) {


                    if (DesenareMapa.VerifCapStanga(x, y, coliziuni) >0) {
                        database.InsertNewAvion(x, y, contor, 7);
                        contor++;
                        AfisareAvioane[contor] = 7;
                    }
                    else
                    {
                        try {
                            UI.showMessage("Avionul plasat gresit.",300,300);
                            throw new CoordDepasescZona();
                        }

                        catch(Exception e) { }
                    }

                }
            }


            if (contor == 0 && val) {
                System.out.println("AM SCHIMBAT DATELE DIN FISIER \n");
                DesenareMapa.DesenezAvionRadar1(g, coliziuni, contor, AfisareAvioane, database);
                val = false;
            }

            DesenareMapa.DesenareAvioaneFull(AfisareAvioane, database, coliziuni, g, contor);

            if (kh.v[8]) {

                try {
                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48)) {

                        if (database.Find("avioane", player.getY() / 48, player.getX() / 48)) {
                            int ScorTemp = 0;
                            switch (database.GetPoz("avioane", player.getY() / 48, player.getX() / 48)) {
                                case 4:

                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 2, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 2, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 3, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 3, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 3, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 3, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 3, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 3, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 - 2)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 - 2, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 + 2)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 + 2, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48)) {
                                        if (ScorTemp == 225)
                                            ScorTemp = 500;
                                        else
                                            ScorTemp = ScorTemp + 50;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 1);
                                        AvioaneMoarte++;
                                        ui.showMessage("Ati doborat un avion!",1100,795);
                                    }

                                    break;
                                case 5:

                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 + 2)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 + 2, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 + 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 + 3, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 2, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 2, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 2, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 2, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 + 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 + 3, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 + 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 + 3, 1);
                                    }


                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48)) {
                                        if (ScorTemp == 225)
                                            ScorTemp = 500;
                                        else
                                            ScorTemp = ScorTemp + 50;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 1);
                                        AvioaneMoarte++;
                                        ui.showMessage("Ati doborat un avion!",1100,795);
                                    }

                                    break;
                                case 6:

                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 2, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 2, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 3, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 3, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 3, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 3, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 3, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;

                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 3, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 + 2, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 - 2)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 - 2, 1);
                                    }

                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48)) {
                                        if (ScorTemp == 225)
                                            ScorTemp = 500;
                                        else
                                            ScorTemp = ScorTemp + 50;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 1);
                                        AvioaneMoarte++;
                                        ui.showMessage("Ati doborat un avion!",1100,795);
                                    }
                                    break;
                                case 7:

                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 - 2)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 - 2, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 - 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 - 3, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 - 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 - 3, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 - 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 - 3, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 2, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 2, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 2, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 2, player.getX() / 48 - 1, 1);
                                    }

                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48)) {
                                        if (ScorTemp == 225)
                                            ScorTemp = 500;
                                        else
                                            ScorTemp = ScorTemp + 50;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 1);
                                        AvioaneMoarte++;
                                        //ui.showMessage("Ati doborat un avion!");
                                    }
                                    break;
                                default:
                                    break;
                            }
                            subject.setScore(Scor + ScorTemp);
                        }
                        if (!database.Find("avioane", player.getY() / 48, player.getX() / 48) && Coord.Find(String.valueOf(player.getY() / 48) + " " + String.valueOf(player.getX() / 48), "CoordonateAvioane")) {
                            contorLoviri++;
                            subject.setScore(Scor + 25);
                            database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 1);
                        }
                        if (!Coord.Find(String.valueOf(player.getY() / 48) + " " + String.valueOf(player.getX() / 48), "CoordonateAvioane")) {
                            System.out.println(Coord.Find(String.valueOf(player.getY() / 48) + " " + String.valueOf(player.getX() / 48), "CoordonateAvioane"));
                            contorLoviri++;
                            database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 0);

                        }
                        atac = true;
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }

            if (atac) {

                //w.run();
                contorLoviri = DesenareMapa.PCAtaca1(coliziuni, contorLoviri, database);
                atac = false;
            }

            try {
                DesenareMapa.DesenareLoviri(database, contorLoviri, g);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //ui.DrawSubWindow(200,20,700,400);
            if (AvioaneMoarte == 1) {
                ui.DrawSubWindow(300, 300, 750, 300, g);
                LevelCounter++;
                if(LevelCounter>50)
                     GameState=2;
            }


            System.out.println(player.getY() / 48 + " " + player.getX() / 48);
            // ui.DrawSubWindow(300,300,750,300,g);
            player.DrawPlayer(g);
            ui.Draw1(g, AvioaneMoarte, subject);
            System.out.println("scorul e: " + subject.GetScor());
            bs.show();
            g.dispose();
        }
        else if (GameState==2)
        {
            if(ok2)
            {
                LevelCounter=0;
                val=true;
                contorLoviri = -1;
                contor = -1;
                database.Delete(0);
                database.Delete(1);
                database.Delete(2);
                database.Delete(3);
                database.Delete(4);
                database.Delete(5);
                Scor=0;
                AvioaneMoarte=0;
                for(int k=0;k<200;k++)  //14*14=196 cazul cel mai defavorabil in care atac fiecare casuta de pe radar
                    if(database.FindId("loviri",k)) {
                        database.DeleteRadar(k);
                    }
                player.setDefaultValues(2);
                ok2=false;
            }
            coliziuni = DesenareMapa.GetColiziuni2();
            DesenareMapa.DenesareCer2(g);
            DesenareMapa.DesenezMine2(g);
            DesenareMapa.DesenezRadar2(g);



            //cu V plasez avionul cu capul in sus

            if (kh.v[4]) {
                y = player.getX() / 48;
                x = player.getY() / 48;
                if (!database.Find("avioane", player.getY() / 48, player.getX() / 48)) {
                    if (DesenareMapa.VerifCapSus(x, y, coliziuni) > 0) {
                        contor++;
                        database.InsertNewAvion(x, y, contor, 4);

                        AfisareAvioane[contor] = 4;
                    }
                    else{
                        try {
                            UI.showMessage("Avionul nu trebuie sa depaseasca zona delimitata de radar.",300,300);
                            throw new CoordDepasescZona();
                        }

                        catch(Exception e) { }
                    }

                }
            }

//cu B plasez avionul cu capul la dreapta
            if (kh.v[5]) {
                y = player.getX() / 48;
                x = player.getY() / 48;
                if (!database.Find("avioane", player.getY() / 48, player.getX() / 48)) {
                    if (DesenareMapa.VerifCapDreapta(x, y, coliziuni) > 0) {
                        contor++;
                        database.InsertNewAvion(x, y, contor, 5);

                        AfisareAvioane[contor] = 5;
                    }
                    else {
                        try {
                            UI.showMessage("Avionul nu trebuie sa depaseasca zona delimitata de radar.",300,300);
                            throw new CoordDepasescZona();
                        }

                        catch(Exception e) { }
                    }

                }

            }
//cu N plasez avionul cu capul in jos
            if (kh.v[6]) {
                y = player.getX() / 48;
                x = player.getY() / 48;
                if (!database.Find("avioane", player.getY() / 48, player.getX() / 48)) {
                    if (DesenareMapa.VerifCapJos(x, y, coliziuni) >0) {
                        contor++;
                        database.InsertNewAvion(x, y, contor, 6);

                        AfisareAvioane[contor] = 6;
                    }
                    else {
                        try {
                            UI.showMessage("Avionul nu trebuie sa depaseasca zona delimitata de radar.",300,300);
                            throw new CoordDepasescZona();
                        }

                        catch(Exception e) { }
                    }
                }

            }
//cu M  plasez avionul cu capul la stanga
            if (kh.v[7]) {
                y = player.getX() / 48;
                x = player.getY() / 48;
                if (!database.Find("avioane", player.getY() / 48, player.getX() / 48)) {
                     if (DesenareMapa.VerifCapStanga(x, y, coliziuni) > 0) {
                        database.InsertNewAvion(x, y, contor, 7);
                        contor++;
                        AfisareAvioane[contor] = 7;
                    }
                     else {
                         try {
                             UI.showMessage("Avionul nu trebuie sa depaseasca zona delimitata de radar.",300,300);
                             throw new CoordDepasescZona();
                         }

                         catch(Exception e) { }
                     }

                }
            }


            if (contor == 2 && val) {
                System.out.println("AM SCHIMBAT DATELE DIN FISIER \n");
                DesenareMapa.DesenezAvionRadar2(g, coliziuni, contor, AfisareAvioane, database);
                val = false;
            }

            DesenareMapa.DesenareAvioaneFull(AfisareAvioane, database, coliziuni, g, contor);

            if (kh.v[8]) {

                try {
                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48)) {

                        if (database.Find("avioane", player.getY() / 48, player.getX() / 48)) {
                            int ScorTemp = 0;
                            switch (database.GetPoz("avioane", player.getY() / 48, player.getX() / 48)) {
                                case 4:

                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 2, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 2, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 3, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 3, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 3, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 3, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 3, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 3, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 - 2)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 - 2, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 + 2)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 + 2, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48)) {
                                        if (ScorTemp == 225)
                                            ScorTemp = 500;
                                        else
                                            ScorTemp = ScorTemp + 50;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 1);
                                        AvioaneMoarte++;
                                        ui.showMessage("Ati doborat un avion!",1100,795);
                                    }

                                    break;
                                case 5:

                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 + 2)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 + 2, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 + 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 + 3, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 2, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 2, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 2, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 2, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 + 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 + 3, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 + 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 + 3, 1);
                                    }


                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48)) {
                                        if (ScorTemp == 225)
                                            ScorTemp = 500;
                                        else
                                            ScorTemp = ScorTemp + 50;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 1);
                                        AvioaneMoarte++;
                                        ui.showMessage("Ati doborat un avion!",1100,795);
                                    }

                                    break;
                                case 6:

                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 2, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 2, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 3, player.getX() / 48)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 3, player.getX() / 48, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 3, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 3, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 3, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;

                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 3, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 + 2, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 + 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 + 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 - 2)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 - 2, 1);
                                    }

                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48)) {
                                        if (ScorTemp == 225)
                                            ScorTemp = 500;
                                        else
                                            ScorTemp = ScorTemp + 50;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 1);
                                        AvioaneMoarte++;
                                        ui.showMessage("Ati doborat un avion!",1100,795);
                                    }
                                    break;
                                case 7:

                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 - 2)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 - 2, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48 - 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48 - 3, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 - 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 - 3, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 - 3)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 - 3, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 2, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 2, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 + 1, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 + 1, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 1, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 1, player.getX() / 48 - 1, 1);
                                    }
                                    if (!database.Find("loviri", player.getY() / 48 - 2, player.getX() / 48 - 1)) {
                                        ScorTemp = ScorTemp + 25;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48 - 2, player.getX() / 48 - 1, 1);
                                    }

                                    if (!database.Find("loviri", player.getY() / 48, player.getX() / 48)) {
                                        if (ScorTemp == 225)
                                            ScorTemp = 500;
                                        else
                                            ScorTemp = ScorTemp + 50;
                                        contorLoviri++;
                                        database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 1);
                                        AvioaneMoarte++;
                                        ui.showMessage("Ati doborat un avion!",1100,795);
                                    }
                                    break;
                                default:
                                    break;
                            }
                            subject.setScore(Scor + ScorTemp);
                        }
                        if (!database.Find("avioane", player.getY() / 48, player.getX() / 48) && Coord.Find(String.valueOf(player.getY() / 48) + " " + String.valueOf(player.getX() / 48), "CoordonateAvioane")) {
                            contorLoviri++;
                            subject.setScore(Scor + 25);
                            database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 1);
                        }
                        if (!Coord.Find(String.valueOf(player.getY() / 48) + " " + String.valueOf(player.getX() / 48), "CoordonateAvioane")) {
                            System.out.println(Coord.Find(String.valueOf(player.getY() / 48) + " " + String.valueOf(player.getX() / 48), "CoordonateAvioane"));
                            contorLoviri++;
                            database.InsertNewLovire(contorLoviri, player.getY() / 48, player.getX() / 48, 0);

                        }
                        atac = true;
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }

            if (atac) {

                //w.run();
                contorLoviri = DesenareMapa.PCAtaca2(coliziuni, contorLoviri, database);
                atac = false;
            }

            try {
                DesenareMapa.DesenareLoviri(database, contorLoviri, g);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            //ui.DrawSubWindow(200,20,700,400);
            if (AvioaneMoarte == 3) {

                ui.DrawSubWindow(300, 300, 750, 300, g);
                LevelCounter++;
                if(LevelCounter>50)
                    runState=false;
            }


            System.out.println(player.getY() / 48 + " " + player.getX() / 48);
            player.DrawPlayer(g);
            ui.Draw2(g, AvioaneMoarte, subject);
            System.out.println("scorul e: " + subject.GetScor());

            bs.show();
            g.dispose();

        }
        //UI

    }

}


