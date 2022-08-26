package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@ToString

public class Appointment {
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
}
