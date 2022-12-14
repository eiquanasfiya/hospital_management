package repository;

import domain.Appointment;
import domain.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository extends BaseConnection {
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointment = new ArrayList<>();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select a.id,a.appointmentNumber,a.date, a.time, a.serviceCharges, d.d_name as doctor_name, d.specialization, d.fee, p.name as patient_name, p.contact from appointment a join doctor d on a.doctor_id=d.id join patient p on a.patient_id= p.id");
            while (rs.next()) {
                Integer id = Integer.parseInt(rs.getString("id"));
                String appointmentNumber = rs.getString("appointmentNumber");
                String date = rs.getString("date");
                String time = rs.getString("time");
                Double serviceCharges = Double.parseDouble(rs.getString("serviceCharges")) ;
                String doctorName = rs.getString("doctor_name");
                String specialization = rs.getString("specialization");
                Double fee = Double.parseDouble(rs.getString("fee"));
                String patientName = rs.getString("patient_name");
                String contact = rs.getString("contact");


                appointment.add(new Appointment(id,appointmentNumber,date, time, serviceCharges, doctorName, specialization, fee, patientName, contact));
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
        return appointment;
    }

    public List<Appointment> getAppointmentByContact(String Contact) {
        List<Appointment> appointment = new ArrayList<>();
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select a.id,a.appointmentNumber,a.date, a.time, a.serviceCharges, d.d_name as doctor_name, d.specialization, d.fee, p.name as patient_name, p.contact from appointment a join doctor d on a.doctor_id=d.id join patient p on a.patient_id= p.id where p.contact= '"+Contact+"';");
            while (rs.next()) {
                Integer id = Integer.parseInt(rs.getString("id"));
                String appointmentNumber = rs.getString("appointmentNumber");
                String date = rs.getString("date");
                String time = rs.getString("time");
                Double serviceCharges = Double.parseDouble(rs.getString("serviceCharges"));
                String doctorName = rs.getString("doctor_name");
                String specialization = (rs.getString("specialization"));
                Double fee = Double.parseDouble(rs.getString("fee"));
                String patientName = rs.getString("patient_name");
                String contact = rs.getString("contact");


                appointment.add(new Appointment(id,appointmentNumber,date, time, serviceCharges, doctorName, specialization, fee, patientName, contact));
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
        return appointment;

    }

    public Boolean addAppointment(String appointmentNumber,String date, String time, Double serviceCharges, int doctorId, int patientId) {
        boolean flag = true;
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate("insert into appointment(appointmentNumber,date,time,serviceCharges,doctor_id,patient_id) values('"+appointmentNumber+"','"+date+"','"+time+"','"+serviceCharges+"','"+doctorId+"','"+patientId+"')");
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

    public int getAppointmentIdByAppointmentNumber(String appointmentNumber) {
        int id = 0;
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select id from appointment where appointmentNumber = '"+appointmentNumber+"'");
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

    public String getLatestAppointmentNumber() {
        String appointmentNumber = "";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(appointmentNumber) as appointmentNumber\n" +
                    "FROM appointment;");
            while(rs.next()){
                appointmentNumber = rs.getString("appointmentNumber");
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
        return appointmentNumber;
    }

    public Boolean appointmentDeletebycontact(String contact) {
        boolean flag=true;
        Statement st=null;
        try {
            st=con.createStatement();
            st.executeUpdate("delete a from appointment a join patient p on a.patient_id = p.id where contact ='"+contact+"'");
            st.executeUpdate("delete from patient where contact ='"+contact+"'");

        }catch (SQLException throwables){
            throwables.printStackTrace();
            flag=false;
        }
        finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return flag;
    }
    public Appointment sendChakeAppoindmentData(String contact) {
        try{Appointment appointment=null;


            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select a.appointmentNumber,a.date,a.time,d.d_name,p.name,p.address,p.contact,p.age,p.gender from appointment a join patient p on a.patient_id = p.id join doctor d on a.doctor_id=d.id where p.contact ='"+contact+"'");
            while (rs.next()) {
                appointment = new Appointment();
                appointment.populate(rs);

            }
            return appointment;
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;


    }


    public boolean updateAppointment(String appointmentNumber, String date, String time, int doctor_id, int patient_id,String patientContact) {
        boolean flag=false;
        Statement st=null;
        try {
            st=con.createStatement();
            st.executeUpdate("update appointment a join patient p on a.patient_id = p.id set a.appointmentNumber = '"+appointmentNumber+"',a.date = '"+date+"',a.time='"+time+"',a.doctor_id='"+doctor_id+"' where p.contact = '"+patientContact+"';");
            flag=true;


        }catch (SQLException throwables){
            throwables.printStackTrace();
            flag=false;
        }
        finally {
            try {
                con.close();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return flag;
    }
}

