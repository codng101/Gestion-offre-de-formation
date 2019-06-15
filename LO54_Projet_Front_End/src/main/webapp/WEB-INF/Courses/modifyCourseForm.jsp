<%-- 
    Document   : modifyCourseForm
    Created on : 10 juin 2019, 19:13:52
    Author     : El Popcorn
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modification d'un cours</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/VoirCours'>Liste des cours</a></li>
              <li class="breadcrumb-item active" aria-current="page">Modification du cours</li>
            </ol>
        </nav>
        <form style='margin-left: 10px;' action='ModifierCours' method='post' accept-charset="UTF-8">
            <div class="form-group">
              <label for="titre">Titre du cours</label>
              <input type="text" class="form-control" name="titre" id='titre' placeholder="<%= request.getParameter("titre")%>" required>
              <input type="hidden" id="code" name="code" value="<%= request.getParameter("code")%>">
            </div>
            <button type="submit" id='button_mod_city' class="btn btn-primary">Enregistrer</button>
        </form>
    </body>
</html>
