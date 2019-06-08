/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.repository;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions;
import fr.utbm.lo54.front.lo54_projet_front_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author gmulle01
 */
public class SessionsDao {
    
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
    public void addSessions(Sessions s)
    {
        session.beginTransaction();
        session.save(s);
        session.getTransaction().commit();
    }
    public List<Sessions> getAllSessionss()
    {
        Query query = session.createQuery("from UD_Session");
        List<Sessions> ses = query.list();
        
        return ses;
    }
    
    public Sessions getSessionsById(int id)
    {
        Query query = session.createQuery("from UD_Session WHERE session_id = "+id);
        return (Sessions)query.uniqueResult();
    }
    public void deleteSessions(int id)
    {
        //session.delete(loc);
        //session.flush();
        Query q = session.createQuery("delete from UD_Session where session_id = "+id);
        q.executeUpdate();
    }
    public void setSessions(Sessions s)
    {
        session.beginTransaction();
        session.update(s);
        session.getTransaction().commit();
    }
}
