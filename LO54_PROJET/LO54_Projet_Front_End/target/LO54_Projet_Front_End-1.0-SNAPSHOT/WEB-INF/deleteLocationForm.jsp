<%-- 
    Document   : deleteLocationForm
    Created on : 10 juin 2019, 16:32:07
    Author     : El Popcorn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Supression d'un lieux</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    <body style="margin-left: 10px">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/VoirLieux'>Liste des lieux</a></li>
              <li class="breadcrumb-item active" aria-current="page">Supression du lieu</li>
            </ol>
        </nav>
        <h1 class="text-danger">ATTENTION, vous êtes sur le point de supprimer la ville <%= request.getParameter("city")%></h1>
        <h2 class="text-danger">cliquez sur le bouton "supprimer" pour continuer ou cliquez sur "retour" pour revenir en arrière</h2>
        <form style='margin-left: 10px;' action='SupprimerLieu' method='post' accept-charset="UTF-8">
            <div class="form-group">
              <input type="hidden" class="form-control" name="city" id='city' placeholder="<%= request.getParameter("city")%>">
              <input type="hidden" id="id" name="id" value="<%= request.getParameter("id")%>">
            </div>
            <button type="submit" id='button_mod_city' class="btn btn-danger">Supprimer</button>
        </form>
        <a href="http://localhost:8080/LO54_Projet_Front_End/VoirLieux" style="margin-left:10px;" >Retour</a>
    </body>
</html>
