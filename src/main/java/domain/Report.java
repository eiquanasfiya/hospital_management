package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Report {
    private String date;
    private String time;
    private String doctorName;
    private String doctorContact;
    private Double doctorCharges;
    private String patientName;
    private String patientContact;
    private Double serviceCharges;
    private Double totalIncome;


    public Report() {
    }

    public Report(String date, String time, String doctorName, String doctorContact, Double doctorCharges,
                  String patientName, String patientContact, Double serviceCharges) {
        this.date = date;
        this.time = time;
        this.doctorName = doctorName;
        this.doctorContact = doctorContact;
        this.doctorCharges = doctorCharges;
        this.patientName = patientName;
        this.patientContact = patientContact;
        this.serviceCharges = serviceCharges;
    }

    public Double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorContact() {
        return doctorContact;
    }

    public void setDoctorContact(String doctorContact) {
        this.doctorContact = doctorContact;
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

    public Double getDoctorCharges() {
        return doctorCharges;
    }

    public void setDoctorCharges(Double doctorCharges) {
        this.doctorCharges = doctorCharges;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public Double getServiceCharges() {
        return serviceCharges;
    }

    public void setServiceCharges(Double serviceCharges) {
        this.serviceCharges = serviceCharges;
    }

    public void populate(ResultSet rs) {
        try {
            this.setDoctorName(rs.getString("d_name"));
            this.setDoctorContact(rs.getString("contact"));
            this.setPatientName(rs.getString("name"));
            this.setPatientContact(rs.getString("contact"));
            this.setServiceCharges(Double.valueOf(rs.getDouble("serviceCharges")));
            this.setDoctorCharges(Double.valueOf(rs.getDouble("fee")));
            this.setDate(rs.getString("date"));
            this.setTime(rs.getString("time"));
            this.setTotalIncome(Double.valueOf(rs.getDouble("serviceCharges"))+Double.valueOf(rs.getDouble("fee")));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Report{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorContact='" + doctorContact + '\'' +
                ", doctorCharges=" + doctorCharges +
                ", patientName='" + patientName + '\'' +
                ", patientContact='" + patientContact + '\'' +
                ", serviceCharges=" + serviceCharges +
                ", totalIncome=" + totalIncome +
                '}';
    }
}
