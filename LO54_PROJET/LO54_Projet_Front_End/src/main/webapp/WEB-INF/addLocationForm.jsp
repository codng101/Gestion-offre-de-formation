<%-- 
    Document   : addLocation
    Created on : 8 juin 2019, 16:34:59
    Author     : El Popcorn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Création des lieux</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="boots.css">
    </head>
    <body>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="/localhost:8080/index.html">Acceuil</a></li>
              <li class="breadcrumb-item active" aria-current="page">Lieux</li>
            </ol>
        </nav>
        <form>
            <div class="form-group">
              <label for="exampleInputEmail1">Nom de la ville</label>
              <input type="email" class="form-control" id="city" aplaceholder="Entrez le nom de la ville...">
            </div>
           
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
