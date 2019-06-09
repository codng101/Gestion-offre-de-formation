package fr.utbm.lo54.projet.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="LOCATION")
public class Location implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loc_id;
    private String city;


    public Location() {
    }

    public Location(String city) 
    {
        this.city = city;
    }
    
    public Location(int id, String city) 
    {
        this.loc_id = id;
        this.city = city;
    }

    public int getId() {
        return loc_id;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.loc_id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
