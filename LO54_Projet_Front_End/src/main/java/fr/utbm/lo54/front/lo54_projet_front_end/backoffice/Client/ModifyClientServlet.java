/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.front.lo54_projet_front_end.backoffice.Client;

import fr.utbm.lo54.front.lo54_projet_front_end.service.ClientService;
import fr.utbm.lo54.front.lo54_projet_front_end.entity.Client;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor
 */
@WebServlet(name = "ModifyClientServlet", urlPatterns = {"/ModifierClient"})
public class ModifyClientServlet extends HttpServlet {

    public static final String VUE = "/WEB-INF/Client/modifyClientForm.jsp";
    public static final String IS_OK_SERVLET = "/ClientModifie";
    public static final String CHAMP_NFAM = "lName";
    public static final String CHAMP_PREN = "fName";
    public static final String CHAMP_ADR="adress";
    public static final String CHAMP_TEL ="telephone";
    public static final String CHAMP_MEL ="mail";
    public static final String CHAMP_ID ="id";
    
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
            out.println("<title>Servlet ModifyClientServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifyClientServlet at " + request.getContextPath() + "</h1>");
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
        int idS = -1;
        String idString = request.getParameter("id");
        idS = Integer.parseInt(idString);
        
        ClientService cs= new ClientService();
        Client c = cs.getClientById(idS);
        
        
        request.setAttribute("lName", c.getLastname());
        request.setAttribute("fName", c.getFirstname());
        request.setAttribute("adress", c.getAddress());
        request.setAttribute("telephone", c.getPhone());
        request.setAttribute("mail", c.getEmail());
        request.setAttribute("id", idString);
        
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
        try
        {
            String nFam = request.getParameter(CHAMP_NFAM);
            String prenom = request.getParameter(CHAMP_PREN);
            String adress = request.getParameter(CHAMP_ADR);
            String numTel = request.getParameter(CHAMP_TEL);
            String mail = request.getParameter(CHAMP_MEL);
            String stringId = request.getParameter(CHAMP_ID);
            int id = Integer.parseInt(stringId);
            
            if(!nFam.trim().equals("") && !prenom.trim().equals("") && !adress.trim().equals("") && !numTel.trim().equals("") && !mail.trim().equals(""))
            {
                
                ClientService cs= new ClientService();
                Client c = cs.getClientById(id);
                
                c.setAddress(adress);
                c.setEmail(mail);
                c.setFirstname(prenom);
                c.setLastname(nFam);
                c.setPhone(numTel);
                
                cs.setClient(c);
                
                request.getRequestDispatcher(IS_OK_SERVLET).forward(request,response);
            }
            else
            {
                try (PrintWriter out = response.getWriter()) 
                {
                    out.println("<meta http-equiv='refresh' content='2;URL=http://localhost:8080/LO54_Projet_Front_End/AjouterClient'>");//redirects after 2 seconds
                    out.println("<h1 class=\"text-danger\">Au moins un des champs n'était pas bien rempli !</h1>");
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
                out.println("<title>Erreur ajout client</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Erreur lors de l'ajout du client</h1>");
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
