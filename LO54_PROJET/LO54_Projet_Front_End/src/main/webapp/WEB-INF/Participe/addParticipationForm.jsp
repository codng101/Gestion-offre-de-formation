<%-- 
    Document   : addParticipationForm
    Created on : 13 juin 2019, 15:00:14
    Author     : Victor
--%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.lo54.front.lo54_projet_front_end.entity.Sessions"%>
<%@page import="fr.utbm.lo54.front.lo54_projet_front_end.entity.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        List<Client> clients = (List<Client>) request.getAttribute("clients");
        List<Sessions> sessions = (List<Sessions>) request.getAttribute("sessions");
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
              <li class="breadcrumb-item active" aria-current="page">Inscription à une session</li>
            </ol>
        </nav>
       <form name="addSession" style='margin-left: 10px;width: 50%' action='AjouterParticipation' method='post' accept-charset="UTF-8">
            <div class="form-group">
                <label for="clientList" class="text-info" >Sélectionner un cours :</label>
                <select id="clientList" name="clientList" required>
                    <% for (Client cli : clients) 
                        {
                            out.print("<option value="+cli.getID()+">"+(cli.getFirstname()+" "+ cli.getLastname())+"</option>");
                        }
                    %>
                </select>
            </div>
            <div class="form-group">
                <label for="sessionList" class="text-info" >Sélectionner un lieu :</label>
                <select id="sessionList" name="sessionList" required>
                    <% for (Sessions ses : sessions) 
                        {
                            if(ses.getSetClients().size() != ses.getMax())
                            {
                                out.print("<option value="+ses.getId()+">"+ses.getCrs().getCode()+"</option>");
                            }
                        }
                    %>
                </select>
            </div>
            <button type="submit" id='button_add_session' class="btn btn-primary">Enregistrer</button>
        </form>
    </body>
</html>
