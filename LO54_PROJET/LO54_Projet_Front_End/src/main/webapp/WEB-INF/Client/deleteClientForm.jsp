<%-- 
    Document   : deleteClientForm
    Created on : 12 juin 2019, 21:27:04
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
         <% String id = (String) request.getAttribute("id"); %>
        <title>Supression d'un client</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/VoirClients'>Liste des clients</a></li>
              <li class="breadcrumb-item active" aria-current="page">Supression du client</li>
            </ol>
        </nav>
        <form style='margin-left: 10px;' action='SupprimerClient' method='post' accept-charset="UTF-8">
            <h1 class="text-danger">ATTENTION, vous êtes sur le point de supprimer le client <%out.print(id);%></h1>
            <h2 class="text-danger">cliquez sur le bouton "supprimer" pour continuer ou cliquez sur "retour" pour revenir en arrière</h2>
            <div class="form-group">
              <input type="hidden" class="form-control" name="id" id='id' value="<%out.print(id);%>">
            </div>
            <button type="submit" id='button_del_cours' class="btn btn-danger">Supprimer</button>
        </form>
        <a href="http://localhost:8080/LO54_Projet_Front_End/VoirClients" style="margin-left:10px;" >Retour</a>
    </body>
</html>
