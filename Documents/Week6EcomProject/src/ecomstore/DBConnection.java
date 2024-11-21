package ecomstore;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;

    public  static Connection createDbConnection(){

       try{
           //        Load driver
           Class.forName("com.mysql.cj.jdbc.Driver");

           // get connection

           String url="jdbc:mysql://localhost:3306/ecomstore?useSSL=false";
           String username="root";
           String password="Kensmith@1997";

          con = DriverManager.getConnection(url,username,password);
       } catch (Exception e) {
         e.printStackTrace();
       }
        return con;

    }
}
