<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Page Inscription</title>
    <meta charset="UTF-8">
    <link href="style/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form action="inscription" method="post">
    <fieldset>
        <legend>Inscription utilisateur</legend>
        <table border="0">
            <tr>
                <td>Nom</td>
                <td><input type="text" name="nom" /></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Prénom</td>
                <td><input type="text" name="prenom" /></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" id ="email" name="email" /></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Date de Naissance</td>
                <td><input type="date" name="date" /></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Téléphone</td>
                <td><input type="tel" name="telephone" /></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Sexe</td>
                <td>
                    <input type="radio" name="sexe" value="M" />M
                    <input type="radio" name="sexe" value="F" />F
                </td>
                <td>*</td>
            </tr>
            <tr>
                <td>Mot de passe</td>
                <td><input id="pass1" type="password" name="password"
                           value="" /></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Confirmer mot de passe</td>
                <td><input id="pass2" type="password"
                           name="confirmation_password" value="" /></td>
                <td>*</td>
            </tr>
            <tr>
                <td>Pays</td>
                <td><select name="pays">
                    <option>France</option>
                    <option>Espagne</option>
                </select></td>
                <td>*</td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Valider" /><input
                        type="reset" value="Cancel" /></td>
                <td></td>
            </tr>
        </table>
        <p class="erreur">${erreurs}</p>
    </fieldset>
</form>
</body>
</html>