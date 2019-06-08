package fr.utbm.lo54.front.lo54_projet_front_end.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author vsonza
 */
@Entity
@Table(name="COURSE")
public class Course implements Serializable
{
    @Id
    private String code;
    private String title;

    public Course() 
    {
    }

    public Course(String code, String title) 
    {
        this.code = code;
        this.title = title;
    }

    public String getCode() 
    {
        return code;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setCode(String code) 
    {
        this.code = code;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }
}
