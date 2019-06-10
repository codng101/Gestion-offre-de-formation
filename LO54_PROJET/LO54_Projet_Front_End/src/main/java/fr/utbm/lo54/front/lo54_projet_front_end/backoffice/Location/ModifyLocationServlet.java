/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.backoffice.Location;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Location;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.LocationDao;
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
 * @author El Popcorn
 */
@WebServlet(name = "ModifyLocationServlet", urlPatterns =
{
    "/ModifierLieu"
})
public class ModifyLocationServlet extends HttpServlet
{
    public static final String VUE = "/WEB-INF/Location/modifyLocationForm.jsp";
    public static final String CHAMP_ID="id";
    public static final String CHAMP_NOMVILLE ="city";
    public static final String IS_OK_SERVLET ="/LieuModifie";
    public static final String IS_KO_SERVLET="/LieuPasModifie";
    
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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"boots.css\">");
            out.println("<title>Modification</title>");            
            out.println("</head>");
            out.println("<body>");
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
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher(VUE);
        rd.forward(request, response);
        //processRequest(request, response);
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
        /* Récupération des champs du formulaire. */
        request.setCharacterEncoding("UTF-8"); // Pour gérer les accents mamène
        String cityName = request.getParameter( CHAMP_NOMVILLE );
        String idString =request.getParameter(CHAMP_ID);
        int id = Integer.parseInt(idString);
        try 
        {
            if(!cityName.trim().equals(""))
            {
               LocationDao ld = new LocationDao();
               Location l =  new Location(cityName);
               l.setId(id);
               
               ld.connect();
               ld.setLocation(l);
               ld.disconnect(); 
               RequestDispatcher rs =  this.getServletContext().getRequestDispatcher(IS_OK_SERVLET);
               rs.forward(request, response);
            }
            else
            {
                this.getServletContext().getRequestDispatcher(IS_KO_SERVLET).forward(request, response);
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
                out.println("<title>Servlet TestServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Erreur lors de l'ajout du lieu</h1>");
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
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
