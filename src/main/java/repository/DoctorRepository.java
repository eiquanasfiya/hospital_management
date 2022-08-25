package repository;

import domain.Doctor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository extends BaseConnection {

    public Double getDoctorFees(String doctorName) {
        Double amount = 0.0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select fee from doctor where d_name = '"+doctorName+"'");
            while (rs.next()) {
                amount = Double.parseDouble(rs.getString("fee"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return amount;
    }

    public List<String> getDoctorsName() {
        List<String> doctorsName = new ArrayList();
        int i =0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select d_name from doctor");
            while (rs.next()) {
                String dName = rs.getString("d_name");
                doctorsName.add(dName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return doctorsName;
    }

    public List<Doctor> getDoctorByName(String doctorName) {
        List<Doctor> doctors = new ArrayList<>();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from doctor where d_name = '"+doctorName+"'");
            while (rs.next()) {
                String dName = rs.getString("d_name");
                String contact = rs.getString("contact");
                String specialization = rs.getString("specialization");
                String address = rs.getString("address");
                Double fee = Double.parseDouble(rs.getString("fee"));

                doctors.add(new Doctor(dName,contact,specialization,address,fee));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return doctors;

    }

    public int getDoctorIdByName(String doctorNamec) {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select id from doctor where d_name = '"+doctorNamec+"'");
            while(rs.next()){
                id = Integer.parseInt(rs.getString("id"));
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
        return id;
    }
}
