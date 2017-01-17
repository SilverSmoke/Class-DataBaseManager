import java.sql.*;

/**
 * Created by belikov.a on 17.01.2017.
 */
public class DataBaseManager {

    private static final String urlDB = "jdbc:mysql://localhost:3306/checkDB";
    private static final String user = "root";
    private static final String pass = "";

    private static Connection connect;
    private static Statement statement;
    private static ResultSet result;

    DataBaseManager(String query){
        try{

            connect = DriverManager.getConnection(urlDB, user, pass);

            statement = connect.createStatement();

            result = statement.executeQuery(query);

        }catch(Exception sqlEx){
            sqlEx.printStackTrace();
        }finally {
            try{connect.close();}catch(Exception ex){}
            try{statement.close();}catch(SQLException ex){}
            try{result.close();}catch(SQLException ex){}
        }
    }

}
