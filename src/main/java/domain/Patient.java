package domain;

public class Patient {
    private int id;
    private String patientName;
    private String patientAddress;
    private String patientContact;
    private String patientAge;
    private String patientGender;
    public Patient(){

    }

    public Patient(int id,String patientName, String patientAddress, String patientContact, String patientAge, String patientGender) {
        this.id=id;
        this.patientName = patientName;
        this.patientAddress = patientAddress;
        this.patientContact = patientContact;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientContact() {
        return patientContact;
    }

    public void setPatientContact(String patientContact) {
        this.patientContact = patientContact;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientName='" + patientName + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientContact='" + patientContact + '\'' +
                ", patientAge='" + patientAge + '\'' +
                ", patientGender='" + patientGender + '\'' +
                '}';
    }
}
