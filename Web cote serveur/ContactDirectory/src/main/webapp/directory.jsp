<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Contacts</title>
</head>
<body>
    <h1>Liste des Contacts</h1>
    <table border="1">
        <tr>
            <th>Pr�nom</th>
            <th>Nom</th>
            <th>T�l�phone</th>
        </tr>
        <c:forEach var="contact" items="${contacts}">
            <tr>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>
                <td>${contact.phoneNumber}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="directory?page=new">Ajouter un nouveau contact</a><br>
    <a href="index.html">Retour � l'accueil</a>
</body>
</html>
