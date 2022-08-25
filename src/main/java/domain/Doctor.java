package domain;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
    private Integer id;
    private String name;
    private String address;
    private String specialization;
    private String contact;
    private Double charges;




    public Doctor() {
    }

    public Doctor(Integer doctor_id, String name, String address,String experience, String contact,Double charges) {
        this.id = doctor_id;
        this.name = name;
        this.address = address;
        this.specialization = experience;
        this.contact = contact;
        this.charges = charges;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void populate(ResultSet rs){
        try {
            this.setId(Integer.parseInt(rs.getString("id")));
            this.setName(rs.getString("name"));
            this.setContact(rs.getString("contact"));
            this.setSpecialization(rs.getString("specialization"));
            this.setAddress(rs.getString("address"));
            this.setCharges(Double.valueOf(rs.getString("fee")));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", experience='" + specialization + '\'' +
                ", contact='" + contact + '\'' +
                ", charges=" + charges +
                '}';
    }
}