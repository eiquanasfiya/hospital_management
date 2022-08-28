package repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseConnection {
    Connection con;
    public BaseConnection(){
        openConnection();
    }



    public void openConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmanagementsystem","root","");
        }catch (Exception e){
            System.out.println(e);
        }
    }


}