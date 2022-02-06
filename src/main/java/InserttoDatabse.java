import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InserttoDatabse {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        // create a mysql database connection
       /* System.out.println("Connect to Musql Database");
        String myDriver = "com.mysql.jdbc.Drive";
        String myUrl = "jdbc:mysql://localhost:3306/broadcom";
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(myUrl, "root", "");
        System.out.println("Connected to Musql Database");*/
        //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        Class.forName("com.mysql.jdbc.Drive");
    }
}
