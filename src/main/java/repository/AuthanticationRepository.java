package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthanticationRepository extends BaseConnection{
    public String login(String username, String password){
        String type = "";
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from login where username = '"+username+"' and password = '"+password+"'");
            while(rs.next()){
                type = rs.getString("type");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return type;
    }
}
