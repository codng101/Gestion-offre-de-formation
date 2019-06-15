/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.backoffice.participe;

import fr.utbm.lo54.front.lo54_projet_front_end.service.ClientService;
import fr.utbm.lo54.front.lo54_projet_front_end.service.SessionService;
import fr.utbm.lo54.front.lo54_projet_front_end.entity.Client;
import fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DesinscrireClientSessionServlet", urlPatterns = {"/DesinscrireClient"})
public class DesinscrireClientSessionServlet extends HttpServlet {

    public static final String VUE = "/WEB-INF/Participe/deleteParticipant.jsp";
    public static final String CHAMP_IDC = "idC";
    public static final String CHAMP_IDS = "idSes";
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
            out.println("<title>Servlet DesinscrireClientSessionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DesinscrireClientSessionServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        SessionService sS= new SessionService();
        ClientService cs =new ClientService();
        
        String clientStrId = request.getParameter("idCli");
        int clientId = Integer.parseInt(clientStrId);
        
        String sessionStrId = request.getParameter("idSes");
        int sessionId = Integer.parseInt(sessionStrId);
        
        request.setAttribute("session", sS.getSessionsById(sessionId));
        request.setAttribute("client",cs.getClientById(clientId));
        
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        try
        {
            String sessionIdS = request.getParameter(CHAMP_IDS);
            int sessionId = Integer.parseInt(sessionIdS);
            String clientIdS = request.getParameter(CHAMP_IDC);
            int clientId = Integer.parseInt(clientIdS);

            SessionService sS= new SessionService();
            ClientService cs =new ClientService();
            
            Client c = cs.getClientById(clientId);
            
            Sessions s = sS.getSessionsById(sessionId);
            s.getSetClients().remove(c);
            sS.setSessions(s);
            
            RequestDispatcher rs =  this.getServletContext().getRequestDispatcher("/VoirClients");
            rs.forward(request, response);
        }
        catch(IOException | NumberFormatException | ServletException e)
        {
            try (PrintWriter out = response.getWriter()) 
            { 
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"boots.css\">");
                out.println("<title>Erreur suppression</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Erreur lors de la suppression du client</h1>");
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
