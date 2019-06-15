/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.repository;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Course;
import fr.utbm.lo54.front.lo54_projet_front_end.tools.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author gmulle01
 */
public class CourseDao {
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
    public void addCourse(Course c)
    {
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
    }
    public List<Course> getAllCourses()
    {
        Query query = session.createQuery("from Course");
        List<Course> courses = query.list();
        
        return courses;
    }
    
    public Course getCourseById(String id)
    {
        Query query = session.createQuery("from Course WHERE code =:id ");
        query.setParameter("id",id);
        Course c = (Course)query.uniqueResult();
        return c;
    }
    public void deleteCourse(Course c)
    {
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
    }
    public void setCourse(Course c)
    {
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
    }
    
    /*
    * Vrai si l'id existe déjà faux sinon 
    */
    public boolean existCourseCode(String id)
    {
        Course c = getCourseById(id);
        return c != null;
    }
}
