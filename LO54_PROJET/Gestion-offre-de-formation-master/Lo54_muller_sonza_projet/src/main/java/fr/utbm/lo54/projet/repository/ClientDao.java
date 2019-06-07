/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.repository;

import fr.utbm.lo54.projet.entity.Client;
import fr.utbm.lo54.projet.tools.HibernateUtil;
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
}   
