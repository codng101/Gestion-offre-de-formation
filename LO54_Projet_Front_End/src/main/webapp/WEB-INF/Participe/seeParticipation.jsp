<%-- 
    Document   : seeParticipation
    Created on : 13 juin 2019, 19:10:23
    Author     : Victor
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions"%>
<%@page import="fr.utbm.lo54.front.lo54_projet_front_end.entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Client current =(Client) request.getAttribute("client");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listes des sessions de <%= current.getFirstname()+" "+current.getLastname() %></title>
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
                <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/VoirClients'>Liste des clients</a></li>
                <li class="breadcrumb-item active" aria-current="page">Sessions</li>
            </ol>
        </nav>
        <div class="display-1">
            <h1>Listes des sessions de <%= current.getFirstname()+" "+current.getLastname() %></h1>
        </div>
        <table class="table">
            <thead class="thead-light">
                <th scope="col">Titre</th>
                <th scope="col">Lieu</th>
                <th scope="col">Date & heure de début</th>
                <th scope="col">Date & heure de fin</th>
                <th scope="col"></th>
            </thead>
            <tbody>
                <%
                    List<Sessions> sessions = new ArrayList<>(current.getSessions());
                    
                    Collections.sort(sessions, new Comparator<Sessions>() 
                    {
                        public int compare(Sessions o1, Sessions o2) 
                        {
                            return o1.getStartDate().compareTo(o2.getStartDate());
                        }
                    });
                    for (Sessions ses : sessions)
                    {
                        out.print("<tr>");
                            out.print("<td>");
                                out.print(ses.getCrs().getTitle());
                            out.print("</td>");
                            out.print("<td>");
                                out.print(ses.getLoc().getCity());
                            out.print("</td>");
                            out.print("<td>");
                                out.print(ses.getStartDate());
                            out.print("</td>");
                            out.print("<td>");
                                out.print(ses.getEndDate());
                            out.print("</td>");
                            out.print("<td>");
                                out.print("<a href='http://localhost:8080/LO54_Projet_Front_End/DesinscrireClient?idCli="+current.getID()+"&idSes="+ses.getId()+"'>Désinscription</a>");
                            out.print("</td>");
                        out.print("</tr>");
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
