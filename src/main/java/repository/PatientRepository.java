package repository;

import domain.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository extends BaseConnection {
    public List<Patient> getAllPatients() {
        List<Patient> patient = new ArrayList<>();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from patient");
            while(rs.next()){
                String patientName = rs.getString("name");
                String patientAddress=rs.getString("address");
                String patientContact=rs.getString("contact");
                String pateintAge= rs.getString("age");
                String patientGender= (rs.getString("gender"));

                patient.add(new Patient(patientName,patientAddress,patientContact,pateintAge,patientGender));
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
        return patient;
    }


    public Boolean addPatient(String name, String address, String contact, String age, String gender) {
        boolean flag = true;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate("insert into patient(name,age,address,contact,gender) values('"+name+"','"+age+"','"+address+"','"+contact+"','"+gender+"')");
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

    public List<Patient> getPatientByContact(String contact) {
        List<Patient> patient = new ArrayList<>();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from patient where contact = '"+contact+"'");
            while(rs.next()){
                String patientName = rs.getString("name");
                String patientAddress=rs.getString("address");
                String patientContact=rs.getString("contact");
                String pateintAge= rs.getString("age");
                String patientGender= (rs.getString("gender"));

                patient.add(new Patient(patientName,patientAddress,patientContact,pateintAge,patientGender));
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
        return patient;
    }

    public int getPatientIdByContact(String contact) {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select id from patient where contact = '"+contact+"'");
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
