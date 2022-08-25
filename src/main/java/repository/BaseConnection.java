package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseConnection {
    static Connection con;

    BaseConnection(){
        openConnection();
    }

    public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospitalmanagementsystem", "root", "");
            System.out.println("Connected Successfully");
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from doctor");
//            while(rs.next())
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(7));
//            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
