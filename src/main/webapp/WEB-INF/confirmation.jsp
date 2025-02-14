<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Creation Inscription</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<p class="info"></p>
<p>Nom : ${member.nom}</p>
<p>Prénom : ${member.prenom}</p>
<p>Email : ${member.email}</p>
<p>Date de naissance : ${member.date}</p>
<p>Téléphone : ${member.telephone}</p>
<p>Sexe : ${member.sexe}</p>
<p>Password : ${member.password}</p>
<p>Pays : ${member.pays}</p>
</body>
</html>