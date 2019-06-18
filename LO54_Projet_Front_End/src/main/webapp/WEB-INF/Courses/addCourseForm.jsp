<%-- 
    Document   : addLocation
    Created on : 8 juin 2019, 16:34:59
    Author     : El Popcorn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Création des lieux</title>
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
              <li class="breadcrumb-item active" aria-current="page">Cours</li>
            </ol>
        </nav>
        <form style='margin-left: 10px;width:50%' action='AjouterCours' method='post' accept-charset="UTF-8">
            <div class="form-group">
              <label for="code">Code du cours</label>
              <input type="text" class="form-control" name="code" id='code' placeholder="Entrez le code du cours..." required>
              <label for="titre">Titre du cours</label>
              <input type="text" class="form-control" name="titre" id='titre' placeholder="Entrez le titre du cours..." required>
            </div>
            <button type="submit" id='button_add_city' class="btn btn-primary">Enregistrer</button>
        </form>
    </body>
</html>
