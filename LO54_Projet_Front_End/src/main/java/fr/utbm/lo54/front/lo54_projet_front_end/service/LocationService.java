/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.service;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Location;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.LocationDao;
import java.util.List;

/**
 *
 * @author guill
 */
public class LocationService {
    
    LocationDao ld = new LocationDao();
    
    public void addLocation(Location l)
    {
       ld.connect();
       ld.addLocation(l); 
       ld.disconnect();
    }
    public List<Location> getAllLocations()
    {
       ld.connect();
       List<Location> locations = ld.getAllLocations();
       ld.disconnect(); 
       return locations;
    }
    
    public Location getLocationById(int id)
    {
       ld.connect();
       Location location = ld.getLocationById(id); 
       ld.disconnect(); 
       return location;
    }
    public void deleteLocation(Location l)
    {
        ld.connect();
        ld.deleteLocation(l);
        ld.disconnect(); 
    }
    public void setLocation(Location l)
    {
        ld.connect();
        ld.setLocation(l);
        ld.disconnect();    
    }
}
