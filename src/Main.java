import java.sql.ResultSet;

/**
 * Created by belikov.a on 17.01.2017.
 */
public class Main{

    public static void main(String[] args){

        DataBaseManager managerDB = new DataBaseManager();
        //DataBaseManager managerDB = new DataBaseManager("jdbc:mysql://localhost:3306/next", "root", "");

        ResultSet result = managerDB.getResult("SELECT * FROM `country`");

        try {
            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                String author = result.getString(3);
                System.out.printf("id: %d, name: %s, author: %s %n", id, name, author);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        managerDB.finalize();

    }

}
