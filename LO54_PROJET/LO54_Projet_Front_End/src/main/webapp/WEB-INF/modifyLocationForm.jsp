<%-- 
    Document   : modifyLocationForm
    Created on : 10 juin 2019, 15:44:21
    Author     : El Popcorn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modification d'un lieux</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/VoirLieux'>Liste des lieux</a></li>
              <li class="breadcrumb-item active" aria-current="page">Modification du lieu</li>
            </ol>
        </nav>
        <form style='margin-left: 10px;' action='ModifierLieu' method='post' accept-charset="UTF-8">
            <div class="form-group">
              <label for="city">Nom de la ville</label>
              <input type="text" class="form-control" name="city" id='city' placeholder="<%= request.getParameter("city")%>">
              <input type="hidden" id="id" name="id" value="<%= request.getParameter("id")%>">
            </div>
            <button type="submit" id='button_mod_city' class="btn btn-primary">Enregistrer</button>
        </form>
    </body>
</html>
