package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;


@Builder
@Getter
@Setter
@ToString

public class Appointment {
    public Appointment(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointmentNumber() {
        return appointmentNumber;
    }

    public void setAppointmentNumber(String appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getServiceCharges() {
        return serviceCharges;
    }

    public void setServiceCharges(Double serviceCharges) {
        this.serviceCharges = serviceCharges;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    private int id;
    private String appointmentNumber;
    private String date;
    private String time;
    private Double serviceCharges;
    private String doctorName;
    private String specialization;
    private Double fee;
    private String patientName;
    private String contact;

    public Appointment(int id,String appointmentNumber,String date, String time, Double serviceCharges, String doctorName, String specialization, Double fee, String patientName, String contact) {
        this.id=id;
        this.appointmentNumber=appointmentNumber;
        this.date = date;
        this.time = time;
        this.serviceCharges = serviceCharges;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.fee = fee;
        this.patientName = patientName;
        this.contact = contact;
    }
    public void populate(ResultSet rs){
        try {

            this.setAppointmentNumber(rs.getString("appointmentNumber"));
            this.setDate(rs.getString("date"));
            this.setTime(rs.getString("time"));
//            this.setServiceCharges(Double.parseDouble(rs.getString("serviceCharges")));
            this.setDoctorName(rs.getString("d_name"));
//            this.setSpecialization(rs.getString("specialization"));
//            this.setFee(Double.parseDouble(rs.getString("fee")));
            this.setPatientName(rs.getString("name"));
            this.setContact(rs.getString("contact"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
