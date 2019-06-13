<%-- 
    Document   : deleteParticipant
    Created on : 13 juin 2019, 19:44:52
    Author     : Victor
--%>

<%@page import="fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions"%>
<%@page import="fr.utbm.lo54.front.lo54_projet_front_end.entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Client cli =(Client) request.getAttribute("client");
        Sessions ses = (Sessions) request.getAttribute("session");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Désinscription</title>
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
                <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/VoirClients'>Liste des clients</a></li>
                <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/VoirClients'>Sessions</a></li>
                <li class="breadcrumb-item active" aria-current="page">Désinscription</li>
            </ol>
        </nav>
        <form style='margin-left: 10px;' action='DesinscrireClient' method='post' accept-charset="UTF-8">
            <h1 class="text-danger">ATTENTION, vous êtes sur le point de désinscrire le client <% out.print(cli.getFirstname()+" "+cli.getLastname());%></h1>
            <h2 class="text-danger">de la session <% out.print(ses.getCrs().getTitle()+" du "+ses.getStartDate());%></h2>
            <br/>
            <h2 class="text-danger">cliquez sur le bouton "supprimer" pour continuer ou cliquez sur "retour" pour revenir en arrière</h2>
            <div class="form-group">
              <input type="hidden" class="form-control" name="idC" id='idC' value="<%out.print(cli.getID());%>">
              <input type="hidden" class="form-control" name="idSes" id='idSes' value="<%out.print(ses.getId());%>">
            </div>
            <button type="submit" id='button_del_cours' class="btn btn-danger">Supprimer</button>
        </form>
        <a href="http://localhost:8080/LO54_Projet_Front_End/VoirSessionsClient" style="margin-left:10px;" >Retour</a>
    </body>
</html>
