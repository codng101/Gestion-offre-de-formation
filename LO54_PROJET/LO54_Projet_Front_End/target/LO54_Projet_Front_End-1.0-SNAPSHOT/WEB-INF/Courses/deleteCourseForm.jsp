<%-- 
    Document   : deleteCourseForm
    Created on : 10 juin 2019, 19:31:07
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
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/MontrerCours'>Liste des cours</a></li>
              <li class="breadcrumb-item active" aria-current="page">Supression du cours</li>
            </ol>
        </nav>
        <form style='margin-left: 10px;' action='SupprimerCours' method='post' accept-charset="UTF-8">
            <h1 class="text-danger">ATTENTION, vous êtes sur le point de supprimer le cours <%= request.getParameter("code")%></h1>
            <h2 class="text-danger">cliquez sur le bouton "supprimer" pour continuer ou cliquez sur "retour" pour revenir en arrière</h2>
            <div class="form-group">
              <input type="hidden" class="form-control" name="code" id='code' value="<%= request.getParameter("code")%>">
              <input type="hidden" id="titre" name="titre" value="<%= request.getParameter("titre")%>">
            </div>
            <button type="submit" id='button_del_cours' class="btn btn-danger">Supprimer</button>
        </form>
        <a href="http://localhost:8080/LO54_Projet_Front_End/MontrerCours" style="margin-left:10px;" >Retour</a>
    </body>
</html>