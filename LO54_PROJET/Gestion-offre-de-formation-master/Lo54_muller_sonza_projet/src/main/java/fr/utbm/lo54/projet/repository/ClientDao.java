/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.repository;

import fr.utbm.lo54.projet.tools.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author gmulle01
 */
public class ClientDao {
    public void createClient(String firstname, String lastname, String address, String phone, String email) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	        //création d'un client
                String hql = "INSERT INTO Client(:firstname, :lastname, :address, :phone, :email)";
                Query query = session.createQuery(hql);
                query.setParameter("firstname",firstname);
                query.setParameter("lastname",lastname);
                query.setParameter("address",address);
                query.setParameter("phone",phone);
                query.setParameter("email",email);
                int result = query.executeUpdate();
                System.out.println("Rows affected: " + result);
	        session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}
		finally {
	        if(session != null) {
	            try { session.close();
                    
                    }
                    catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}
                }
            }
    }            
}   
