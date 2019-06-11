/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.backoffice.Courses;

import fr.utbm.lo54.front.lo54_projet_front_end.entity.Course;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.CourseDao;
import fr.utbm.lo54.front.lo54_projet_front_end.repository.LocationDao;
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
 * @author El Popcorn
 */
@WebServlet(name = "DisplayCoursesServlet", urlPatterns =
{
    "/MontrerCours"
})
public class DisplayCoursesServlet extends HttpServlet
{

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
            CourseDao cDao = new CourseDao();
            cDao.connect();
            List<Course> courses = cDao.getAllCourses();
            cDao.disconnect();
            /* TODO output your page here. You may use following sample code. */
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
                    out.println("<li class=\"breadcrumb-item active\" aria-current=\"page\">Liste des cours</li>");
                out.println("</ol>");
            out.println("</nav>");
            
            out.println("<table class=\"table\">");
                out.println("<thead class=\"thead-light\">");
                    out.println("<tr> ");
                        out.println("<th scope=\"col\" align='center'>Code</th>");
                        out.println("<th scope=\"col\" >Titre</th>");
                        out.println("<th scope=\"col\" > </th>");
                        out.println("<th scope=\"col\" > </th>");
                    out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                    for (Course cours : courses)
                    {
                        out.println("<tr>");
                            out.println("<td align='center'>");
                                out.println(cours.getCode());
                            out.println("</td>");
                            out.println("<td>");
                                out.println(cours.getTitle());                        
                            out.println("</td>");
                            out.println("<td>");
                                out.println("<a href='http://localhost:8080/LO54_Projet_Front_End/ModifierCours?code="+cours.getCode()+"&titre="+cours.getTitle()+"'>Modifier</a>");
                                out.println("<a href='http://localhost:8080/LO54_Projet_Front_End/SupprimerCours?code="+cours.getCode()+"&titre="+cours.getTitle()+"'>Supprimer</a>");
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
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
