package domain;

public class Staff {
    private int staff_id;
    private String name;
    private String designation;
    private String address;
    private int salary;
    private String contact;

    public Staff() {
    }

    public Staff(int staff_id, String name, String designation, String address, int salary, String contact) {
        this.staff_id = staff_id;
        this.name = name;
        this.designation = designation;
        this.address = address;
        this.salary = salary;
        this.contact = contact;
    }

    public int getStaff_id() {
        return this.staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String toString() {
        return "Staff{staff_id=" + this.staff_id + ", name='" + this.name + '\'' + ", designation='" + this.designation + '\'' + ", address='" + this.address + '\'' + ", salary=" + this.salary + ", contact='" + this.contact + '\'' + '}';
    }
}