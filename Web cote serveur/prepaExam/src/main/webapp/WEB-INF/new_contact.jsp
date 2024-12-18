<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/resources/css/styles.css">
    <title>Ajouter un nouveau contact</title>
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
	    <h1>Ajouter un nouveau contact</h1>
	    <form action="directory" method="POST">
	        <label for="name">Nom:</label>
	        <input type="text" id="name" name="name" required /><br><br>
	        
	        <label for="phone">Numéro de téléphone:</label>
	        <input type="text" id="phone" name="phone" required /><br><br>
	        
	        <label for="email">Email:</label>
	        <input type="email" id="email" name="email" required /><br><br>
	        
	        <button type="submit">Ajouter</button>
	    </form>
	
	    <br>
	    <!-- Si une erreur se produit, afficher un message -->
	    <c:if test="${not empty errorMessage}">
	        <p style="color:red">${errorMessage}</p>
	    </c:if>
    </div>
</body>
</html>
