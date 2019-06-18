package fr.utbm.lo54.front.lo54_projet_front_end.entity;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="CLIENT")
public class Client implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;
    private String lastname;
    private String firstname;
    private String address;
    private String phone;
    private String email;
    
    // Marked eager so that we can get all the information related to the session
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "clients") // Case sensitive, référence le set contenu dans l'entité Sessions (le set s'appelle clients)
    private Set<Sessions> sessions; 

    public Set<Sessions> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Sessions> sessions) {
        this.sessions = sessions;
    }

    public Client() {
    }

    public Client(int ID, String lastname, String firstname, String address, String phone) {
        this.client_id = ID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
    }

    public Client(int ID, String lastname, String firstname, String address, String phone, String email) {
        this.client_id = ID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    
    public Client(String lastname, String firstname, String address, String phone, String email) 
    {
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
        this.client_id = ID;
    }

    public int getID() {
        return client_id;
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
    
    @Override
    public boolean equals(Object v)
    {
        boolean retVal = false;
        if(v instanceof Client)
        {
            Client ptr = (Client)v;
            retVal = ptr.client_id==this.client_id;
        }
        return retVal;
    }

    @Override
    public int hashCode() 
    {
        int hash = 5;
        hash = 97 * hash + this.client_id;
        return hash;
    }
}
