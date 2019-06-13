/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.backoffice.Client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.ClientDao;
import fr.utbm.lo54.front.lo54_projet_front_end.entity.Client;
import java.util.List;
/**
 *
 * @author Victor
 */
@WebServlet(name = "DisplayClientsServlet", urlPatterns = {"/VoirClients"})
public class DisplayClientsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            ClientDao cd = new ClientDao();
            cd.connect();
            List<Client> clients = cd.getAllClients();
            cd.disconnect();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"boots.css\">");
            out.println("<title>Liste des lieux</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<nav aria-label=\"breadcrumb\">");
                out.println("<ol class=\"breadcrumb\">");
                    out.println("<li class=\"breadcrumb-item\"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>");
                    out.println("<li class=\"breadcrumb-item active\" aria-current=\"page\">Liste des clients</li>");
                out.println("</ol>");
            out.println("</nav>");
            
            out.println("<table class=\"table\">");
                out.println("<thead class=\"thead-light\">");
                    out.println("<tr> ");
                        out.println("<th scope=\"col\" align='center'>Nom</th>");
                        out.println("<th scope=\"col\" >Prénom</th>");
                        out.println("<th scope=\"col\" >Email</th>");
                        out.println("<th scope=\"col\" > </th>");
                        out.println("<th scope=\"col\" > </th>");
                        out.println("<th scope=\"col\" > </th>");
                    out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                    for (Client cli : clients)
                    {
                        out.println("<tr>");
                            out.println("<td>");
                                out.println(cli.getLastname());
                            out.println("</td>");
                            out.println("<td>");
                                out.println(cli.getFirstname());                        
                            out.println("</td>");
                            out.println("<td>");
                                out.println(cli.getEmail());
                            out.println("</td>");
                            out.println("<td>");
                                out.println("<a href='http://localhost:8080/LO54_Projet_Front_End/ModifierClient?id="+cli.getID()+"'>Modifier</a>");
                            out.println("</td>");
                            out.println("<td>");
                                out.println("<a href='http://localhost:8080/LO54_Projet_Front_End/SupprimerClient?id="+cli.getID()+"'>Supprimer</a>");
                            out.println("</td>");
                            out.println("<td>");
                                out.println("<a href='http://localhost:8080/LO54_Projet_Front_End/VoirSessionsClient?id="+cli.getID()+"'>Voir les sessions</a>");
                            out.println("</td>");
                        out.println("</tr>");
                    }
                out.println("</tbody>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
