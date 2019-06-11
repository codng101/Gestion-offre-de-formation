/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.main;

import fr.utbm.lo54.projet.entity.Course;
import fr.utbm.lo54.projet.entity.Sessions;
import fr.utbm.lo54.projet.repository.CourseDao;
import fr.utbm.lo54.projet.repository.LocationDao;
import fr.utbm.lo54.projet.repository.SessionsDao;
/**
 *
 * @author vsonza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        AnnotationConfiguration conf = new AnnotationConfiguration();
//        conf.addAnnotatedClass(Client.class);
//        conf.addAnnotatedClass(Location.class);
//        conf.addAnnotatedClass(Sessions.class);
//        conf.addAnnotatedClass(Course.class);
//        //conf.addClass(Client.class);
//        //conf.addClass(Location.class);
//        //conf.addClass(Sessions.class);
//        //conf.addClass(Course.class);
//        conf.configure("hibernate.cfg.xml");
        //new SchemaExport(conf).create(true,true);
        Course c=new Course("LO51","LO51");
        CourseDao CDao=new CourseDao();
        LocationDao ldao=new LocationDao();
        SessionsDao sdao=new SessionsDao();
        Sessions s=new Sessions();
        sdao.connect();
        sdao.addSessions(s);
        sdao.disconnect();
        //ldao.connect();
        //Location l=new Location("belfort");
        //ldao.addLocation(l);
        //ldao.disconnect();
        
        CDao.connect();
        //CDao.addCourse(c);
        CDao.getAllCourses();
        System.out.print(CDao.getCourseById("LO54"));
        CDao.disconnect();
    }
    
}
