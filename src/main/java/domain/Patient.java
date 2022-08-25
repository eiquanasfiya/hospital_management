package domain;

public class Patient {
    private int patient_id;
    private String name;
    private int age;
    private String address;
    private String contact;
    private String Gender;

    public Patient() {
    }

    public Patient(int patient_id, String name, int age, String address, String contact, String gender) {
        this.patient_id = patient_id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.contact = contact;
        this.Gender = gender;
    }

    public Patient(String name, int age, String address, String contact, String gender) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.contact = contact;
        this.Gender = gender;
    }

    public int getPatient_id() {
        return this.patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return this.Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + patient_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
