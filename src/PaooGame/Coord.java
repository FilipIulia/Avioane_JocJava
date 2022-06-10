package PaooGame;
import java.io.*;
import java.util.Scanner;
public class Coord {

    static FileWriter Coord;

    public static void Create(String x, String nume) {
        try {
            Coord = new FileWriter("CoordonateAvioane.txt");
            Coord.write(x);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean Find(String coord,String nume) throws FileNotFoundException {
        File Coord = new File("CoordonateAvioane.txt");
        Scanner myReader = new Scanner(Coord);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if (data.equals(coord))
                return true;
        }
        myReader.close();
        return false;
}




    public static void CloseCoord()
    {
        try {
            Coord.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
