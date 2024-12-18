<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/styles.css">
    <title>Répertoire des contacts</title>
    
    <style type="text/css">
	    h1 {
	    margin: 20px 0 20px 0; 
	    color: #18203d;
		}
		
		table{
		
		    border: 1px solid black;
		    width:100%; 
		    border-collapse: collapse;
		}
		
		th, td {
			border: 1px solid black;
		    
		    padding: 10px;
		    text-align: center; 
		}
		
		button {
		    padding: 0.5em 0.7em;
		    border: 1px solid #18203d;
		    border-radius: 0.375rem;
		    margin: 20px 0 0 0; 
		    color: #18203d;
		    background-color: white; 
		    cursor: pointer;
		    transition: all 0.3s ease;
		}
		
		button:hover {
		    background-color: #18203d;
		    color: white;
		}
    </style>
    
</head>

<body>
    <div style="text-align:center">
        <h1>Répertoire des contacts</h1>
        
        <table >
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Téléphone</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <!-- Utilisation de JSTL pour itérer sur les contacts -->
                <c:forEach var="contact" items="${contacts}">
                    <tr>
                        <td>${contact.name}</td>
                        <td>${contact.phone}</td>
                        <td>${contact.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <!-- Bouton pour ajouter un contact -->
        <form action="directory" method="GET">
            <input type="hidden" name="page" value="new" />
            <button type="submit">Ajouter un nouveau contact</button>
        </form>
    </div>
</body>

</html>
