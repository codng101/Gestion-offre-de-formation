/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.service;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Course;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.CourseDao;
import java.util.List;

/**
 *
 * @author guill
 */
public class CoursesServices {
    CourseDao cd = new CourseDao();
    
    public List<Course> getAllCourses(){
            cd.connect();
            List<Course> clients = cd.getAllCourses();
            cd.disconnect();
            return clients;
    }
    
    public void deleteCourse(Course c){
        cd.connect();
        cd.deleteCourse(c);
        cd.disconnect();
    }
    
    public void addCourse(Course c){
        cd.connect();
        cd.addCourse(c);
        cd.disconnect();
    }
    
    public Course getCourseById(String idS){
            CourseDao cd = new CourseDao();
            cd.connect();
            Course c = cd.getCourseById(idS);
            cd.disconnect();
            return c;
    }
    
    public void setCourse(Course c){
        cd.connect();
        cd.setCourse(c);
        cd.disconnect(); 
    }
    
    public Boolean  existCourseCode(String code){
        cd.connect();
        Boolean b=cd.existCourseCode(code);
        cd.disconnect(); 
        return b;
        
    }
}
