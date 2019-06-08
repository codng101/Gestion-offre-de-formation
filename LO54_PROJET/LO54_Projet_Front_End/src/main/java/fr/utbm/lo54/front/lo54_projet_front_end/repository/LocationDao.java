/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.repository;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Location;
import fr.utbm.lo54.front.lo54_projet_front_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author gmulle01
 */
public class LocationDao {
    private Session session;
    private HibernateUtil util;
    
    public void connect()
    {
        util = new HibernateUtil();
        session =util.getSessionFactory().openSession();
    }
    
    public void disconnect()
    {
        session.close();
    }
    public void addLocation(Location l)
    {
        session.beginTransaction();
        session.save(l);
        session.getTransaction().commit();
    }
    public List<Location> getAllLocations()
    {
        Query query = session.createQuery("from Location");
        List<Location> locs = query.list();
        return locs;
    }
    
    public Location getLocationById(int id)
    {
        Query query = session.createQuery("from Location WHERE loc_id = "+id);
        return (Location)query.uniqueResult();
    }
    public void deleteLocation(int id)
    {
        //session.delete(loc);
        //session.flush();
        Query q = session.createQuery("delete from location where loc_id = "+id);
        q.executeUpdate();
    }
    public void setLocation(Location l)
    {
        session.beginTransaction();
        session.update(l);
        session.getTransaction().commit();
    }
}
