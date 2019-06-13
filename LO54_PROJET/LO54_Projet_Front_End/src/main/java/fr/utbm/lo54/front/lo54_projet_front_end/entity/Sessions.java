package fr.utbm.lo54.front.lo54_projet_front_end.entity;

import java.util.Date;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="UD_SESSION")
public class Sessions implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int session_id;
    private Date startDate;
    private Date endDate;
    private int maximum;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="loc_id")
    private Location loc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="code")
    private Course crs;

    @ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JoinTable(name="PARTICIPE", 
            joinColumns=
                {
                    @JoinColumn(name = "session_id", nullable = false, updatable = false)
                },
            inverseJoinColumns = 
                {
                    @JoinColumn(name = "client_id",nullable = false,updatable = false)
                }
    )
    private Set<Client> clients;

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public Course getCrs() {
        return crs;
    }

    public void setCrs(Course crs) {
        this.crs = crs;
    }

    public Set<Client> getSetClients() {
        return clients;
    }

    public void setSetClients(Set<Client> setClients) {
        this.clients = setClients;
    }
    
    public Sessions() {
    }

    public Sessions(Date startDate, Date endDate, int max) 
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.maximum = max;
    }
    
    public Sessions(int id, Date startDate, Date endDate, int max) {
        this.session_id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maximum = max;
    }
    
    public Sessions(Date startDate, Date endDate, int max, Course c, Location l) 
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.maximum = max;
        this.crs=c;
        this.loc=l;
    }
    
    public int getId() {
        return session_id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getMax() {
        return maximum;
    }

    public void setId(int id) {
        this.session_id = id;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setMax(int max) {
        this.maximum = max;
    }
    @Override
    public boolean equals(Object v)
    {
        boolean retVal = false;
        if(v instanceof Sessions)
        {
            Sessions ptr = (Sessions)v;
            retVal = ptr.session_id==this.session_id;
        }
        return retVal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.session_id;
        return hash;
    }
}
