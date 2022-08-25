package domain;

import java.sql.Time;
import java.util.Date;

public class Bill {
    private long id;
    private Date date;
    private Time time;
    private String patientName;
    private String patientContact;
    private String doctorName;
    private String doctorDepartment;
    private double doctorFee;
    private double hospitalServiceCharges;
    private double totalAmount;
    private double discount;

    public Bill() {
    }

    public Bill(long id, Date date, Time time, String patientName, String patientContact, String doctorName,
                String doctorDepartment, double doctorFee, double hospitalServiceCharges,
                double totalAmount, double discount) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.patientName = patientName;
        this.patientContact = patientContact;
        this.doctorName = doctorName;
        this.doctorDepartment = doctorDepartment;
        this.doctorFee = doctorFee;
        this.hospitalServiceCharges = hospitalServiceCharges;
        this.totalAmount = totalAmount;
        this.discount = discount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorDepartment() {
        return doctorDepartment;
    }

    public void setDoctorDepartment(String doctorDepartment) {
        this.doctorDepartment = doctorDepartment;
    }

    public double getDoctorFee() {
        return doctorFee;
    }

    public void setDoctorFee(double doctorFee) {
        this.doctorFee = doctorFee;
    }

    public double getHospitalServiceCharges() {
        return hospitalServiceCharges;
    }

    public void setHospitalServiceCharges(double hospitalServiceCharges) {
        this.hospitalServiceCharges = hospitalServiceCharges;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", patientName='" + patientName + '\'' +
                ", patientContact='" + patientContact + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorDepartment='" + doctorDepartment + '\'' +
                ", doctorFee=" + doctorFee +
                ", hospitalServiceCharges=" + hospitalServiceCharges +
                ", totalAmount=" + totalAmount +
                ", discount=" + discount +
                '}';
    }
}
