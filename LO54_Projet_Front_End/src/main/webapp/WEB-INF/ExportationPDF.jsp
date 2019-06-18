<%-- 
    Document   : ExportationPDF
    Created on : 15 juin 2019, 15:31:35
    Author     : guill
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Exportation de pdfs</title>
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href='http://localhost:8080/LO54_Projet_Front_End/index.html'>Acceuil</a></li>
              <li class="breadcrumb-item active" aria-current="page">Exportation de pdfs</li>
            </ol>
        </nav>
        <div class="jumbotron-fluid">
            <h1>Choisissez le type d'export que vous souhaitez faire, puis cliquez sur "Enregistrer"</h1>
        </div>
        <div style="width:50%;margin-left:5px;margin-bottom:15px">
            <select class="custom-select" name="selectExport" form="formExport">
                <option value="1">Liste des client</option>
                <option value="2">Liste des courses</option>
            </select>
        </div>
        <form style='margin-left: 5px;width:50%' id="formExport" action='ExportationPDF' method='post' accept-charset="UTF-8">
            <button type="submit" id='button_render_pdf' class="btn btn-primary">Enregistrer</button>
        </form>
    </body>
</html>
