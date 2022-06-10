package PaooGame.Database;
import PaooGame.Game;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseSingleton {
    private volatile static DatabaseSingleton instance = null;
   // private final int NUMBER_OF_LEVELS = 4;

    private Connection connection = null;
    private Statement statement = null;


    private DatabaseSingleton(){
        // Establish the connection to the database
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:GDataBase.db");
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            System.out.println("Connection to the database has been established!");

            // Create the tables if they don't exist
            this.CreateTables();
        }
        catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public static DatabaseSingleton getInstance(){
        if(instance == null)
            instance = new DatabaseSingleton();
        return instance;
    }

    private void CreateTables(){
        if(connection != null){
            try{
                String avioaneTableSql = "CREATE TABLE avioane " +
                        "(id INT  PRIMARY KEY NOT NULL, " +
                        "X INT NOT NULL,"+"Y INT NOT NULL, POZ INT NOT NULL );";

                String LoviriTableSql = "CREATE TABLE loviri " +
                        "(id INT  PRIMARY KEY NOT NULL, " +
                        "X INT NOT NULL,"+"Y INT NOT NULL"+",REUSIT INT NOT NULL );";


                statement.executeUpdate(avioaneTableSql);
               statement.executeUpdate(LoviriTableSql);
               connection.commit();

                System.out.println("Database tables if didn't exist before, have been created successfully!");

            }catch (Exception e){
                System.out.println( e.getMessage() );
            }
        }
    }

    public int FindReusit (int i) throws SQLException {

        String sql = "SELECT REUSIT FROM loviri WHERE id=" + i+";";
        ResultSet rs = statement.executeQuery(sql);
        connection.commit();
        if(rs.next())
        {
            return rs.getInt("REUSIT");
        }

        return -1;
    }

    public boolean FindId (String baza, int id) throws Exception {
        String sql = "SELECT * FROM "+baza+" WHERE id="+id+";";
        ResultSet firstResult = statement.executeQuery(sql);
        connection.commit();

        while(firstResult.next()){
            return true;
        }
        return false;
    }

    public boolean Find(String baza, int x, int y) throws Exception {
        String sql = "SELECT * FROM "+baza+" WHERE X="+x+" AND Y= "+y+";";
        ResultSet firstResult = statement.executeQuery(sql);
        connection.commit();

        while(firstResult.next()){
           return true;
        }
        return false;
    }

    public void InsertNewAvion(int x, int y, int avion, int poz){


        try{
            // cautam in baza de date daca acest avion exista deja
            String sql = "SELECT * FROM avioane WHERE id="+avion+";";
            ResultSet Result = statement.executeQuery(sql);
            connection.commit();

            if(Result.next()){
                throw new Exception("Name already exists in database!");
            }

            sql = "INSERT INTO avioane (id ,X,Y,POZ) VALUES ("+avion+","+ x +","+y+","+poz+");";
            statement.executeUpdate(sql);
            connection.commit();
        }
        catch(Exception e){
            System.out.println( e.getMessage() );
        }
    }

    public void InsertNewLovire(int id,int x, int y, int reusit) throws Exception {

            String sql = "SELECT * FROM loviri WHERE  X= " + x +" AND Y="+y+ ";";
            ResultSet firstResult = statement.executeQuery(sql);
            connection.commit();

            if(firstResult.next()){
                throw new Exception("Name already exists in database!");
            }

            sql = "INSERT INTO loviri (id,X,Y,REUSIT) VALUES ("+id+","+ x +","+y+","+reusit+");";

                statement.executeUpdate(sql);
                connection.commit();
        }

    public void Close(){
        if(connection != null){
            try {
                statement.close();
                connection.close();
                System.out.println("The connection has successfully been closed!");
            }
            catch(Exception e){
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
        }
    }


    public int GetX(String s, int id) throws SQLException {


            String sql = "SELECT X FROM "+s+" WHERE id = "+ id +";";
            ResultSet myResult = statement.executeQuery(sql);
            connection.commit();
            return myResult.getInt("X");

    }


    public int GetY(String s, int id){

        try {
            String sql ="SELECT Y FROM "+s+" WHERE id = "+ id +";";
            ResultSet myResult = statement.executeQuery(sql);
            connection.commit();
            return myResult.getInt("Y");
        }
        catch (Exception e){
            System.out.println( e.getMessage() );
        }

        return -1;
    }

    public int GetPoz(String s, int x,int y) throws SQLException {

            String sql ="SELECT POZ FROM avioane WHERE X ="+ x +" AND Y="+y+";";
            ResultSet rs2 = statement.executeQuery(sql);
            connection.commit();
            return rs2.getInt("POZ");

    }

    public void Delete(int avion_id){

        try {
            String sql = "DELETE FROM avioane WHERE id = "+ avion_id +";";
            ResultSet myResult = statement.executeQuery(sql);
            connection.commit();
        }
        catch (Exception e){
            System.out.println( e.getMessage() );
        }
    }


    public void DeleteRadar(int id){

        try {
            String sql = "DELETE FROM loviri WHERE id = "+ id +";";
            ResultSet myResult = statement.executeQuery(sql);
            connection.commit();
        }
        catch (Exception e){
            System.out.println( e.getMessage() );
        }
    }

}
