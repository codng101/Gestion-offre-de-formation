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
        Query query = session.createQuery("from Course WHERE code = "+id);
        return (Course)query.uniqueResult();
    }
    public void deleteCourse(String id)
    {
        //session.delete(loc);
        //session.flush();
        Query q = session.createQuery("delete from Course where code = "+id);
        q.executeUpdate();
    }
    public void setCourse(Course c)
    {
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
    }
}
