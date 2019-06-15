/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.front.lo54_projet_front_end.service;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.SessionsDao;
import java.util.List;

/**
 *
 * @author guill
 */
public class SessionService {
    
    SessionsDao sd = new SessionsDao();
    
    public void addSessions(Sessions s)
    {
        sd.connect();
        sd.addSessions(s);
        sd.disconnect();   
    }
    public List<Sessions> getAllSessionss()
    {
        sd.connect();
        List<Sessions> s = sd.getAllSessionss();
        sd.disconnect();   
        return s;   
    }
    
    public Sessions getSessionsById(int id)
    {
        sd.connect();
        Sessions s = sd.getSessionsById(id);
        sd.disconnect();   
        return s;
    }
    public void deleteSessions(int id)
    {
        sd.connect();
        sd.deleteSessions(id);
        sd.disconnect();   
    }
    public void setSessions(Sessions s)
    {   
        sd.connect();
        sd.setSessions(s);
        sd.disconnect();
    }
}
