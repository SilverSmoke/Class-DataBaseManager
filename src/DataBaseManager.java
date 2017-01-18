import java.sql.*;

/**
 * Created by belikov.a on 17.01.2017.
 */
public class DataBaseManager {

    private static String urlDB = "jdbc:mysql://localhost:3306/dbast";
    private static String user = "root";
    private static String pass = "";

    private static Connection connect;
    private static Statement statement;
    private static ResultSet result;

    DataBaseManager(String urlDB, String user, String pass){
        this.urlDB = urlDB;
        this.user = user;
        this.pass = pass;
    }
    DataBaseManager(){

    }

    public ResultSet getResult(String query){
        try{

            connect = DriverManager.getConnection(urlDB, user, pass);

            System.out.println(connect);

            statement = connect.createStatement();

            result = statement.executeQuery(query);

        }catch(Exception sqlEx){
            sqlEx.printStackTrace();
        }finally {
            return result;
        }
    }
    protected void finalize(){
        try{connect.close();}catch(Exception ex){}
        try{statement.close();}catch(Exception ex){}
        try{result.close();}catch(Exception ex){}
        System.out.println("OK");
    }
}
