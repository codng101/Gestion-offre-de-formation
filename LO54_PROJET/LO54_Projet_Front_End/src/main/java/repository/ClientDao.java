/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.repository;

import fr.utbm.lo54.projet.entity.Client;
import fr.utbm.lo54.projet.tools.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author gmulle01
 */
public class ClientDao {
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
    public void addClient(Client c)
    {
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
    }  
    public List<Client> getAllClients()
    {
        Query query = session.createQuery("from Client");
        List<Client> clients = query.list();
        
        return clients;
    }
    
    public Client getClientById(int id)
    {
        Query query = session.createQuery("from Client WHERE client_id = "+id);
        return (Client)query.uniqueResult();
    }
    public void deleteClient(int id)
    {
        //session.delete(loc);
        //session.flush();
        Query q = session.createQuery("delete from client where client_id = "+id);
        q.executeUpdate();
    }
    public void setClient(Client c)
    {
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
    } 
}   
