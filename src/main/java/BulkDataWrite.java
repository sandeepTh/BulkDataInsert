import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BulkDataWrite {


    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

        /*List<String[]> csvData = createCsvDataSimple();
        try (CSVWriter writer = new CSVWriter(new FileWriter("C:\\BulkData\\test.csv"))) {
            writer.writeAll(csvData);
        }*/

        DatabseInsertRecords();

    }

    private static void DatabseInsertRecords() throws SQLException, ClassNotFoundException {
        String myUrl = "jdbc:mysql://localhost:3306/broadcom";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(myUrl, "root", "mysql");
        System.out.println("Connected to Musql Database");
        // create a sql date object so we can use it in our INSERT statement
        //  Calendar calendar = Calendar.getInstance();
        //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        // the mysql insert statement
        String query = " insert into userData.CUSTOMERS (ID,FirstName, LastName,AGE,ADDRESS1,ADDRESS2)"
                + " values ( ?,?,?,?,?, ?)";

        //insert into userData.CUSTOMERS (ID,FirstName, LastName,AGE,ADDRESS1,ADDRESS2) values (1, 'Rubble', 'Rublle',2,"","");

        // create the mysql insert preparedstatement

        for(int i=3;i<20;i++) {

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setLong(1, i);
            preparedStmt.setString (2, "fn"+i);
            preparedStmt.setString (3, "ln"+i);
            preparedStmt.setInt (4, ThreadLocalRandom.current().nextInt(4, 90 + 1));
            preparedStmt.setString (5, "");
            preparedStmt.setString (6, "");
            // execute the preparedstatement
            preparedStmt.execute();
        }
        conn.close();
    }


    private static List<String[]> createCsvDataSimple() {
        List<String[]> list = new ArrayList<>();
        String[] header = {"id", "firstname","lastName","age","address 1","address2"};
        //String[] record1 = {"1", "first name", "lastName","age","address 1", "11111"};
        list.add(header);
        for(int i=0;i<1000000;i++){
            int randomNum =  ThreadLocalRandom.current().nextInt(4, 90 + 1);
            String[] record2 = {String.valueOf(i),"fN_"+i,"lN_"+i, String.valueOf(randomNum),"addess1","addres2"};
            list.add(record2);
        }
        return list;
    }


}
