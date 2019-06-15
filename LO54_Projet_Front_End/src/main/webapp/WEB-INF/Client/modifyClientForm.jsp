<%-- 
    Document   : modifyClientForm
    Created on : 12 juin 2019, 20:57:34
    Author     : Victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
         <%
            String name = (String) request.getAttribute("lName");
            String fname = (String) request.getAttribute("fName");
            String adress = (String) request.getAttribute("adress");
            String telephone = (String) request.getAttribute("telephone");
            String mail = (String) request.getAttribute("mail");
            String id = (String) request.getAttribute("id");
         %>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Modification de client</title>
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/VoirClients'>Liste des cours</a></li>
              <li class="breadcrumb-item active" aria-current="page">Modification des clients</li>
            </ol>
        </nav>
        <form style='margin-left: 10px; width: 50%;' action='ModifierClient' method='post' accept-charset="UTF-8">
            <div class="form-group">
                <input type="hidden" name="id" value="<% out.print(id);%>">
                <label for="lName">Nom de famille</label>
                <input type="text" class="form-control" name="lName" id='lName' placeholder="<% out.print(name); %>" required >
                <label for="fName">Prénom</label>
                <input type="text" class="form-control" name="fName" id='fName' placeholder="<% out.print(fname);%>" required>
                <label for="adress">Adresse</label>
                <input type="text" class="form-control" name="adress" id='adress' placeholder="<% out.print(adress); %>" required>
                <label for="telephone">Telephone</label>
                <input type="tel" class="form-control" name="telephone" id='telephone' placeholder="<% out.print(telephone); %>" pattern="[0-9]{10}|\+33[0-9]{9}" required>
                <label for="mail">Adresse mail</label>
                <input type="email" class="form-control" name="mail" id='mail' placeholder="<% out.print(mail); %>" pattern="^[^\W][a-zA-Z0-9_]+(\.[a-zA-Z0-9_]+)*\@[a-zA-Z0-9_]+(\.[a-zA-Z0-9_]+)*\.[a-zA-Z]{2,4}$" required >
            </div>
            <button type="submit" id='button_modify_session' class="btn btn-primary">Enregistrer</button>
        </form>
    </body>
</html>
