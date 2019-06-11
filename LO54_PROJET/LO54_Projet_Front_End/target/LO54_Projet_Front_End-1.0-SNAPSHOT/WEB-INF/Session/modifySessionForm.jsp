<%-- 
    Document   : modifySessionForm
    Created on : 11 juin 2019, 19:19:03
    Author     : Victor
--%>


<%@page import="fr.utbm.lo54.front.lo54_projet_front_end.entity.Location"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.lo54.front.lo54_projet_front_end.entity.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        Course course = (Course) request.getAttribute("course");
        Location location = (Location) request.getAttribute("location");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Création des sessions</title>
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/VoirSessions'>Liste des sessions</a></li>
              <li class="breadcrumb-item active" aria-current="page">Modification</li>
            </ol>
        </nav>
                
        <form name="addSession" style='margin-left: 10px;width: 50%' action='ModifierSession' method='post' accept-charset="UTF-8">
            <input type="text" name="idSession" hidden="true" value="<% int id = (int)request.getAttribute("sessionId"); out.print(id);%>"> 
            <div class="form-group">
                <label for="courseList" class="text-info" >Sélectionner un cours :</label>
                <select id="courseList" name="courseList">
                    <% 
                        out.print("<option value="+course.getCode()+">"+course.getCode()+"</option>");
                    %>
                </select>
            </div>
            <div class="form-group">
                <label for="locationList" class="text-info" >Sélectionner un lieu :</label>
                <select id="locationList" name="locationList">
                    <% 
                        out.print("<option value="+location.getId()+">"+location.getCity()+"</option>");
                    %>
                </select>
            </div>
            <div class="form-group">
              <label for="heureDeb">Heure de début</label>
              <input type="time" class="form-control" name="heureDeb" id='heureDeb' value="<%request.getAttribute("sessionStart");%>">
            </div>
            <div class="form-group">
              <label for="heureFin">Heure de fin</label>
              <input type="time" class="form-control" name="heureFin" id='heureFin' value="<%request.getAttribute("sessionStop");%>">
            </div>
            <div class="form-group">
              <label for="nbMax">Nombre de places</label>
              <input type="number" class="form-control" name="nbMax" id='nbMax' value="<%request.getAttribute("sessionSize");%>">
            </div>
            <button type="submit" id='button_add_session' class="btn btn-primary">Modifier</button>
        </form>
    
    </body>
</html>
