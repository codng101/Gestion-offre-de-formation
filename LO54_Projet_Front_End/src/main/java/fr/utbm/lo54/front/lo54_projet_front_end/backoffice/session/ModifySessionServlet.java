/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.backoffice.session;

import fr.utbm.front.lo54_projet_front_end.service.SessionService;
import fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
@WebServlet(name = "ModifySessionServlet", urlPatterns = {"/ModifierSession"})
public class ModifySessionServlet extends HttpServlet
{

    public static final String VUE = "/WEB-INF/Session/modifySessionForm.jsp";
    public static final String CHAMP_ID = "idSession";
    public static final String CHAMP_DDEB = "dateDeb";
    public static final String CHAMP_DFIN = "dateFin";
    public static final String CHAMP_HDEB = "heureDeb";
    public static final String CHAMP_HFIN = "heureFin";
    public static final String CHAMP_NBMAX = "nbMax";
    public static final String IS_OK_SERVLET = "/SessionModifiee";
            
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
            out.println("<title>Servlet ModifySessionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifySessionServlet at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String sessId = request.getParameter("id");
        SessionService sS= new SessionService();
        Sessions s = sS.getSessionsById(Integer.parseInt(sessId));
        
        request.setAttribute("course", s.getCrs());
        request.setAttribute("location",s.getLoc());
        request.setAttribute("sessionId",s.getId());
        request.setAttribute("sessionStart",(s.getStartDate()));
        request.setAttribute("sessionStop",(s.getEndDate()));
        request.setAttribute("sessionSize",s.getMax());
        
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        request.setCharacterEncoding("UTF-8"); // Pour gérer les accents mamène
        String sessId = request.getParameter(CHAMP_ID);
        int id = Integer.parseInt(sessId);
        String jrDeb = request.getParameter(CHAMP_DDEB);
        String jrFin = request.getParameter(CHAMP_DFIN);
        String heureDeb = request.getParameter(CHAMP_HDEB);
        String heureFin = request.getParameter(CHAMP_HFIN);
        String nbMax = request.getParameter(CHAMP_NBMAX);
        
        try 
        {
            if(!heureDeb.trim().equals("") && !heureFin.trim().equals("")&& !nbMax.trim().equals(""))
            {         
                
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd, HH:mm",Locale.FRANCE);
                String fullDeb = jrDeb+", "+heureDeb;
                String fullFin = jrFin+", "+heureFin;
                
                Date dDeb  = formatter.parse(fullDeb);
                
                Date dFin = formatter.parse(fullFin);
                
                if(dFin.before(dDeb))
                {
                    Date temp = dDeb;
                    dDeb = dFin;
                    dFin = temp;
                }
                
                int nMax = Integer.parseInt(nbMax);
                
                // On ajoute la session
                SessionService sS= new SessionService();
                Sessions s = sS.getSessionsById(id);
                s.setStartDate(dDeb);
                s.setEndDate(dFin);
                s.setMax(nMax);
                sS.setSessions(s);
                
                RequestDispatcher rs =  this.getServletContext().getRequestDispatcher(IS_OK_SERVLET);
                rs.forward(request, response);
                
            }
            else
            {
                    try (PrintWriter out = response.getWriter()) 
                    {
                        out.println("<meta http-equiv='refresh' content='2;URL=http://localhost:8080/LO54_Projet_Front_End/AjouterCours'>");//redirects after 2 seconds
                        out.println("<h1 class=\"text-danger\">Code déjà utilisé pour un autre cours !</h1>");
                    } 
            }
            
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
