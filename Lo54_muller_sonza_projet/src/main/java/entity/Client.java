package entity;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.IDDatatypeValidator;

public class Client {
    private int id;
    private String lastname;
    private String firstname;
    private String address;
    private String phone;
    private String email;

    public Client() {
    }

    public Client(int ID, String lastname, String firstname, String address, String phone) {
        this.id = ID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
    }

    public Client(int ID, String lastname, String firstname, String address, String phone, String email) {
        this.id = ID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public int getID() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
