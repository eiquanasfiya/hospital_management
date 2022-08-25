package domain;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Builder
@Getter
@Setter
@ToString
public class Doctor {

    private String name;
    private String contact;
    private String specialization;
    private String address;
    private Double fee;

    public Doctor(String name,String contact,String specialization, String address,Double fee){
        this.name=name;
        this.contact=contact;
        this.specialization=specialization;
        this.address=address;
        this.fee=fee;
    }


}