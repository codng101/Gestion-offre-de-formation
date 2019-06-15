/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.front.lo54_projet_front_end.service;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Client;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.ClientDao;
import java.util.List;

/**
 *
 * @author guill
 */
public class ClientService {
    
    
    ClientDao cd = new ClientDao();
    
    public List<Client> getAllClients(){
            cd.connect();
            List<Client> clients = cd.getAllClients();
            cd.disconnect();
            return clients;
    }
    
    public void deleteClient(int id){
        cd.connect();
        cd.deleteClient(id);
        cd.disconnect();
    }
    
    public void addClient(Client c){
        cd.connect();
        cd.addClient(c);
        cd.disconnect();
    }
    
    public Client getClientById(int idS){
            ClientDao cd = new ClientDao();
            cd.connect();
            Client c = cd.getClientById(idS);
            cd.disconnect();
            return c;
    }
    
    public void setClient(Client c){
        cd.connect();
        cd.setClient(c);
        cd.disconnect(); 
    }
}
