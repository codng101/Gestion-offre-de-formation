<%-- 
    Document   : addClientForm
    Created on : 12 juin 2019, 14:04:31
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Création de client</title>
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
              <li class="breadcrumb-item active" aria-current="page">Création des clients</li>
            </ol>
        </nav>
        <form style='margin-left: 10px; width: 50%;' action='AjouterClient' method='post' accept-charset="UTF-8">
            <div class="form-group">
              <label for="lName">Nom de famille</label>
              <input type="text" class="form-control" name="lName" id='lName' placeholder="Entrez le nom de famille...">
              <label for="fName">Prénom</label>
              <input type="text" class="form-control" name="fName" id='fName' placeholder="Entrez le prénom...">
              <label for="adress">Adresse</label>
              <input type="text" class="form-control" name="adress" id='adress' placeholder="Entrez votre adresse..">
              <label for="telephone">Telephone</label>
              <input type="tel" class="form-control" name="telephone" id='telephone' placeholder="Ex: 0123456789 /+33123456789" pattern="[0-9]{10}|\+33[0-9]{9}" required>
              <label for="mail">Adresse mail</label>
              <input type="email" class="form-control" name="mail" id='mail' placeholder="Ex: jean@bon.fr" pattern="^[^\W][a-zA-Z0-9_]+(\.[a-zA-Z0-9_]+)*\@[a-zA-Z0-9_]+(\.[a-zA-Z0-9_]+)*\.[a-zA-Z]{2,4}$">
            </div>
            <button type="submit" id='button_add_city' class="btn btn-primary">Enregistrer</button>
        </form>
    </body>
</html>
