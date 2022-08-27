package repository;

import domain.Doctor;

import java.sql.PreparedStatement;
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
                Integer id = Integer.parseInt(rs.getString("id"));
                String dName = rs.getString("d_name");
                String contact = rs.getString("contact");
                String specialization = rs.getString("specialization");
                String address = rs.getString("address");
                Double fee = Double.parseDouble(rs.getString("fee"));

                doctors.add(new Doctor(id,dName,contact,specialization,address,fee));

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
    public List<Doctor> getAllDoctors(){
        List<Doctor> doctorList=new ArrayList<>();
        try {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from doctor");
            while (rs.next()){
                Doctor doctor=new Doctor();
                doctor.populate(rs);
                doctorList.add(doctor);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return doctorList;
    }
// ======================================ADD-DOCTOR-SECTION====================================

    public Doctor addDoctorFromJtable(String doctorName, String doctorAddress,
                                      String doctorSpecialization, String doctorContact, String doctorFee) {
        try {
            PreparedStatement ps = con.prepareStatement
                    ("insert into doctor(d_name, contact, specialization, address, fee) values(?,?,?,?,?)");
            ps.setString(1, doctorName);
            ps.setString(4, doctorAddress);
            ps.setString(3, doctorSpecialization);
            ps.setString(2, doctorContact);
            ps.setString(5, doctorFee);
            int i = ps.executeUpdate();
            System.out.println("Record Inserted");

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // ======================================SEARCH-DOCTOR-SECTION====================================

    public Doctor searchDoctor(String doctorContact){
        try{Doctor doctor=null;

            String  query="select * from doctor where contact=\""+doctorContact+"\";";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()) {
                doctor = new Doctor();
                doctor.populate(rs);
            }
            return doctor;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    // ======================================DELETE-DOCTOR-SECTION====================================
    public  void deleteDoctor(String contactNumber){
        try {
            String  query="delete from doctor where contact='"+contactNumber+"';";
            Statement st= con.createStatement();
            int result= st.executeUpdate(query);
            if (result == 0) {
                System.out.println("record not found to delete");
            } else {
                System.out.println(" Doctor Records Deleted ");
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

    // ======================================UPDATE-DOCTOR-SECTION====================================

    public Doctor updateDoctor(String doctorContact, String updateName,String updateAddress,
                               String updateSpecialization,String updateContact,String updateFee){
        try{
            String query="update doctor \n" +
                    "set  d_name=?,\n" +
                    "contact=?, specialization=?,\n" +
                    "address=?, fee=?\n" +
                    "where  contact=?;";
            PreparedStatement ps= con.prepareStatement(query);
            ps.setString(1,updateName);
            ps.setString(4,updateAddress);
            ps.setString(3,updateSpecialization);
            ps.setString(2,updateContact);
            ps.setString(5,updateFee);
            ps.setString(6,doctorContact);
            int i= ps.executeUpdate();
            System.out.println("record Updated");

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
