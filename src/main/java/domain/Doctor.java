package domain;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;


@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Doctor {

    private int id;
    private String name;
    private String contact;
    private String specialization;
    private String address;
    private Double fee;

    public Doctor(int id,String name,String contact,String specialization, String address,Double fee){
        this.id=id;
        this.name=name;
        this.contact=contact;
        this.specialization=specialization;
        this.address=address;
        this.fee=fee;
    }
    public void populate(ResultSet rs){
        try {
            this.setId(Integer.parseInt(rs.getString("id")));
            this.setName(rs.getString("d_name"));
            this.setContact(rs.getString("contact"));
            this.setSpecialization(rs.getString("specialization"));
            this.setAddress(rs.getString("address"));
            this.setFee(Double.valueOf(rs.getString("fee")));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}