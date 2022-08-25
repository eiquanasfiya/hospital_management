package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@ToString

public class Bill {
    private String invoiceNumber;
    private String appointmentNumber;
    private String date;
    private String time;
    private String doctorName;
    private String doctorsSpecialization;
    private Double doctorFee;
    private Double serviceCharges;
    private String patientName;
    private String patientContact;
    private String patientAddress;
    private String patientAge;
    private String patientGender;
    public Bill(String invoiceNumber,String appointmentNumber,String date,String time,String doctorName,
                String doctorsSpecialization, Double doctorFee,Double serviceCharges,String patientName,String patientContact,
                String patientAddress,String patientAge,String patientGender){
       this.invoiceNumber=invoiceNumber;
       this.appointmentNumber=appointmentNumber;
       this.date=date;
       this.time=time;
       this.doctorName=doctorName;
       this.doctorsSpecialization=doctorsSpecialization;
       this.doctorFee=doctorFee;
       this.serviceCharges=serviceCharges;
       this.patientName=patientName;
       this.patientContact=patientContact;
       this.patientAddress=patientAddress;
       this.patientAge=patientAge;
       this.patientGender=patientGender;

    }
}

