<%-- 
    Document   : seeSessions
    Created on : 18 juin 2019, 21:27:31
    Author     : Victor
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <%
        List<Sessions> sessions = (List<Sessions>) request.getAttribute("sessions");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel=\"stylesheet\" type=\"text/css\" href=\"boots.css\">
        <title>Liste des sessions</title>   
        <script>
            function filter() 
            {
                var input, filter, table, tr, td, i, txtValue;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("myTable");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++)
                {
                    td = tr[i].getElementsByTagName("td")[1];
                    if (td) 
                    {
                        txtValue = td.textContent || td.innerText; 
                        if (txtValue.toUpperCase().indexOf(filter) > -1)
                        {
                            tr[i].style.display = "";
                        } 
                        else 
                        {
                            tr[i].style.display = "none"; 
                        }
                    } 
                }
            }
        </script>
    </head>
    <body>
        <nav aria-label=\"breadcrumb\">
            <ol class=\"breadcrumb\">
                <li class=\"breadcrumb-item\"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
                <li class=\"breadcrumb-item active\" aria-current=\"page\">Liste des sessions</li>
            </ol>
        </nav>
        <input type='text' id='myInput' style='width:50%;margin-bottom:5px;margin-left:5px' onkeyup='filter()' placeholder='Trier par titre ...'> 
        <table id ='myTable' class=\"table\"> 
            <thead class=\"thead-light\"> 
                <tr>  
                    <th scope=\"col\">Code</th> 
                    <th scope=\"col\" >Titre</th> 
                    <th scope=\"col\" > </th> 
                    <th scope=\"col\" > </th> 
                </tr> 
            </thead> 
            <tbody> 
                    <% 
                        for (Sessions ses : sessions)
                        {
                            out.print("<tr>");
                                out.print("<td align='center'>");
                                   out.println(ses.getCrs());
                                out.print("</td>");
                                out.print("<td>");
                                   out.println(ses.getStartDate());                        
                                out.print("</td>");
                                out.print("<td>");
                                    out.print("<a href='http://localhost:8080/LO54_Projet_Front_End/ModifierSession?id="+ses.getId()+"'>Modifier</a>");
                                out.print("</td>");
                                out.print("<td>");
                                    out.print("<a href='http://localhost:8080/LO54_Projet_Front_End/SupprimerSession?id="+ses.getId()+"'>Supprimer</a>");
                                out.print("</td>");
                            out.print("</tr>");
                       }
                    %>
                 </tbody> 
        </table>
    </html> 
        
    </body>
</html>
