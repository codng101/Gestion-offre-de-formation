/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.backoffice.session;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Course;
import fr.utbm.lo54.front.lo54_projet_front_end.entity.Location;
import fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.CourseDao;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.LocationDao;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.SessionsDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "AddSessionServlet", urlPatterns = {"/AjouterSession"})
public class AddSessionServlet extends HttpServlet {

    public static final String VUE = "/WEB-INF/Session/addSessionForm.jsp";
    public static final String CHAMP_COURS = "courseList";
    public static final String CHAMP_LIEU = "locationList";
    public static final String CHAMP_HDEB = "heureDeb";
    public static final String CHAMP_HFIN = "heureFin";
    public static final String CHAMP_NBMAX = "nbMax";
    
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
            out.println("<title>Servlet AddSessionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSessionServlet at " + request.getContextPath() + "</h1>");
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
        // on va récupérer dans un premier temps les cours qui existent
        CourseDao cd = new CourseDao();
        cd.connect();
        List<Course> courses = cd.getAllCourses();
        cd.disconnect();
        
        // ensuite les lieux
        LocationDao ld = new LocationDao();
        ld.connect();
        List<Location> locations = ld.getAllLocations();
        ld.disconnect();
        
        // on met tout ça dans la requête
        request.setAttribute("courses",courses);
        request.setAttribute("locations", locations);
        
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
        String courseId = request.getParameter(CHAMP_COURS);
        String locationId = request.getParameter(CHAMP_LIEU);
        String heureDeb = request.getParameter(CHAMP_HDEB);
        String heureFin = request.getParameter(CHAMP_HFIN);
        String nbMax = request.getParameter(CHAMP_NBMAX);
        
        try 
        {
            if(!courseId.trim().equals("") && !locationId.trim().equals("") && !heureDeb.trim().equals("") && !heureFin.trim().equals("")&& !nbMax.trim().equals(""))
            {
                CourseDao cd = new CourseDao();
                cd.connect();
                Course c = cd.getCourseById(courseId);
                cd.disconnect();
                
                LocationDao ld = new LocationDao();
                ld.connect();
                int lId = Integer.parseInt(locationId);
                Location l = ld.getLocationById(lId);
                ld.disconnect();
                
                DateFormat formatter = new SimpleDateFormat("HH:mm");
                
                Time tDeb = new Time(formatter.parse(heureDeb).getTime());
                Date dDeb = new Date();
                dDeb.setTime(tDeb.getTime());
                
                
                Time tFin = new Time(formatter.parse(heureFin).getTime());
                Date dFin = new Date();
                dFin.setTime(tFin.getTime());
                
                int nMax = Integer.parseInt(nbMax);
                
                // On ajoute la session
                SessionsDao sd = new SessionsDao();
                sd.connect();
                Sessions s = new Sessions(dDeb,dFin,nMax);
                s.setCrs(c);
                s.setLoc(l);
                sd.addSessions(s);
                sd.disconnect();
                
                
                
                //RequestDispatcher rs =  this.getServletContext().getRequestDispatcher(IS_OK_SERVLET);
                //rs.forward(request, response);
                
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
                out.println("<title>Servlet TestServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Erreur lors de l'ajout du cours</h1>");
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
