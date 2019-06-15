/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.fronty.lo54_projet_front_end.backoffice.participe;

import fr.utbm.front.lo54_projet_front_end.service.ClientService;
import fr.utbm.front.lo54_projet_front_end.service.SessionService;
import fr.utbm.lo54.front.lo54_projet_front_end.entity.Client;
import fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
@WebServlet(name = "AddParticipeServlet", urlPatterns = {"/AjouterParticipant"})
public class AddParticipeServlet extends HttpServlet {

    public static final String VUE = "/WEB-INF/Participe/addParticipationForm.jsp";
    public static final String CHAMP_CLIENT = "clientList";
    public static final String CHAMP_SESSION = "sessionList";
    public static final String IS_OK_SERVLET = "/ParticipantAjoute";
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddParticipeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddParticipeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
        SessionService sS= new SessionService();
        ClientService cs =new ClientService();
        
        List<Sessions> sessions = sS.getAllSessionss();
        
        List<Client> clients = cs.getAllClients();
        
        
        // on met tout ça dans la requête
        request.setAttribute("clients",clients);
        request.setAttribute("sessions",sessions);
        
        // Et on relaie à la page JSP
        request.getRequestDispatcher(VUE).forward(request,response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        request.setCharacterEncoding("UTF-8"); // Pour gérer les accents mamène
        String sessionId = request.getParameter(CHAMP_SESSION);
        String clientId = request.getParameter(CHAMP_CLIENT);
        
        try 
        {
            
            SessionService sS= new SessionService();
            ClientService cs =new ClientService();
            
            int sesID = Integer.parseInt(sessionId);
            int cliID = Integer.parseInt(clientId);
            
            
            Client c = cs.getClientById(cliID);
            
            Sessions s = sS.getSessionsById(sesID);
            
            if(!s.getSetClients().contains(c))
            {
                s.getSetClients().add(c);
                sS.setSessions(s);
            }
                        
            RequestDispatcher rs =  this.getServletContext().getRequestDispatcher(IS_OK_SERVLET);
            rs.forward(request, response);
            
        } 
        catch (Exception e) 
        {  
            try (PrintWriter out = response.getWriter()) 
            { 
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"boots.css\">");
                out.println("<title>Erreur ajout de la session</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Erreur lors de l'ajout de la session</h1>");
                out.println("<div> Erreur : ");
                out.println(e.getMessage()+"</div>");
                out.println("<div><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'> Retour à la page d'acceuil </a></div>");
                out.println("</body>");
                out.println("</html>");
            }
        }
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
