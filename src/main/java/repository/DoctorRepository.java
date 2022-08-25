package Repository;

import domain.Doctor;

import javax.print.Doc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorRepository extends BaseConnection{
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
                    ("insert into doctor(name, contact, specialization, address, fee) values(?,?,?,?,?)");
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
                    "set  name=?,\n" +
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




    public static void main(String[] args) {
        DoctorRepository doctorRepository=new DoctorRepository();
  //      doctorRepository.getAllDoctors().forEach(doctor -> System.out.println(doctor));
//        doctorRepository.updateDoctor("0322111554","Farhan","Block B North Nazimabad",
//                "neorologist","03107314278","2000");
//        doctorRepository.deleteDoctor("03107314278");
  //      doctorRepository.addDoctorFromJtable("farhan","Test","test","938393","1500");

       // System.out.println( doctorRepository.searchDoctor("0326456844"));


    }




}
