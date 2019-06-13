/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.backoffice.session;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.SessionsDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
@WebServlet(name = "DisplaySessionsServlet", urlPatterns = {"/VoirSessions"})
public class DisplaySessionsServlet extends HttpServlet {

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
        SessionsDao sd = new SessionsDao();
        sd.connect();
        List<Sessions> sessions = sd.getAllSessionss();
        sd.disconnect();
        try (PrintWriter out = response.getWriter()) 
        {
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
                    out.println("<li class=\"breadcrumb-item active\" aria-current=\"page\">Liste des sessions</li>");
                out.println("</ol>");
            out.println("</nav>");
            
            out.println("<table class=\"table\">");
                out.println("<thead class=\"thead-light\">");
                    out.println("<tr> ");
                        out.println("<th scope=\"col\" align='center'>Id</th>");
                        out.println("<th scope=\"col\" >Heure de début</th>");
                        out.println("<th scope=\"col\" >Heure de fin</th>");
                        out.println("<th scope=\"col\" >Matière</th>");
                        out.println("<th scope=\"col\" >Lieu</th>");
                        out.println("<th scope=\"col\" >Places disponibles</th>");
                        out.println("<th scope=\"col\" > </th>");
                        out.println("<th scope=\"col\" > </th>");
                    out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                    for (Sessions ses : sessions)
                    {
                        out.println("<tr>");
                            out.println("<td align='center'>");
                                out.println(ses.getId());
                            out.println("</td>");
                            out.println("<td>");
                                    out.println(ses.getStartDate());     
                            out.println("</td>");
                            out.println("<td>");
                                    out.println(ses.getEndDate());
                            out.println("</td>");
                            out.println("<td>");
                                out.println(ses.getCrs().getCode());                        
                            out.println("</td>");
                            out.println("<td>");
                                out.println(ses.getLoc().getCity());                        
                            out.println("</td>");
                            out.println("<td>");
                            int dispo = ses.getMax() - ses.getSetClients().size();
                                if(dispo != 0){ out.println(dispo);}
                                else {out.println("Aucune");}
                            out.println("</td>");
                            out.println("<td>");
                                out.println("<a href='http://localhost:8080/LO54_Projet_Front_End/ModifierSession?id="+ses.getId()+"'>Modifier</a>");
                            out.println("</td>");
                            out.println("<td>");
                                out.println("<a href='http://localhost:8080/LO54_Projet_Front_End/SupprimerSession?id="+ses.getId()+"'>Supprimer</a>");
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
