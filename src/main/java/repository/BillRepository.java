package repository;

import java.sql.SQLException;
import java.sql.Statement;

public class BillRepository extends BaseConnection{
    public Boolean addBill(String invoiceNumber, int appointmentId) {
        boolean flag = true;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate("insert into bill(invoiceNumber,appoinment_id) values('"+invoiceNumber+"','"+appointmentId+"')");
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flag;
    }
}
