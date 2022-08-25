package domain;

import java.sql.Time;
import java.util.Date;

public class Appointment {
    private int appointment_id;
    private int patient_id;
    private Date date;
    private Time time;
    private double ServiceCharges;
    private int doctor_id;

    public Appointment() {
    }

    public Appointment(int appointment_id, int patient_id, Date date, Time time, double serviceCharges, int doctor_id) {
        this.appointment_id = appointment_id;
        this.patient_id = patient_id;
        this.date = date;
        this.time = time;
        ServiceCharges = serviceCharges;
        this.doctor_id = doctor_id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public double getServiceCharges() {
        return ServiceCharges;
    }

    public void setServiceCharges(double serviceCharges) {
        ServiceCharges = serviceCharges;
    }

    public int getAppointment_id() {
        return this.appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getPatient_id() {
        return this.patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDoctor_id() {
        return this.doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointment_id=" + appointment_id +
                ", patient_id=" + patient_id +
                ", date=" + date +
                ", time=" + time +
                ", ServiceCharges=" + ServiceCharges +
                ", doctor_id=" + doctor_id +
                '}';
    }
}
