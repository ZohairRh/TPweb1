<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Demoing REST API with JS client</title>
</head>
<body>
    <h1>Hello REST Client</h1>
    <main class="container">
		<div id="response"></div>
    </main>
    
    <script type="text/javascript">
    
    // JS code need to be in a IIFE to make it works with await
    (async () => {
    	// build the URL
	    const baseUrl = "http://localhost:8080/BookREST/api/hello/";
	    const message = "MasterSID";
	    const url = baseUrl + message;
	    
	    // launch HTTP request and wait the response
	    let response = await fetch(url, {
	    	  headers: {
	    		    Accept: "text/html"
	    		  }
	    		});
	    // convert response into raw text
	    let textResponse = await response.text();
	    // and print the result in the 'response' div
	    document.getElementById("response").innerHTML = textResponse;
    })() 
    
    </script>

</body>
</html>